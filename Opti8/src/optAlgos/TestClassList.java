package optAlgos;

import java.awt.List;
import java.util.ArrayList;

public class TestClassList {
	
	public static void main(String[] args){
	ArrayList<Integer> listex = new ArrayList<Integer>();
	ArrayList<Integer> listey = new ArrayList<Integer>();
	
//	listex.add(3);
//	listey.add(8);
//	listex.add(35);
//	listey.add(4);
//	listex.add(15);
//	listey.add(18);
//	
//	System.out.println(listex);
//	System.out.println(listey);
//
//	listex.remove(1);
//	listey.remove(new Integer(4));
//	System.out.println(listex);
//	System.out.println(listey);
//	
//	System.out.println("AUTRE TEST");
//	Integer a  = 3 ;
//	Integer b = new Integer(0);
//	b = a ;
//	System.out.println(a + "  " + b);
//	a = 1;
//	System.out.println(a + "  " + b);
//	
	Pair<Integer,Integer> p = new Pair<Integer,Integer>(10,25);
	Pair<Integer,Integer> p2 = new Pair<Integer,Integer>(35,24);
	Pair<Integer,Integer> p3 = new Pair<Integer,Integer>(29,8);
	Pair<Integer,Integer> p4 = new Pair<Integer,Integer>(38,35);



	
	ArrayList<Pair<Integer,Integer>> pairList = new ArrayList<Pair<Integer,Integer>>();
	pairList.add(p); 	pairList.add(p2); 	pairList.add(p3); pairList.add(p4);
	ArrayList<Integer> chaud = new ArrayList<Integer>();
	
	
	ArrayList<Pair<Integer,Integer>> pairListSorted = new ArrayList<Pair<Integer,Integer>>();

	while (pairList.size() != 0) {

		int i_min = -1 ;
		int min = Integer.MAX_VALUE; int min_previous = Integer.MAX_VALUE;

		for (int i = 0; i < pairList.size(); i++) {

			min = Math.min(pairList.get(i).getL(),pairList.get(i).getR());
			
			if (min < min_previous) { i_min = i; min_previous = min;}

		}
		pairListSorted.add(pairList.get(i_min));
		pairList.remove(pairList.get(i_min));
	}
	
	for (int i = 0; i < pairListSorted.size(); i++) {
		
	
	System.out.println(pairListSorted.get(i).getL());
	System.out.println(pairListSorted.get(i).getR());
	System.out.println("\n");


}
	System.out.println(pairListSorted.size());
	}
}
