package com.rehabilitation.AntColonyOptimization;

import isula.aco.AntPolicy;
import isula.aco.AntPolicyType;
import isula.aco.ConfigurationProvider;

import java.util.ArrayList;
import java.util.List;

public class ApplyLocalSearch extends AntPolicy<Integer, SchedullingEnviroment> {

    public ApplyLocalSearch() {
        super(AntPolicyType.AFTER_SOLUTION_IS_READY);
    }

    @Override
    public boolean applyPolicy(SchedullingEnviroment environment,
                               ConfigurationProvider configuration) {

        double bestMakespan = getAnt().getSolutionCost(environment);

        List<Integer> currentSolution = getAnt().getSolution();
        List<Integer> candidateSolution = new ArrayList<>(currentSolution);

        int currentIndex = 0;
        boolean keepSearching = true;

        while (currentIndex < (currentSolution.size()) && keepSearching) {
            int currentJob = candidateSolution.get(currentIndex);
            candidateSolution.remove(currentIndex);
            int candidateIndex = 0;

            while (candidateIndex < currentSolution.size() && keepSearching) {
                candidateSolution.add(candidateIndex, currentJob);

                double candidateMakespan = AntForSchedulling.getScheduleMakespan(
                        candidateSolution, environment.getProblemRepresentation());

                if (candidateMakespan < bestMakespan) {
                    bestMakespan = candidateMakespan;
                    keepSearching = false;
                } else {
                    candidateSolution.remove(candidateIndex);
                }

                candidateIndex++;
            }

            if (keepSearching) {
                candidateSolution.add(currentIndex, currentJob);
            }
            currentIndex++;
        }

        getAnt().setSolution(candidateSolution);

        return true;
    }

}
