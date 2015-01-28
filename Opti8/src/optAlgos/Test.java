package optAlgos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JPanel {


	private static final long serialVersionUID = 1L;
	final private int instanzen = 1; // Encore à faaaaaaaaaaaaaaire
	final private static int rechtecke = 75;
	final private static int minSeitenlänge = 10;
	final private static int maxSeitenlänge = 120;

	public void	paintComponent(Graphics	g){
		super.paintComponent(g);
		ArrayList<Rechteck> mengeRechtecke = new ArrayList<Rechteck>();

		for (int i = 1; i <= rechtecke; i++) {

			int seite1 = (int) (minSeitenlänge + Math.random()*(maxSeitenlänge-minSeitenlänge));
			int seite2 = (int) (minSeitenlänge + Math.random()*(maxSeitenlänge-minSeitenlänge));
			mengeRechtecke.add(new Rechteck(seite1,seite2));

		}

		ArrayList<Rechteck> mengeRechtecke_Copy = new ArrayList<Rechteck>(mengeRechtecke);
		//mengeRechtecke2 is the same but ordered
		ArrayList<Rechteck> mengeRechtecke2 = new ArrayList<Rechteck>();
		mengeRechtecke2 = sortRechtecke(mengeRechtecke_Copy);

		//Initializing two List to save the positions of the top-left corners of the free zones in the "Bereich" square
		
		ArrayList<Pair<Integer,Integer>> positions = new ArrayList<Pair<Integer,Integer>>();

		// First position available is the top-left corner of the zone
		positions.add(new Pair<Integer,Integer>(0,0));
		

		// A "zone square" is defined to put all rectangles in it, its size will vary as we have to set
		// more and more rectangles in it
		int bereichQuadratGrosse = Math.max(mengeRechtecke2.get(0).getASeite(), mengeRechtecke2.get(0).getWSeite());
		//Rechteck bereich = new Rechteck(bereichQuadratGrosse,bereichQuadratGrosse,0,0);
		Rechteck bereich = new Rechteck(10000,1000,0,0);

		
		for (int i = 0; i < mengeRechtecke.size(); i++) {

			Rechteck r = mengeRechtecke2.get(i); //Current rectangle
			boolean gestellt = false; // This boolean is true when the current rectangle is set
			positions = sortPair(positions);
			while (gestellt==false){
				int k = 0; // To go through all positions of the possible places for rectangles

				while (k != positions.size() && gestellt==false) {

					r.setPosX(positions.get(k).getL());
					r.setPosY(positions.get(k).getR());
					float uberlappung = r.getProzentÜberlappung(bereich);
					gestellt = uberlappung < 1 ? false : true; //Rectangle has to be in the delimited zone...
					k++;

					for (int l = 0; l < i; l++) { //... and not to cross an other rectangle
						if ( mengeRechtecke2.get(i).getProzentÜberlappung(mengeRechtecke2.get(l)) > 0 ) {
							gestellt = false;
						}
					}
				}

				if (gestellt==true) { // Remove the position and add new ones

					positions.remove(k-1);

					//Placement au hasard des nouvelles positions
					int ordre = (int) ((int) 2*Math.random())+1;

					if (ordre==1) {
						positions.add(new Pair<Integer, Integer>(r.getPosX(), r.getPosY() + r.getASeite()));
						positions.add(new Pair<Integer, Integer>(r.getPosX() + r.getWSeite(),r.getPosY() ));

					}else {
						positions.add(new Pair<Integer, Integer>(r.getPosX(), r.getPosY() + r.getASeite()));
						positions.add(new Pair<Integer, Integer>(r.getPosX() + r.getWSeite(),r.getPosY() ));

					}

				} else {
					// Pour l'instant juste + 1 .. à améliorer pour etre plus précis
					bereich.setASeite(bereich.getASeite() + 1 );
					bereich.setWSeite(bereich.getWSeite() + 1 );
				}
			}
		}
		System.out.println(bereichQuadratGrosse + "\n");


		RechteckenProblem problem = new RechteckenProblem(mengeRechtecke2);
		for (Rechteck r: problem.getRechteckenMenge()){
			int lange = r.getWSeite();
			int breite = r.getASeite();
			int x = r.getPosX();
			int y = r.getPosY();
			System.out.println("rectangle :" + x + " " +y+ " " +lange+ " " +breite);
			g.fillRect(x, y, lange, breite);
			Color rechteckColor = new Color( (float)Math.random(), (float)Math.random(), (float)Math.random() );
			g.setColor(rechteckColor); 
		}
		
		for (int j = 0; j < positions.size(); j++) {
			g.drawOval(positions.get(j).getL(), positions.get(j).getR(), 5, 5);
			
		}
	
	}

	// Used to sort the random list of rectangles by size or whatever
	public ArrayList<Rechteck> sortRechtecke(ArrayList<Rechteck> mengeRechtecke){

		ArrayList<Rechteck> mengeRechteckeSorted = new ArrayList<Rechteck>();

		while (mengeRechtecke.size() != 0) {

			int i_max = -1 ;
			float max = 0; float max_previous =  0;

			for (int i = 0; i < mengeRechtecke.size(); i++) {

				max = Math.max(max, Math.max(mengeRechtecke.get(i).getASeite(),mengeRechtecke.get(i).getWSeite()));
				//Plusieurs choix à considérer pour trier les rectangles..pas vraiment de meilleure méthode je pense
				//max = mengeRechtecke.get(i).getFläche(); 
				//max = mengeRechtecke.get(i).getPerimeter();
				//max = mengeRechtecke.get(i).getFläche()/mengeRechtecke.get(i).getPerimeter();
				//max = mengeRechtecke.get(i).getPerimeter()/mengeRechtecke.get(i).getFläche(); 
				if (max > max_previous) { i_max = i; max_previous = max;}

			}
			mengeRechteckeSorted.add(mengeRechtecke.get(i_max));
			mengeRechtecke.remove(mengeRechtecke.get(i_max));
		}

		return mengeRechteckeSorted;
	}
	
	public ArrayList<Pair<Integer, Integer>> sortPair(ArrayList<Pair<Integer, Integer>> pairs) {
		
		ArrayList<Pair<Integer,Integer>> pairsSorted = new ArrayList<Pair<Integer,Integer>>();

		while (pairs.size() != 0) {

			int i_min = -1 ;
			float min = Float.MAX_VALUE; float min_previous = Float.MAX_VALUE;

			for (int i = 0; i < pairs.size(); i++) {

//				if (pairs.get(i).getL()!=0 && pairs.get(i).getR()!=0 ){
//				min = Math.min(pairs.get(i).getL() , pairs.get(i).getR());
//				} else { // To avoid that the value 0 fakes the whole thing
					min = (pairs.get(i).getL() + pairs.get(i).getR());
//				}
				if (min < min_previous) { i_min = i; min_previous = min;}

			}
			System.out.println(pairs.get(i_min).getL() + " " +pairs.get(i_min).getR() );
			pairsSorted.add(pairs.get(i_min));
			pairs.remove(pairs.get(i_min));
		}
		System.out.println("\n");
		return pairsSorted;
		
	}
	

	public static void main(String[] args){
		Test test = new	Test();
		JFrame frame = new JFrame("RechteckenProblem Visualiesierung");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(test);
		frame.setSize(500,500);
		frame.setVisible(true);

	}
}
