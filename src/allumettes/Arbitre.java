package allumettes;

import java.time.chrono.IsoChronology;

import java.util.Scanner;

public class Arbitre {
	private Joueur j1;
	private Joueur j2;
	private Boolean isPlayer1Turn;
	private Boolean estConfiant;
	
	public static final Scanner SCANNER = new Scanner(System.in);

	public Arbitre(Joueur j1,Joueur j2) {
		this.j1 = j1;
		this.j2 = j2;
		this.isPlayer1Turn = true;
	}
	
	/** Obtenir si le joueur est confiant.
	 * @return oui ou non
	 */
	public boolean estIlConfiant () {
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
		boolean estTricheur = false;
		int coup;
		int nb = jeu.getNombreAllumettes();
		System.out.println("Allumettes restantes : "+ Integer.toString(nb));
		try {
			coup = joueur.getPrise(jeuConfiant(jeu));
			affichageAllumettesSingulier(coup, joueur);
			retirerAllumettes(jeu, coup);
		} catch (OperationInterditeException e) {
			System.out.println("Abandon de la partie car " + joueur.getNom()
			+ " triche !");
			estTricheur = true;
		}
		return !estTricheur;
	}

	/** Retirer des allumettes.  Le nombre d'allumettes doit être compris
	 * entre 1 et PRISE_MAX, dans la limite du nombre d'allumettes encore
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
	
	public void arbitrer (Jeu jeu) {
		boolean notTriching = true;
		while (jeu.getNombreAllumettes()>0 && notTriching) {
			if (isPlayer1Turn) {
				notTriching = faireJouer(jeu, j1);
			}
			else {
				notTriching = faireJouer(jeu, j2);
			}
			System.out.println();
		}
		if (notTriching) {
			if (isPlayer1Turn) {
				jeu.afficherResulatFinal(j1, j2);
			}
			else {
				jeu.afficherResulatFinal(j2, j1);
			}	
		}
	
	}

		/** Afficher le nombre d'allumettes que le joueur prend.
	 * @param coup
	 * @param joueur
	 */
	public void affichageAllumettesSingulier(int coup, Joueur joueur) {
		if (coup < 2) {
			System.out.println(joueur.getNom() + " prend " + coup + " allumette.");
		} else {
			System.out.println(joueur.getNom() + " prend " + coup + " allumettes.");
		}
	}

	/** Obtenir le bon jeu en fonction de l'option -confiant.
	 * @param jeu
	 * @return le bon jeu en fonction de l'option -confiant
	 */
	public Jeu jeuConfiant(Jeu jeu) {
		if (!this.estConfiant) {
			return new JeuProcuration(jeu);
		} else {
			return jeu;
		}
	}
}

