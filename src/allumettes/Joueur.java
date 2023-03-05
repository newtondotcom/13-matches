import java.util.Random;
import java.util.Scanner;

public class Joueur {
	
	private string nom;
	
	private boolean estOrdinateur ;
	
	private boolean estConfiant ;
	
	private string niveau; 
	
	public Joueur() {}
	
	public Joueur(boolean isOrdi, string niveau , string nom) {
		this.estOrdinateur = isOrdi;
		this.niveau = niveau;
		this.nom = nom;
		this.estConfiant = false;
	}
	
	public Joueur(boolean isOrdi, string niveau , string nom , boolean isConfiant) {
		this.estOrdinateur = isOrdi;
		this.niveau = niveau;
		this.nom = nom;
		this.estConfiant = isConfiant;
	}
	
	public Joueur(boolean isOrdi, string nom) {
		this.estOrdinateur = isHuman;
		this.nom = nom;
	}
	
	/** Demander le nombre d'allumettes que le joueur souhaite retirer;
	 * @param Game jeu en cours
	 * @return entier
	 */
	public int getPrise(Jeu game) {
		if this.estIlOrdinateur() {
			if this.getNiveau() == "rapide" {
				return 3;
			}
			else if this.getNiveau() == "naif" {
				Random gen = new Random();
				int nombre = gen.ints(1, 4);
				return nombre;
			}
			else {
				//IMPLEmenTER LE MODE EXPERt
				return 1;
			}
		}
		else {
			Scanner scanner = new Scanner(System.in);
	        System.out.prints(this.name + ", combien d'allumettes ?");
	        string text = scanner.nextLine(); 
	        try {
	        	int nombre = ParseInt(text);
	        	if nombre < 1 {
	        		Exception coupInvaException = new CoupInvalideException(nombre,"Nombre invalide :"+ toString(nombre)+'(<1)')
	        		throw coupInvaException;
	        	}
	        catch (Exception e) {
	        	System.out.println();
	        	System.out.prints('Vous devez donner un entier')
				}
	        }
	        	
	        return nombre
		}
	}
	
	/** Obtenir si le joueur est l'ordinateur.
	 * @return oui ou non
	 */
	public boolean estIlOrdinateur () {
		return this.estOrdinateur;
	}
	
	/** Obtenir si le joueur est confiant.
	 * @return oui ou non
	 */
	public boolean estIlConfiant () {
		return this.estConfiant;
	}
	
	/** Obtenir le niveau du joueur si ordinateur.
	 * @return niveau
	 */
	public string getNiveau () {
		return this.niveau;
	}
	
	/** Obtenir le nom de joueur.
	 * @return nom
	 */
	public string getNom() {
		return this.nom;
	}
	
}
