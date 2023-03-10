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
	
	public Joueur(boolean isOrdi, String nom) {
		this.estOrdinateur = isOrdi;
		this.nom = nom;
	}
	
	/** Demander le nombre d'allumettes que le joueur souhaite retirer;
	 * @param Game jeu en cours
	 * @return entier
	 */
	public int getPriseNonConfiante(Jeu game) {
		int nombre = 0;
		if (this.estIlOrdinateur()) {
			if (this.getNiveau().equals("rapide") ) {
				return 3;
			}
			else if (this.getNiveau().equals("naif")) {
				Random gen = new Random();
				nombre = gen.nextInt(5)+1;
				return nombre;
			}
			else if (this.getNiveau().equals("expert")) {
				//IMPLEmenTER LE MODE EXPERt
				return 1;
			}
		}
		else {
			boolean entreeNonEntier = true;
			do {
				System.out.print(this.nom + ", combien d'allumettes ? ");
				Scanner scanner = new Scanner(System.in);

				String entree = scanner.nextLine();        
	
				if (entree.equals("triche") && game.getNombreAllumettes() != 1) {
					game.retirer(1);
					System.out.println("[Une allumette en moins, plus que "
					+ game.getNombreAllumettes() + ". Chut !]");
				} else {
					try {
						nombre = Integer.parseInt(entree);
						entreeNonEntier = false;
						} catch (NumberFormatException e) {
							System.out.println("Vous devez donner un entier.");
						}
				}
			} while (entreeNonEntier);
			return nombre;
	        }
	        
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

	/** Définir le nom du joueur.
	 * @param nom
	 */
	public void setNom(String nom){
		this.nom = nom;
	}

	/** Définir si le joueur est un ordinateur.
	 * @param estOrdinateur
	 */
	public void setEstOrdinateur(boolean estOrdinateur) {
		this.estOrdinateur = estOrdinateur;
	}

	/** Définir le niveau du joueur si ordinateur.
	 * @param niveau
	 */
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	
}
