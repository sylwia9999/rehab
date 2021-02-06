package com.rehabilitation;

import com.rehabilitation.AntColonyOptimization.AntForSchedulling;
import com.rehabilitation.AntColonyOptimization.ApplyLocalSearch;
import com.rehabilitation.AntColonyOptimization.SchedullingEnviroment;
import com.rehabilitation.AntColonyOptimization.SchedullingPheromoneMatrix;
import com.rehabilitation.Dto.MachineResponse;
import com.rehabilitation.Dto.RehabilitationPlanResponse;
import com.rehabilitation.Dto.TreatmentResponse;
import com.rehabilitation.Dto.UserResponse;
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
import java.util.List;

@Component
public class ScheduleClient {
    private static TreatmentServiceImpl treatmentService;
    private static RehabilitationPlanServiceImpl planService;
    private static MachineServiceImpl machineService;
    private static UserServiceImpl userService;

    public static void schedule(int patientId, int locationId) throws ConfigurationException {
        double[][] problemRepresentation = getProblem(patientId, locationId);
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

    private static AntColony<Integer, SchedullingEnviroment> getAntColony(ProblemConfig configurationProvider) {
        return new AntColony<Integer, SchedullingEnviroment>(configurationProvider.getNumberOfAnts()) {
            @Override
            protected Ant<Integer, SchedullingEnviroment> createAnt(SchedullingEnviroment environment) {
                return new AntForSchedulling();
            }
        };
    }

    public static double[][] getProblem(int patientId, int locationId){
        List<TreatmentResponse> treatments = treatmentService.getPlan(patientId);
        List<RehabilitationPlanResponse> plans = planService.getPatient(patientId);
        RehabilitationPlanResponse thePlan;
        Date maxDate = Date.valueOf("1900-01-01");
        for (RehabilitationPlanResponse plan : plans) {
            if (plan.getCreation_date().after(maxDate)) {
                thePlan = plan;
            }
        }
        int numberOfDays = treatments.get(0).getRepeat_number();
        int numberOfTreatments = treatments.size();
        for (TreatmentResponse treatmentResponse : treatments) {
            List<MachineResponse> machines = machineService.getPermittedMachines(treatmentResponse.getTreatmentId(), locationId);
            List<UserResponse> workers = userService.getPermittedWorkers(treatmentResponse.getTreatmentId(), locationId);

        }
        int numberOfCombinations;
        double[][] problemRepresentation = new double[numberOfTreatments][numberOfTreatments];


        return problemRepresentation;
    }
}
