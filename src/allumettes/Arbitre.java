package allumettes;
import java.util.Scanner;

public class Arbitre {
	/** Joueur 1 */
	private Joueur joueur1;

	/** Joueur 2 */
	private Joueur joueur2;

	/** Booléen indiquant si c'est au tour du joueur 1. */
	private Boolean isPlayer1Turn;

	/** Booléen indiquant si l'arbitre est confiant. */
	private Boolean estConfiant;

	/** Scanner pour la lecture des entrées clavier. */
	public static final Scanner SCANNER = new Scanner(System.in);

	/** Crééer un arbitre pour deux joueurs.
	 * @param joueur1 Joueur 1
	 * @param joueur2 Joueur 2
	 */
	public Arbitre(Joueur joueur1, Joueur joueur2) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.isPlayer1Turn = true;
	}

	/** Obtenir si le joueur est confiant.
	 * @return oui ou non
	 */
	public boolean estIlConfiant() {
		return this.estConfiant;
	}

	/** Définir si le joueur est confiant.
	 * @param estConfiant
	 */
	public void setEstConfiant(Boolean estConfiant) {
		this.estConfiant = estConfiant;
	}

	/** Faire jouer le joueur en argument et savoir s'il est tricheur ou non.
	 * @param jeu le jeu correspondant
	 * @param joueur le joueur correspondant
	 * @return le booléen indiquant si le joueur est un tricheur ou non
	 * @throws OperationInterditeException
	 */
	public boolean faireJouer(Jeu jeu, Joueur joueur) {
		boolean triche = false;
		int coup;
		int nb = jeu.getNombreAllumettes();
		System.out.println("Allumettes restantes : " + Integer.toString(nb));
		try {
			coup = joueur.getPrise(jeuConfiant(jeu));
			affichageAllumettesSingulier(coup, joueur);
			retirerAllumettes(jeu, coup);
		} catch (OperationInterditeException e) {
			System.out.println("Abandon de la partie car " + joueur.getNom()
			+ " triche !");
			triche = true;
		}
		return !Triche;
	}

	/** Retirer des allumettes.  Le nombre d'allumettes doit être compris
	 * entre 1 et priseMax, dans la limite du nombre d'allumettes encore
	 * en jeu.
	 * @param jeu le jeu
	 * @param coup le nombre d'allumettes à retirer
	 * @throws CoupInvalideException tentative de prendre un nombre invalide d'allumettes
	 */
	public void retirerAllumettes(Jeu jeu, int coup) {
		try {
			jeu.retirer(coup);
			this.isPlayer1Turn = !this.isPlayer1Turn;
		} catch (CoupInvalideException e) {
			System.out.print("Impossible ! ");
			System.out.println(e.getProbleme());
		}
	}
	
	/** Arbitrer une partie.
	* @param jeu le jeu
	*/
	public void arbitrer(Jeu jeu) {
		boolean notTriching = true;
		while (jeu.getNombreAllumettes() > 0 && notTriching) {
			if (isPlayer1Turn) {
				notTriching = faireJouer(jeu, joueur1);
			} else {
				notTriching = faireJouer(jeu, joueur2);
			}
			System.out.println();
		}
		if (notTriching) {
			if (isPlayer1Turn) {
				afficherResulatFinal(joueur1, joueur2);
			} else {
				afficherResulatFinal(joueur2, joueur1);
			}
		}
	}

	/** Afficher le nombre d'allumettes que le joueur prend.
	* @param coup le coup
	* @param joueur le joueur
	*/
	public void affichageAllumettesSingulier(int coup, Joueur joueur) {
		if (coup < 2) {
			System.out.println(joueur.getNom() + " prend " + coup + " allumette.");
		} else {
			System.out.println(joueur.getNom() + " prend " + coup + " allumettes.");
		}
	}

	/** Obtenir le bon jeu en fonction de l'option -confiant.
	 * @param jeu le jeu
	 * @return le bon jeu
	 */
	public Jeu jeuConfiant(Jeu jeu) {
		if (!this.estConfiant) {
			return new JeuProcuration(jeu);
		} else {
			return jeu;
		}
	}

	/** Afficher le résultat final.
	 * @param winner le joueur gagnant
	 * @param looser le joueur perdant
	 */
	public void afficherResulatFinal(Joueur winner, Joueur looser) {
		System.out.println(looser.getNom() + " perd !");
		System.out.println(winner.getNom() + " gagne !");
	}
}

