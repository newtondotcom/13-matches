package allumettes;
import java.util.Random;

public class Naif implements Strat {

	/** Obtenir le nombre d'allumettes que l'ordinateur veut retirer du jeu pour gagner.
	 * @return nombre d'allumettes que le joueur veut retirer
	 */
	@Override
	public int getPrise(Jeu jeu) {
		Random random = new Random();
		return 1 + random.nextInt(Jeu.priseMax);
	}
}