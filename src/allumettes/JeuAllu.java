
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
		else {
			this.stock = this.stock - nbPrises;
		}
	}
			
	
	public void afficherTour(int nbPrises, Joueur name) {
		
	}
	
	public void afficherResulatFinal (Joueur Winner, Joueur Looser) {
		System.out.println();
		System.out.println(Winner.getNom() + 'gagne');
		System.out.println();
		System.out.println(Looser.getNom() + 'perd');
	}
}
