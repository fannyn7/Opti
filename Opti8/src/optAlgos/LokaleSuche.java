package optAlgos;

import java.util.ArrayList;

public class LokaleSuche {

	private Problem problem;
	
	public LokaleSuche(Problem p){
		this.problem = p;
	}
	
	public Solution lokaleSucheAlgorithm(){
		Solution bestSolution = problem.getRandomSolution();
		ArrayList<Solution> neighbours = bestSolution.getNeighbours();
		for (Solution s : neighbours){
			if (bestSolution.testBestSolution(s)){
				bestSolution = s;
			}
		}
		return bestSolution;
	}
}
