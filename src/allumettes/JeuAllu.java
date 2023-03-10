package allumettes;


public class JeuAllu implements Jeu {
	private int stock;
	private int PRISE_MAX;
	
	public JeuAllu(int stock, int prisemax) {
		this.stock = stock;
		this.PRISE_MAX = prisemax;
	}
	
	public int getNombreAllumettes() {
		return this.stock;
	}

	public void setNombreAllumettes(int value) {
		this.stock = value;
	}
	
	
	public void retirer(int nbPrises){
		try {
		if (nbPrises > this.stock) {
    		throw new CoupInvalideException(nbPrises,"Nombre invalide :"+ Integer.toString(nbPrises)+"(<1)");
		}
		else if (nbPrises > PRISE_MAX) {
			throw  new CoupInvalideException(nbPrises,"Nombre invalide :"+ Integer.toString(nbPrises)+"(>3)");
		}
		else {
			this.stock = this.stock - nbPrises;
		}
		}
		catch (CoupInvalideException e) {
			System.out.println(e.getProbleme());
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
		System.out.println();
		System.out.println();
		System.out.println(winner.getNom() + " gagne");
		System.out.println(looser.getNom() + " perd");
	}
}
