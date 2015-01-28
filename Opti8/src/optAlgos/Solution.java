package optAlgos;

import java.util.ArrayList;

public interface Solution {

	public ArrayList<Solution> getNeighbours();

	public boolean testBestSolution(Solution s);

	public Solution getRandomNeighbour();

	public boolean makeProbabilisticDecision(Solution randomNeighbour);

}
