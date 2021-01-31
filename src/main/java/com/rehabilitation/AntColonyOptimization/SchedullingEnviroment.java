package com.rehabilitation.AntColonyOptimization;

import isula.aco.Environment;
import isula.aco.exception.InvalidInputException;
import isula.aco.exception.MethodNotImplementedException;

public class SchedullingEnviroment extends Environment {

    /**
     * In this matrix, jobs represent rows and columns are the time required per machine.
     */
    private double[][] problemRepresentation;

    private int numberOfJobs;

    /**
     * Environment for the Flow Shop Scheduling Problem.
     *
     * @param problemGraph Graph representation of the problem.
     * @throws InvalidInputException When the graph is incorrectly formed.
     */
    public SchedullingEnviroment(double[][] problemGraph) throws InvalidInputException {
        super();

        if (this.isProblemRepresentationValid(problemGraph)) {
            this.problemRepresentation = problemGraph;
            this.setPheromoneMatrix(createPheromoneMatrix());
        } else {
            throw new InvalidInputException();
        }

        this.numberOfJobs = problemGraph.length;
    }

    public int getNumberOfJobs() {
        return getProblemRepresentation().length;
    }

    protected boolean isProblemRepresentationValid(double[][] problemRepresentation) {
        int numberOfMachines = problemRepresentation[0].length;
        int jobs = problemRepresentation.length;

        for (int i = 1; i < jobs; i++) {
            if (problemRepresentation[i].length != numberOfMachines) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected double[][] createPheromoneMatrix()
            throws MethodNotImplementedException {
        if (this.getProblemRepresentation() != null) {
            int jobs = getNumberOfJobs();
            return new double[jobs][jobs];
        }

        return null;

    }

    public double[][] getProblemRepresentation() {
        return problemRepresentation;
    }
}
