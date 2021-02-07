package com.rehabilitation;

import com.rehabilitation.AntColonyOptimization.*;
import com.rehabilitation.Dto.*;
import com.rehabilitation.configuration.ProblemConfig;
import com.rehabilitation.service.*;
import isula.aco.AcoProblemSolver;
import isula.aco.Ant;
import isula.aco.AntColony;
import isula.aco.algorithms.acs.PseudoRandomNodeSelection;
import isula.aco.algorithms.antsystem.StartPheromoneMatrix;
import org.springframework.stereotype.Component;

import javax.naming.ConfigurationException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScheduleClient {
    private static TreatmentServiceImpl treatmentService;
    private static TreatmentScheduleServiceImpl treatmentScheduleService;
    private static RehabilitationPlanServiceImpl planService;
    private static MachineServiceImpl machineService;
    private static UserServiceImpl userService;

    public static void schedule(int patientId, int locationId, Time openTime, Time closeTime) throws ConfigurationException {
        int numberOfDays = howManyDays(patientId);
        for (int i = 0; i < numberOfDays; i++) {
            double[][] problemRepresentation = getProblem(patientId, locationId, openTime, closeTime, i); //time to czasy otwarcia i zamkniecia ośrodka
            ProblemConfig configurationProvider = new ProblemConfig(problemRepresentation);
            AntColony<Integer, SchedullingEnviroment> colony = getAntColony(configurationProvider);
            SchedullingEnviroment environment = new SchedullingEnviroment(problemRepresentation);
            configurationProvider.setEnvironment(environment);

            AcoProblemSolver<Integer, SchedullingEnviroment> solver = new AcoProblemSolver<>();
            solver.initialize(environment, colony, configurationProvider);
            solver.addDaemonActions(
                    new StartPheromoneMatrix<>(),
                    new SchedullingPheromoneMatrix());
            solver.getAntColony().addAntPolicies(
                    new PseudoRandomNodeSelection<>(),
                    new ApplyLocalSearch());
            solver.solveProblem();
        }
    }

    private static AntColony<Integer, SchedullingEnviroment> getAntColony(ProblemConfig configurationProvider) {
        return new AntColony<Integer, SchedullingEnviroment>(configurationProvider.getNumberOfAnts()) {
            @Override
            protected Ant<Integer, SchedullingEnviroment> createAnt(SchedullingEnviroment environment) {
                return new AntForSchedulling();
            }
        };
    }

    public static double[][] getProblem(int patientId, int locationId, Time openTime, Time closeTime, int whichDay){
        List<TreatmentResponse> treatments = treatmentService.getPlan(patientId, whichDay);
        List<RehabilitationPlanResponse> plans = planService.getPatient(patientId);
        RehabilitationPlanResponse thePlan = plans.get(0);
        Date maxDate = plans.get(0).getCreation_date();
        for (RehabilitationPlanResponse plan : plans) {
            if (plan.getCreation_date().after(maxDate)) {
                thePlan = plan;
                maxDate = plan.getCreation_date();
            }
        }
        int numberOfTreatments = treatments.size();
        List<Time> possibleHoursMachine = new ArrayList<>();
        List<Time> possibleHoursWorker = new ArrayList<>();

        for (TreatmentResponse treatmentResponse : treatments) {
                Date date = addDays(thePlan.getStartDate(), whichDay);
                List<MachineResponse> machines = machineService.getPermittedMachines(treatmentResponse.getTreatmentId(), locationId, date);
                for (MachineResponse machineResponse : machines) {
                    possibleHoursMachine = treatmentScheduleService.getHours(machineResponse.getMachine_id(), date, openTime, closeTime, treatmentResponse.getDuration());
                }
                List<UserResponse> workers = userService.getPermittedWorkers(treatmentResponse.getTreatmentId(), locationId, date);
                for (UserResponse userResponse : workers) {
                    possibleHoursWorker = treatmentScheduleService.getHoursWorker(userResponse.getId(), date, treatmentResponse.getDuration());
                }
                List<Time> possibleHours = possibleHoursMachine.stream()
                                                                .filter(possibleHoursWorker::contains)
                                                                .collect(Collectors.toList());
                for (MachineResponse machineResponse : machines){
                    for (UserResponse user : workers){
                        for (Time hour : possibleHours){
                            Node node = new Node(machineResponse.getMachine_id(), user.getId(), date, hour);
                        }
                    }
                }

        }
        int numberOfCombinations;
        double[][] problemRepresentation = new double[numberOfTreatments][numberOfTreatments];


        return problemRepresentation;
    }

    public static Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        return new Date(c.getTimeInMillis());
    }

    public static int howManyDays(int patientId){
        List<TreatmentResponse> treatments = treatmentService.getPlan(patientId, 0);
        int numberOfDays = treatments.get(0).getRepeat_number();

        for (TreatmentResponse treatmentResponse : treatments) {
            if (treatmentResponse.getRepeat_number() > numberOfDays){
                numberOfDays = treatmentResponse.getRepeat_number();
            }
        }
        return numberOfDays;
    }
}
