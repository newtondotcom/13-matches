package allumettes;

import java.time.chrono.IsoChronology;

public class Arbitre {
	private Joueur j1;
	private Joueur j2;
	private Boolean isPlayer1Turn;
	private Boolean estConfiant;
	
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

	public void arbitre(Jeu jeu, Boolean isConfiant) {
		this.estConfiant = isConfiant;
		if (isConfiant) {
			arbitrerConfiant(jeu);
		}
		else {
			arbitrerNonConfiant(jeu);
		}
	}

	/** Faire jouer le joueur en argument et savoir s'il est tricheur ou non.
	 * @param jeu le jeu correspondant
	 * @param joueur le joueur correspondant
	 * @return le booléen indiquant si le joueur est un tricheur ou non
	 * @throws OperationInterditeException
	 */
	public boolean faireJouer(Jeu jeu, Joueur joueur) {
		boolean estTricheur = false;

		try {
			int coup = joueur.getPrise(jeuConfiant(jeu));
			affichageAllumettesSingulier(coup, joueur);
			retirerAllumettes(jeu, coup);
		} catch (OperationInterditeException e) {
			System.out.println("Abandon de la partie car " + joueur.getNom()
			+ " triche !");
			estTricheur = true;
		}

		return estTricheur;
	}

	private int compteur;
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
			this.compteur++;
		} catch (CoupInvalideException e) {
			System.out.print("Impossible ! Nombre invalide : ");
			System.out.println(e.getCoup() + " (" + e.getProbleme() + ")");
		}
	}
	
	public void arbitrerConfiant (Jeu jeu) {
		while (jeu.getNombreAllumettes()>0) {
			int nb = jeu.getNombreAllumettes();
			int prise ;
			System.out.println("Allumettes restantes : "+ Integer.toString(nb));
			if (isPlayer1Turn) {
				prise = j1.getPriseNonConfiante(jeu);
				jeu.afficherTour(prise, j1);
			}
			else {
				prise = j2.getPriseNonConfiante(jeu);
			}
			jeu.retirer(prise);
			this.isPlayer1Turn = !(this.isPlayer1Turn);
		}
		if (isPlayer1Turn) {
			jeu.afficherResulatFinal(j2, j1);
		}
		else {
			jeu.afficherResulatFinal(j1, j2);
		}		
	}
	
	public void arbitrerNonConfiant (Jeu jeu) {
		boolean notTriching = true;
		while (jeu.getNombreAllumettes()>0 && notTriching) {
			int nb = jeu.getNombreAllumettes();
			int prise;
			System.out.println("Allumettes restantes : "+ Integer.toString(nb));
			if (isPlayer1Turn) {
				prise = j1.getPriseNonConfiante(jeu);
				jeu.afficherTour(prise, j1);
			}
			else {
				prise = j2.getPriseNonConfiante(jeu);
			}
			jeu.retirer(prise);
			this.isPlayer1Turn = !(this.isPlayer1Turn);
		}
		if (isPlayer1Turn) {
			jeu.afficherResulatFinal(j2, j1);
		}
		else {
			jeu.afficherResulatFinal(j1, j2);
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
		if (!this.confiant) {
			return new JeuProcuration(jeu);
		} else {
			return jeu;
		}
	}

}

