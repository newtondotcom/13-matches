package allumettes;

import java.util.Random;
import java.util.Scanner;

public class Joueur {
	
	private String nom;
	
	private boolean estOrdinateur ;
	
	private String niveau; 
	
	public Joueur() {}
	
	public Joueur(boolean isOrdi, String niveau , String nom) {
		this.estOrdinateur = isOrdi;
		this.niveau = niveau;
		this.nom = nom;
	}
	
	public Joueur(boolean isOrdi, String niveau , String nom , boolean isConfiant) {
		this.estOrdinateur = isOrdi;
		this.niveau = niveau;
		this.nom = nom;
	}
	
	public Joueur(boolean isOrdi, String nom) {
		this.estOrdinateur = isOrdi;
		this.nom = nom;
	}
	
	/** Demander le nombre d'allumettes que le joueur souhaite retirer;
	 * @param Game jeu en cours
	 * @return entier
	 * @throws Exception 
	 */
	public int getPrise(Jeu game) throws Exception {
		int nombre = 0;
		if (this.estIlOrdinateur()) {
			if (this.getNiveau() == "rapide") {
				return 3;
			}
			else if (this.getNiveau() == "naif") {
				Random gen = new Random();
				nombre = gen.nextInt(5)+1;
				return nombre;
			}
			else {
				//IMPLEmenTER LE MODE EXPERt
				return 1;
			}
		}
		else {
			Scanner scanner = new Scanner(System.in);
	        while(true){
	            try{
	    	        System.out.println(this.nom + ", combien d'allumettes ?");
	                nombre = Integer.parseInt(scanner.next());
	    	        if (nombre < 1) {
		        		Exception coupInvaException = new CoupInvalideException(nombre,"Nombre invalide :"+ Integer.toString(nombre)+"(<1)");
		        		throw coupInvaException;
	    	        }
	    	        else if (nombre > 3) {
		        		Exception coupInvaException = new CoupInvalideException(nombre,"Nombre invalide :"+ Integer.toString(nombre)+"(>3)");
		        		throw coupInvaException;
	    	        }
	    	        else if (nombre > game.getNombreAllumettes()) {
		        		Exception coupInvaException = new CoupInvalideException(nombre,"Nombre invalide :"+ Integer.toString(nombre)+"(>allumettes restantes)");
		        		throw coupInvaException;
	    	        }
	    	        else {
	    	        	break;
	    	        }
	            }
	            catch(NumberFormatException e){
		        	System.out.println();
		        	System.out.println("Vous devez donner un entier");
	            }
	        }
	        scanner.close();
		}
		return nombre;

	}
	
	/** Demander le nombre d'allumettes que le joueur souhaite retirer quand l'arbitre n'est pas confiant.
	 * @param Game jeu en cours
	 * @return entier
	 * @throws Exception 
	 */
	public int getPriseNonConfiante(Jeu game) throws Exception {
			int nombre = 0;
			Scanner scanner = new Scanner(System.in);
	        while(true){
	            try{
	            	if (scanner.next().equals("triche")) {
	            		game.setNombreAllumettes(game.getNombreAllumettes()-1);
	            	}
	    	        System.out.println(this.nom + ", combien d'allumettes ?");
	                nombre = Integer.parseInt(scanner.next());
	    	        if (nombre < 1) {
		        		Exception coupInvaException = new CoupInvalideException(nombre,"Nombre invalide :"+ Integer.toString(nombre)+"(<1)");
		        		throw coupInvaException;
	    	        }
	    	        else if (nombre > 3) {
		        		Exception coupInvaException = new CoupInvalideException(nombre,"Nombre invalide :"+ Integer.toString(nombre)+"(>3)");
		        		throw coupInvaException;
	    	        }
	    	        else if (nombre > game.getNombreAllumettes()) {
		        		Exception coupInvaException = new CoupInvalideException(nombre,"Nombre invalide :"+ Integer.toString(nombre)+"(>allumettes restantes)");
		        		throw coupInvaException;
	    	        }
	    	        else {
	    	        	break;
	    	        }
	            }
	            catch(NumberFormatException e){
		        	System.out.println();
		        	System.out.println("Vous devez donner un entier");
	            }
	        }
	        scanner.close();
		return nombre;

	}
	
	/** Obtenir si le joueur est l'ordinateur.
	 * @return oui ou non
	 */
	public boolean estIlOrdinateur () {
		return this.estOrdinateur;
	}
	
	/** Obtenir le niveau du joueur si ordinateur.
	 * @return niveau
	 */
	public String getNiveau () {
		return this.niveau;
	}
	
	/** Obtenir le nom de joueur.
	 * @return nom
	 */
	public String getNom() {
		return this.nom;
	}
	
}
