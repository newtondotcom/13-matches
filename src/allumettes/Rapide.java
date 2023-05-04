package allumettes;

public class Rapide implements Strat {

	/** Obtenir le nombre d'allumettes que l'ordinateur veut retirer du jeu pour gagner.
	 * @return nombre d'allumettes que le joueur veut retirer
	 */
	@Override
	public int getPrise(Jeu jeu) {
		if (jeu.getNombreAllumettes() > Jeu.priseMax) {
			return Jeu.priseMax;
		} 
		else {
			return Math.max(1, jeu.getNombreAllumettes() - 1);
		}
	}
}
