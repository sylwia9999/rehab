package com.rehabilitation.configuration;

import com.rehabilitation.AntColonyOptimization.AntForSchedulling;
import com.rehabilitation.AntColonyOptimization.SchedullingEnviroment;
import isula.aco.algorithms.acs.AcsConfigurationProvider;
import isula.aco.algorithms.maxmin.MaxMinConfigurationProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProblemConfig implements MaxMinConfigurationProvider, AcsConfigurationProvider {
    public static final int Q = 1;
    private static final int NUMBER_OF_ANTS = 20;
    private static final int VERY_IMPORTANT = 1;
    private static final int NOT_IMPORTANT = 0;
    private static final double EVAPORATION = 0.75;
    private static final int MAX_ITERATIONS = 1000;
    private SchedullingEnviroment environment;
    private double initialPheromone;

    public ProblemConfig(double[][] problemRepresentation) {
        List<Integer> randomSolution = new ArrayList<>();

        for (int jobIndex = 0; jobIndex < problemRepresentation.length; jobIndex++) {
            randomSolution.add(jobIndex);
        }
        Collections.shuffle(randomSolution);
        double randomQuality = AntForSchedulling.getScheduleMakespan(randomSolution, problemRepresentation);

        this.initialPheromone = 1 / (1 - EVAPORATION) / randomQuality;
    }

    public void setEnvironment(SchedullingEnviroment environment) {
        this.environment = environment;
    }

    @Override
    public double getBestChoiceProbability() {
        double[][] problemGraph = this.environment.getProblemRepresentation();
        return (problemGraph.length - this.getBestChoiceConstant()) / (float) problemGraph.length;
    }

    public int getBestChoiceConstant() {
        return 4;
    }

    @Override
    public double getPheromoneDecayCoefficient() {
        return EVAPORATION;
    }

    @Override
    public double getMaximumPheromoneValue() {
        return 0;
    }

    @Override
    public double getMinimumPheromoneValue() {
        return 0;
    }

    @Override
    public int getNumberOfAnts() {
        return NUMBER_OF_ANTS;
    }

    @Override
    public double getEvaporationRatio() {
        return EVAPORATION;
    }

    @Override
    public int getNumberOfIterations() {
        return MAX_ITERATIONS;
    }

    @Override
    public double getInitialPheromoneValue() {
        return this.initialPheromone;
    }

    @Override
    public double getHeuristicImportance() {
        return NOT_IMPORTANT;
    }

    @Override
    public double getPheromoneImportance() {
        return VERY_IMPORTANT;
    }
}
