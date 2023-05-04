package allumettes;

public class Joueur {
	/** Nom du joueur */
	private String nom;

	/** Niveau du joueur défini par la classe Strat(égie) */
	private Strat niveau;
	
	/** Constructeur de Joueur.*/
	public Joueur() { }

	/** Constructeur de Joueur.
	 * @param niveau niveau de l'ordinateur
	 * @param nom nom du joueur
	 */
	public Joueur(String nom, Strat niveau) {
		this.niveau = niveau;
		this.nom = nom;
	}
		
	/** Demander le nombre d'allumettes que le joueur ou ordinateur souhaite retirer.
	 * @param game jeu en cours
	 * @return entier
	 */
	public int getPrise(Jeu game) {
		return this.niveau.getPrise(game);
	}

	/** Obtenir si la stratégie du joueur.
	 * @return oui ou non
	 */
	public Strat getStrategie() {
		return this.niveau;
	}
		
	/** Obtenir le nom de joueur.
	 * @return nom
	 */
	public String getNom() {
		return this.nom;
	}

	/** Définir le nom du joueur.
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Définir le niveau du joueur si ordinateur.
	 * @param niveau
	 */
	public void setNiveau(Strat niveau) {
		this.niveau = niveau;
	}
		
}
