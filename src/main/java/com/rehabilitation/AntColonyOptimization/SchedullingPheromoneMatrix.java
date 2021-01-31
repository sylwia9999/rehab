package com.rehabilitation.AntColonyOptimization;

import com.rehabilitation.configuration.ProblemConfig;
import isula.aco.Ant;
import isula.aco.algorithms.maxmin.MaxMinConfigurationProvider;
import isula.aco.algorithms.maxmin.UpdatePheromoneMatrixForMaxMin;

public class SchedullingPheromoneMatrix extends
        UpdatePheromoneMatrixForMaxMin<Integer, SchedullingEnviroment> {

    @Override
    protected double getNewPheromoneValue(
            Ant<Integer, SchedullingEnviroment> ant, int positionInSolution,
            Integer solutionComponent,
            MaxMinConfigurationProvider configurationProvider) {

        double contribution = ProblemConfig.Q / ant.getSolutionCost(getEnvironment());

        return ant.getPheromoneTrailValue(solutionComponent,
                positionInSolution, getEnvironment()) + contribution;
    }

    @Override
    protected double getMaximumPheromoneValue(MaxMinConfigurationProvider configurationProvider) {
        double bestSolutionCost = getProblemSolver().getBestSolutionCost();
        if (bestSolutionCost == 0) {
            return configurationProvider.getInitialPheromoneValue();
        }

        return 1 / (1 - configurationProvider.getEvaporationRatio()) / bestSolutionCost;
    }

    @Override
    protected double getMinimumPheromoneValue(MaxMinConfigurationProvider configurationProvider) {
        return this.getMaximumPheromoneValue(configurationProvider) / 5;
    }

}
