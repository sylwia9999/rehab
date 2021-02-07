package com.rehabilitation.AntColonyOptimization;
import isula.aco.Environment;

public class SchedullingEnviroment extends Environment {
     //In this matrix, jobs represent rows and columns are the time required per machine.
    private double[][] problemRepresentation;
    private int numberOfTreatments;

    public SchedullingEnviroment(double[][] problemGraph) {
        super();
        this.problemRepresentation = problemGraph;
        this.setPheromoneMatrix(createPheromoneMatrix());

        this.numberOfTreatments = problemGraph.length;
    }

    public int getNumberOfTreatments() {
        return getProblemRepresentation().length;
    }

    public double[][] getProblemRepresentation() {
        return problemRepresentation;
    }

    public int getNumberOfOptions(int treatmentNumber) {
        double[][] graph = getProblemRepresentation();
        return graph[treatmentNumber].length;
    }

    @Override
    protected double[][] createPheromoneMatrix(){
        if (this.getProblemRepresentation() != null) {
            int treatments = getNumberOfTreatments();

            return new double[treatments][treatments];
        }
        return null;
    }

}
