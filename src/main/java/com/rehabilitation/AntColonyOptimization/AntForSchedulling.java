package com.rehabilitation.AntColonyOptimization;

import isula.aco.Ant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AntForSchedulling extends Ant<Integer, SchedullingEnviroment> {
    private static final double VALUE_NOT_USED = 1.0;

    public AntForSchedulling() {
        super();
        this.setSolution(new ArrayList<>());
        this.setVisited(new HashMap<>());
    }

    @Override
    public boolean isSolutionReady(SchedullingEnviroment environment) {
        return getCurrentIndex() == environment.getNumberOfTreatments();
    }

    @Override
    public double getSolutionCost(SchedullingEnviroment environment, List<Integer> solution) {
        return getScheduleMakespan(solution, environment.getProblemRepresentation());
    }

    @Override
    public Double getHeuristicValue(Integer solutionComponent,
                                    Integer positionInSolution, SchedullingEnviroment environment) {
        return VALUE_NOT_USED;
    }

    @Override
    public List<Integer> getNeighbourhood(SchedullingEnviroment environment) {
        List<Integer> neighbours = new ArrayList<>();
        for (int l = 0; l < environment.getNumberOfTreatments(); l++) {
            neighbours.add(l);
        }
        return neighbours;
    }

    @Override
    public Double getPheromoneTrailValue(Integer solutionComponent,
                                         Integer positionInSolution, SchedullingEnviroment environment) {

        double[][] pheromoneMatrix = environment.getPheromoneMatrix();
        return pheromoneMatrix[solutionComponent][positionInSolution];
    }

    @Override
    public void setPheromoneTrailValue(Integer solutionComponent, Integer positionInSolution,
                                       SchedullingEnviroment environment, Double value) {
        double[][] pheromoneMatrix = environment.getPheromoneMatrix();

        pheromoneMatrix[solutionComponent][positionInSolution] = value;
    }

    public static double getScheduleMakespan(List<Integer> schedule, double[][] jobInfo) {
        int machines = jobInfo[0].length;
        double[] machinesTime = new double[machines];
        double timeStep;

        for (Integer job : schedule) {
            for (int i = 0; i < machines; i++) {
                timeStep = jobInfo[job][i];
                if (i == 0) {
                    machinesTime[i] = machinesTime[i] + timeStep;
                } else {
                    if (machinesTime[i] > machinesTime[i - 1]) {
                        machinesTime[i] = machinesTime[i] + timeStep;
                    } else {
                        machinesTime[i] = machinesTime[i - 1] + timeStep;
                    }
                }
            }
        }
        return machinesTime[machines - 1];
    }


}
