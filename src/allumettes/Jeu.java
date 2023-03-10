package allumettes;

public interface Jeu {

	/** Nombre maximal d'allumettes pouvant être prises. */
	int PRISE_MAX = 3;

	/** Obtenir le nombre d'allumettes encore en jeu.
	 * @return nombre d'allumettes encore en jeu
	 */
	int getNombreAllumettes();
	
	/** Ajuster le nombre d'allumettes encore en jeu.
	 * @param value montant
	 * @return nombre d'allumettes encore en jeu
	 */
	void setNombreAllumettes(int value);

	/** Retirer des allumettes.  Le nombre d'allumettes doit être compris
	 * entre 1 et PRISE_MAX, dans la limite du nombre d'allumettes encore
	 * en jeu.
	 * @param nbPrises nombre d'allumettes prises.
	 * @throws CoupInvalideException tentative de prendre un nombre invalide d'allumettes
	 */
	void retirer(int nbPrises) throws Exception;
	
	/** Afficher le coup joué au tour actuel.
	 * @param nbPrises
	 * @param name
	 */
	void afficherTour(int nbPrises, Joueur joueur);
	
	/** Affiche les résultats finaux;
	 * @param Winner
	 * @param Looser
	 */
	void afficherResulatFinal (Joueur Winner, Joueur Looser);
	
}