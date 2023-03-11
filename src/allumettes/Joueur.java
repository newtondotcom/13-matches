package allumettes;

import java.util.Random;

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
	 * @param game jeu en cours
	 * @return entier
	 */
	public int getPrise(Jeu game) {
		int nombre = 0;
		if (this.estIlOrdinateur()) {
			if (this.getNiveau().equals("rapide") ) {
				if (game.getNombreAllumettes() > Jeu.PRISE_MAX) {
					return Jeu.PRISE_MAX;
				} else {
					return Math.max(1, game.getNombreAllumettes() - 1);
				}
			}
			else if (this.getNiveau().equals("naif")) {
				Random random = new Random();
				return 1 + random.nextInt(Jeu.PRISE_MAX);
			}
			else if (this.getNiveau().equals("expert")) {
				int nbAlea = Math.floorMod(game.getNombreAllumettes() - Jouer.nballu, game.PRISE_MAX + 1);
				if (nbAlea == 0) {
					return 1;
				} else {
					return nbAlea;
				}
			}
		}
		else {
			boolean entreeNonEntier = true;
			do {
				System.out.print(this.nom + ", combien d'allumettes ? ");

				String entree = Arbitre.SCANNER.nextLine();        
	
				if (entree.equals("triche") && game.getNombreAllumettes() != 1) {
					try {game.retirer(1);} catch (CoupInvalideException e) {;}//impossible normalement;
					System.out.println("[Une allumette en moins, plus que "
					+ game.getNombreAllumettes() + ". Chut !]");
				}
				
				else {
					try {
						nombre = Integer.parseInt(entree);
						entreeNonEntier = false;
						return nombre;
						} catch (NumberFormatException e) {
							System.out.println("Vous devez donner un entier.");
						}
				}
			} while (entreeNonEntier);
			return nombre;
	    }
		return 0;
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
