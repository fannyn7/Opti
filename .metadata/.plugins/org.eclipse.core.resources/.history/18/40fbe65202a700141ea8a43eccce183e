package optAlgos;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

// Problem resolution without graphic representation

public class Test2 {
	
	final private int instanzen = 1;
	final private static int rechtecke = 1;
	final private static int minSeitenlänge = 10;
	final private static int maxSeitenlänge = 50;
	
	public static void main(String[] args){
		
		ArrayList<Rechteck> mengeRechtecke= new ArrayList<Rechteck>();
		

		for (int i = 1; i <= rechtecke; i++) {
			
			int seite1 = (int) (minSeitenlänge + Math.random()*(maxSeitenlänge-minSeitenlänge));
			int seite2 = (int) (minSeitenlänge + Math.random()*(maxSeitenlänge-minSeitenlänge));
			mengeRechtecke.add(new Rechteck(seite1,seite2));
			
			
			}


		
			
			mengeRechtecke.get(0).setPosY(10); //Initialization
			mengeRechtecke.get(0).setPosX(200);
			
			//Initializing two List to save the positions of the top-left corners of the free zones in the "Bereich" square
			// A rendre plus clair..
			ArrayList<Integer> posx = new ArrayList<Integer>();
			ArrayList<Integer> posy = new ArrayList<Integer>();
			
			// First position is the top-left corner of the zone
			posx.add(0);
			posy.add(0);
			
			//Rechteck bereich = new Rechteck
			
			
			for (int i=1; i < rechtecke; i++){
				
				
				if ((i % 2)==1){
					
					Rechteck aktuellesRechteck = mengeRechtecke.get(i);
					Rechteck vorherigesRechteck = mengeRechtecke.get(i-1);
					
					aktuellesRechteck.setPosX(vorherigesRechteck.getPosX() + vorherigesRechteck.getASeite());
					aktuellesRechteck.setPosY(vorherigesRechteck.getPosY());
					
				}else {
					Rechteck aktuellesRechteck = mengeRechtecke.get(i);
					Rechteck vorherigesRechteck = mengeRechtecke.get(i-2);
					
					aktuellesRechteck.setPosX(vorherigesRechteck.getPosX());
					aktuellesRechteck.setPosY(vorherigesRechteck.getPosY() + vorherigesRechteck.getASeite());	
					}
			}
			

			
			
			
			RechteckenProblem problemInstanz = new RechteckenProblem(mengeRechtecke);
			LokaleSuche lokaleSuche = new LokaleSuche(problemInstanz);
			Solution sol = lokaleSuche.lokaleSucheAlgorithm();
		
	}
			
		
				
		
		
//Fin Zone de TEST

		

	// Used to sort the random list of rectangles by size
	public static ArrayList<Rechteck> sortRechtecke(ArrayList<Rechteck> mengeRechtecke){
		
		ArrayList<Rechteck> mengeRechteckeSorted = new ArrayList<Rechteck>();

		while (mengeRechtecke.size() != 0) {
			
			int i_max = mengeRechtecke.size() + 1 ;
			int max = 0;
			for (int i = 0; i < mengeRechtecke.size(); i++) {
				
				int max_previous = max; //Copy to compare is max changed
				max = Math.max(max, Math.max(mengeRechtecke.get(i).getASeite(),mengeRechtecke.get(i).getWSeite()));
				i_max = max > max_previous ? i : i_max ;
				
			}
			mengeRechteckeSorted.add(mengeRechtecke.get(i_max));
			mengeRechtecke.remove(mengeRechtecke.get(i_max));
		}
	
		
		
		
		return mengeRechteckeSorted;

	}
		 
	}
	

