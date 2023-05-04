package allumettes;

public class Humain implements Strat {

	private String nom;

	/** Créer un joueur humain.
	 * @param nomJoueur le nom du joueur
	 */
	public Humain(String nomJoueur) {
		this.nom = nomJoueur;
	}

	/** Obtenir le nombre d'allumettes que l'ordinateur veut retirer du jeu afin de gagner.
	 * @return nombre d'allumettes que le joueur veut retirer
	 */
	@Override
	public int getPrise(Jeu jeu) {

		boolean entreeNonEntier = true;
		int nombre = 0;
		do {
			System.out.print(this.nom + ", combien d'allumettes ? ");
			String entree = Arbitre.SCANNER.nextLine();

			if (entree.equals("triche") && jeu.getNombreAllumettes() != 1) {
				try {
					jeu.retirer(1);
				} catch (CoupInvalideException e) {
					// Impossible d'arriver ici.
				}
				System.out.println("[Une allumette en moins, plus que "
				+ jeu.getNombreAllumettes() + ". Chut !]");
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
