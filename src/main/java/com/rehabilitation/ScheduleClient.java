package com.rehabilitation;

import com.rehabilitation.AntColonyOptimization.AntForSchedulling;
import com.rehabilitation.AntColonyOptimization.ApplyLocalSearch;
import com.rehabilitation.AntColonyOptimization.SchedullingEnviroment;
import com.rehabilitation.AntColonyOptimization.SchedullingPheromoneMatrix;
import com.rehabilitation.configuration.ProblemConfig;
import isula.aco.AcoProblemSolver;
import isula.aco.Ant;
import isula.aco.AntColony;
import isula.aco.algorithms.acs.PseudoRandomNodeSelection;
import isula.aco.algorithms.antsystem.StartPheromoneMatrix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class ScheduleClient {
    private static final boolean DISPLAY_SOLUTION = true;

    /*public static void main(String... args) {
        try {
            //String fileDataset = ProblemConfig.FILE_DATASET;

            //double[][] problemRepresentation = getTaillardProblemFromFile(fileDataset, 20, 5);

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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    private static AntColony<Integer, SchedullingEnviroment> getAntColony(ProblemConfig configurationProvider) {
        return new AntColony<Integer, SchedullingEnviroment>(configurationProvider.getNumberOfAnts()) {
            @Override
            protected Ant<Integer, SchedullingEnviroment> createAnt(SchedullingEnviroment environment) {
                return new AntForSchedulling();
            }
        };
    }

    /**
     * Reads a scheduling instance in the format used in Taillard's benchmarks
     * (http://mistic.heig-vd.ch/taillard/problemes.dir/ordonnancement.dir/ordonnancement.html)
     *
     * @param fileName         File name
     * @param numberOfJobs     Jobs to consider.
     * @param numberOfMachines Machines available.
     * @return Matrix representation of the problem.
     */
    public static double[][] getTaillardProblemFromFile(String fileName, int numberOfJobs,
                                                        int numberOfMachines) throws IOException {

        double[][] problemRepresentation = new double[numberOfJobs][numberOfMachines];
        int currentMachine = 0;

        File file = new File(Objects.requireNonNull(ScheduleClient.class.getClassLoader().getResource(fileName)).getFile());

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.trim().split(" ");

                if (tokens.length == numberOfJobs) {
                    for (int jobIndex = 0; jobIndex < tokens.length; jobIndex += 1) {
                        problemRepresentation[jobIndex][currentMachine] = Integer.parseInt(tokens[jobIndex]);
                    }
                    currentMachine += 1;
                }
            }
        }
        return problemRepresentation;
    }
}
