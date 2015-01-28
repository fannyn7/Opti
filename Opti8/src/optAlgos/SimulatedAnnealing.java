package optAlgos;

public class SimulatedAnnealing {
	
		private Problem problem;
		
	
		public SimulatedAnnealing(Problem p) {
			this.problem = p;
		}
		
		public Solution simulatedAnnealingAlgorithm(){
			Solution bestSolution = problem.getRandomSolution();
			Solution randomNeighbour = bestSolution.getRandomNeighbour();
			if (bestSolution.testBestSolution(randomNeighbour)){
					bestSolution = randomNeighbour;
				} else {
					if(bestSolution.makeProbabilisticDecision(randomNeighbour)){
						bestSolution = randomNeighbour;
					}
			}
			return bestSolution;
		}
}
