package allumettes;


public class Arbitre {
	private Joueur j1;
	private Joueur j2;
	private Boolean isPlayer1Turn;
	private Boolean estConfiant;
	
	public Arbitre(Joueur j1,Joueur j2) {
		this.j1 = j1;
		this.j2 = j2;
		
	}
	
	/** Obtenir si le joueur est confiant.
	 * @return oui ou non
	 */
	public boolean estIlConfiant () {
		return this.estConfiant;
	}
	
	public void arbitrerConfiant (Jeu jeu) throws Exception {
		isPlayer1Turn = true;
		while (jeu.getNombreAllumettes()>0) {
			int nb = jeu.getNombreAllumettes();
			System.out.println("Allumettes restantes : "+ Integer.toString(nb));
			if (isPlayer1Turn) {
				int prise = j1.getPrise(jeu);
				jeu.afficherTour(prise, j1);
			}
			else {
				j2.getPrise(jeu);
			}
			this.isPlayer1Turn = !(this.isPlayer1Turn);
		}
		if (isPlayer1Turn) {
			jeu.afficherResulatFinal(j2, j1);
		}
		else {
			jeu.afficherResulatFinal(j1, j2);
		}		
	}
	
	public void arbitrerNonConfiant (Jeu jeu) throws Exception {
		boolean notTriching = true;
		isPlayer1Turn = true;
		while (jeu.getNombreAllumettes()>0 && notTriching) {
			int nb = jeu.getNombreAllumettes();
			System.out.println("Allumettes restantes : "+ Integer.toString(nb));
			if (isPlayer1Turn) {
				int prise = j1.getPriseNonConfiante(jeu);
				jeu.afficherTour(prise, j1);
			}
			else {
				j2.getPrise(jeu);
			}
			this.isPlayer1Turn = !(this.isPlayer1Turn);
		}
		if (isPlayer1Turn) {
			jeu.afficherResulatFinal(j2, j1);
		}
		else {
			jeu.afficherResulatFinal(j1, j2);
		}		
	}
}
