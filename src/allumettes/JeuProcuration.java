package allumettes;

public class JeuProcuration implements Jeu {

	/** Le jeu normal des allumettes.*/
	private Jeu jeu;
	


	/** Constuire le jeu des allumettes.
	 * @param jeu le jeu normal des allumettes
	 */
	public JeuProcuration(Jeu jeu) {
		this.jeu = jeu;
	}


	/** Obtenir le nombre d'allumettes encore en jeu.
	 * @return nombre d'allumettes encore en jeu
	 */
	public int getNombreAllumettes() {
		return this.jeu.getNombreAllumettes();
	}

	/** Retirer des allumettes.  Le nombre d'allumettes doit être compris
	 * entre 1 et PRISE_MAX, dans la limite du nombre d'allumettes encore
	 * en jeu.
	 * @param nbPrises nombre d'allumettes prises.
	 * @throws CoupInvalideException tentative de prendre un nombre invalide d'allumettes
	 */
	public void retirer(int nbPrises) throws CoupInvalideException {
		throw new OperationInterditeException("Un joueur a utilisé la méthode retirer !");
	}

	/** Définir le nombre d'allumettes encore en jeu.
	 * @param value nombre d'allumettes encore en jeu
	 */
	public void setNombreAllumettes(int value) {
		this.jeu.setNombreAllumettes(value);
	}

	/** Afficher le coup joué par joueur.
	 * @param nbPrises le nombre d'allumettes à retirer
	 * @param joueur le joueur qui prend les allumettes
	 */
	public void afficherTour(int nbPrises, Joueur joueur) {
		String all;
		if (nbPrises > 0) {
			all =" allumettes";
		}
		else {
			all =" allumette";
		}
		System.out.println(joueur.getNom() + " prend "+Integer.toString(nbPrises)+all);

	}
	
	/** Afficher le résultat final du jeu.
	 * @param winner le joueur gagnant
	 * @param looser le joueur perdant
	 */
	public void afficherResulatFinal (Joueur winner, Joueur looser) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(winner.getNom() + " gagne");
		System.out.println(looser.getNom() + " perd");
	}
}
