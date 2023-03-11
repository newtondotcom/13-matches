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
	
	
	public void retirer(int nbPrises) throws Exception {
		if (nbPrises > this.stock) {
    		Exception coupInvaException = new CoupInvalideException(nbPrises,"Nombre invalide :"+ Integer.toString(nbPrises)+"(<1)");
			throw coupInvaException;
		}
		else if (nbPrises > PRISE_MAX) {
    		Exception coupInvaException = new CoupInvalideException(nbPrises,"Nombre invalide :"+ Integer.toString(nbPrises)+"(> allumettes restantes)");
			throw coupInvaException;
		}
		else {
			this.stock = this.stock - nbPrises;
		}
	}
			
	
	public void afficherTour(int nbPrises, Joueur joueur) {
		System.out.println();
		System.out.println(joueur.getNom() + " prend ");
		System.out.println(Integer.toString(nbPrises));
		if (nbPrises > 0) {
			System.out.println(" allumettes");
		}
		else {
			System.out.println(" allumette");
		}
	}
	
	public void afficherResulatFinal (Joueur winner, Joueur looser) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(winner.getNom() + " gagne");
		System.out.println(looser.getNom() + " perd");
	}
}
