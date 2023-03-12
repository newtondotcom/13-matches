package allumettes;

public class JeuAllu implements Jeu {
	private int stock;
	private int PRISE_MAX = 3;
	
	public JeuAllu(int stock) {
		this.stock = stock;
	}
	
	public int getNombreAllumettes() {
		return this.stock;
	}

	public void setNombreAllumettes(int value) {
		this.stock = value;
	}
	
	
	public void retirer(int nbPrises) throws CoupInvalideException{
		if (nbPrises > this.stock) {
    		throw new CoupInvalideException(nbPrises,"Nombre invalide : "+ Integer.toString(nbPrises)+" (> "+Integer.toString(this.stock)+ ")");
		}
		else if (nbPrises > PRISE_MAX) {
			throw  new CoupInvalideException(nbPrises,"Nombre invalide : "+ Integer.toString(nbPrises)+" (> 3)");
		}
		else if (nbPrises < 1) {
			throw  new CoupInvalideException(nbPrises,"Nombre invalide : "+ Integer.toString(nbPrises)+" (< 1)");
		}
		else {
			this.stock = this.stock - nbPrises;
		}
	}
			
	
	public void afficherTour(int nbPrises, Joueur joueur) {
		String all;
		if (nbPrises > 0) {
			all =" allumettes";
		}
		else {
			all =" allumette";
		}
		System.out.println(joueur.getNom() + " prend "+Integer.toString(nbPrises)+all);

	}
	
	public void afficherResulatFinal (Joueur winner, Joueur looser) {
		System.out.println();
		System.out.println(looser.getNom() + " perd !");
		System.out.println(winner.getNom() + " gagne !");

	}
}
