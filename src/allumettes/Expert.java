package allumettes;

public class Expert implements Strat {

	/** Obtenir le nombre d'allumettes que l'ordinateur veut retirer du jeu pour gagner.
	 * @return nombre d'allumettes que le joueur veut retirer
	 */
	@Override
	public int getPrise(Jeu jeu) {

		// Le nombre d'allumette retiré doit être un multiple de 4.
		int nbAlea = Math.floorMod(jeu.getNombreAllumettes() - Jouer.nballu, Jeu.priseMax + 1);
		if (nbAlea == 0) {
			return 1;
		} else {
			return nbAlea;
		}
	}
}
