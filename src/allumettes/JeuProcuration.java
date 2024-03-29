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
	 * entre 1 et priseMax, dans la limite du nombre d'allumettes encore
	 * en jeu.
	 * @param nbPrises nombre d'allumettes prises.
	 * @throws CoupInvalideException tentative de prendre un nombre invalide d'allumettes
	 */
	public void retirer(int nbPrises) throws CoupInvalideException {
		throw new OperationInterditeException("Un joueur a utilisé la méthode retirer !");
	}

}
