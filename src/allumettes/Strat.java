package allumettes;

public interface Strat {
	/** Obtenir le nombre d'allumettes que l'ordinateur veut retirer du jeu pour gagner.
	 * @param jeu le jeu en cours
	 * @return nombre d'allumettes que le joueur veut retirer
	 */
	int getPrise(Jeu jeu);
}
