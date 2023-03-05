
public class JeuAllu implements Jeu {
	private int stock;
	private int PRISE_MAX;
	
	public int getNombreAllumettes() {
		return this.stock;
	}
	
	public void retirer(int nbPrises) {
		if nbPrises > this.stock {
			throw CoupInvalideException;
		}
		else if (nbPrises > PRISE_MAX) {
			throw CoupInvalideException;
		}
		else {
			this.stock = this.stock - nbPrises;
		}
	}
			
	
	public void afficherTour(int nbPrises, Joueur joueur) {
		System.out.println();
		System.out.println(joueur.getNom() + ' prend ';
		System.out.println(ToString(nbPrises));
		if (nbPrises > 0) {
			System.out.println(' allumettes');
		}
		else {
			System.out.println(' allumette');
		}
	}
	
	public void afficherResulatFinal (Joueur winner, Joueur looser) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(winner.getNom() + ' gagne');
		System.out.println(looser.getNom() + ' perd');
	}
}
