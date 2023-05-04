package allumettes;

public class Tricheur implements Strat {

	/** Obtenir le nombre d'allumettes que l'ordinateur veut retirer du jeu pour gagner.
	 * @return nombre d'allumettes que le joueur veut retirer
	 */
	@Override
	public int getPrise(Jeu jeu) {
		System.out.println("[Je triche ...]");
		while (jeu.getNombreAllumettes() > 2) {
			try {
				jeu.retirer(1);
			} catch (CoupInvalideException e) {
				// Impossible d'arriver ici.
			}
		}
		System.out.println("[Allumettes restantes : " + jeu.getNombreAllumettes() + "]");
		return 1;
	}
}
