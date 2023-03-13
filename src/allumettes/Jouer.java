package allumettes;

/** Lance une partie des 13 allumettes en fonction des arguments fournis
 * sur la ligne de commande.
 * @author	Xavier Crégut
 * @version	$Revision: 1.5 $
 */
public class Jouer {

	/** Nombre d'allumettes au début de la partie. */
	public static final int nballu = 13;

	/** Lancer une partie. En argument sont donnés les deux joueurs sous
	 * la forme nom@stratégie.
	 * @param args la description des deux joueurs
	 */
	public static void main(String[] args) {

	
		try {
			verifierNombreArguments(args);
		} catch (ConfigurationException e) {
			System.out.println();
			System.out.println("Erreur : " + e.getMessage());
			afficherUsage();
			System.exit(1);
		}
		
		// Détecter si le joueur est un ordinateur ou un humain en analysant sa stratégie parmi humain, naîf, expert, rapide
		Joueur j1 = new  Joueur();
		Joueur j2 = new  Joueur();

		
		//Détecter si le paramètre confiant est entré
		int offset = 0;
		boolean estConfiant = false;
		if (args[0].contentEquals("-confiant")) {
			estConfiant = true;
			offset = 1;
		}

		// Récupérer le premier argument
		String[] arg1 = args[offset+0].split("@");
		String nom1 = arg1[0];
		String strategie1 = arg1[1];

		// Récupérer le second argument
		String[] arg2 = args[offset+1].split("@");
		String nom2 = arg2[0];
		String strategie2 = arg2[1];

		//Joueur 1
		if (strategie1.equals("humain")) {
			j1.setEstOrdinateur(false);
			j1.setNom(nom1);
		}
		else {
			j1.setEstOrdinateur(true);
			j1.setNom(nom1);
			j1.setNiveau(strategie1);
		}

		//Joueur 2
		if (strategie2.equals("humain")) {
			j2.setEstOrdinateur(false);
			j2.setNom(nom2);
		}
		else {
			j2.setEstOrdinateur(true);
			j2.setNom(nom2);
			j2.setNiveau(strategie2);
		}

		// Lancer la partie
		Arbitre arb = new Arbitre(j1,j2);
		arb.setEstConfiant(estConfiant);
		JeuAllu jeu = new JeuAllu(nballu);
		arb.arbitrer(jeu);
		
	}

	/** Vérifier le nombre d'arguments fournis sur la ligne de commande.
	 * @param args les arguments fournis
	 * @throws ConfigurationException si le nombre d'arguments est incorrect
	 */
	private static void verifierNombreArguments(String[] args) {
		final int nbJoueurs = 2;
		if (args.length < nbJoueurs) {
			throw new ConfigurationException("Trop peu d'arguments : "
					+ args.length);
		}
		if (args.length > nbJoueurs + 1) {
			throw new ConfigurationException("Trop d'arguments : "
					+ args.length);
		}
	}

	/** Afficher des indications sur la manière d'exécuter cette classe. */
	public static void afficherUsage() {
		System.out.println("\n" + "Usage :"
				+ "\n\t" + "java allumettes.Jouer joueur1 joueur2"
				+ "\n\t\t" + "joueur est de la forme nom@stratégie"
				+ "\n\t\t" + "strategie = naif | rapide | expert | humain | tricheur"
				+ "\n"
				+ "\n\t" + "Exemple :"
				+ "\n\t" + "	java allumettes.Jouer Xavier@humain "
					   + "Ordinateur@naif"
				+ "\n"
				);
	}

}
