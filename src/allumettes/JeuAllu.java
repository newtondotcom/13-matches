package allumettes;

public class JeuAllu implements Jeu {
	/** Stock d'allumettes restant */
	private int stock;
	
	/** Nombre maximum d'allumettes que l'on peut prendre */
	private int priseMax = 3;

	/** Constructeur de JeuAllu.
	 * @param stock le nombre d'allumettes
	 */
	public JeuAllu(int stock) {
		this.stock = stock;
	}
	
	/** Obtenir le nombre d'allumettes restantes.
	 * @return priseMax le nombre maximum d'allumettes que l'on peut prendre
	 */
	public int getNombreAllumettes() {
		return this.stock;
	}

	/** Définir le nombre maximum d'allumettes.
	 * @param value le nombre d'allumettes
	 */
	public void setNombreAllumettes(int value) {
		this.stock = value;
	}
	
	
	/** Retirer un nombre d'allumettes.
	 * @param nbPrises le nombre d'allumettes à retirer
	 * @throws CoupInvalideException tentative de prendre un nombre invalide d'allumettes 
	 */
	public void retirer(int nbPrises) throws CoupInvalideException {
		if (nbPrises > this.stock) {
    		throw new CoupInvalideException(nbPrises, "Nombre invalide : " + Integer.toString(nbPrises) + " (> " + Integer.toString(this.stock) + ")");
		} else if (nbPrises > priseMax) {
			throw  new CoupInvalideException(nbPrises, "Nombre invalide : " + Integer.toString(nbPrises) + " (>" + Integer.toString(priseMax) +")");
		} else if (nbPrises < 1) {
			throw  new CoupInvalideException(nbPrises, "Nombre invalide : " + Integer.toString(nbPrises) + " (< 1)");
		} else {
			this.stock = this.stock - nbPrises;
		}
	}
			
	
	/** Afficher le coup joué par joueur.
	 * @param nbPrises le nombre d'allumettes à retirer
	 * @param joueur le joueur qui prend les allumettes
	 */
	public void afficherTour(int nbPrises, Joueur joueur) {
		String allu;
		if (nbPrises > 0) {
			allu = " allumettes";
		} else {
			allu = " allumette";
		}
		System.out.println(joueur.getNom() + " prend " + Integer.toString(nbPrises) + allu);
	}
}
