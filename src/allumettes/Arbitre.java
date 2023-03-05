
public class Arbitre {
	private Joueur j1;
	private Joueur j2;
	private Boolean isPlayerTurn;
	
	public Arbitre(Joueur j1,Joueur j2) {
		this.j1 = j1;
		this.j2 = j2;
		
	}
	
	public void arbitrer (Jeu jeu) {
		isPlayerTurn = true;
		while (jeu.getStock()>1) {
			int nb = jeu.getNombreAllumettes();
			System.out.prints("Allumettes restantes : "+toString(nb));
			if isPlayerTurn {
				int prise = j1.getPrise(this)
				afficherTour(prise, j1)
			}
			else {
				j2.getPrise(this)
			}
			this.isPlayerTurn = !(this.isPlayerTurn)
		}
		if isPlayerTurn {
			afficherResulatFinal(j2, j1);
		}
		else {
			afficherResulatFinal(j1, j2);
		}
		
		
		
	}
}
