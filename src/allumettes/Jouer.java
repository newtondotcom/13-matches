package allumettes;

/** Lance une partie des 13 allumettes en fonction des arguments fournis
 * sur la ligne de commande.
 * @author	Xavier Crégut
 * @version	$Revision: 1.5 $
 */
public class Jouer {

	/** Nombre d'allumettes au début de la partie. */
	public static final int nbAllu = 13;

	/** Lancer une partie. En argument sont donnés les deux joueurs sous
	 * la forme nom@stratégie.
	 * @param args la description des deux joueurs
	 */
	public static void main(String[] args) {

		try {
			verifierNombreArguments(args);

			Joueur joueur1 = Joueur();
			Joueur joueur2 = Joueur();
			//Détecter si le paramètre confiant est entré
			int offset = 0;
			boolean estConfiant = false;
			if (args[0].contentEquals("-confiant")) {
				estConfiant = true;
				offset = 1;
			}

			//Créer les joueurs
			joueur1 = creationJoueur(args, 0 + offset);
			joueur2 = creationJoueur(args, 1 + offset);

			// Lancer la partie
			Arbitre arb = new Arbitre(joueur1, joueur2);
			arb.setEstConfiant(estConfiant);
			JeuAllu jeu = new JeuAllu(nbAllu);
			arb.arbitrer(jeu);

		} catch (ConfigurationException e) {
			System.out.println();
			System.out.println("Erreur : " + e.getMessage());
			afficherUsage();
			System.exit(1);
		}
	}

	/** Vérifier le nombre d'arguments fournis sur la ligne de commande.
	 * @param args les arguments fournis
	 * @throws ConfigurationException si le nombre d'arguments est incorrect
	 */
	private static void verifierNombreArguments(String[] args) {
		final int nbJoueurs = 2;
		if (args.length < nbJoueurs) {
			throw new ConfigurationException("Il n'y a pas assez d'arguments : "
					+ args.length);
		}
		if (args.length > nbJoueurs + 1) {
			throw new ConfigurationException("Il y a trop d'arguments : "
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

	/** Créer un joueur à partir de la description des deux joueurs.
	 * @param args la description des deux joueurs
	 * @param numJoueur l'indice du joueur (1er ou 2eme)
	 * @return le nouveau joueur
	 * @throws ConfigurationException
	 */
	private static Joueur creationJoueur(String[] args, int numJoueur) {
		String nomJoueur;
		String nomStrategie;
		String[] joueur = args[numJoueur].split("@");
		if (joueur.length != 2) {
			throw new ConfigurationException("Erreur !");
		}
		try {
			nomJoueur = joueur[0];
			nomStrategie = joueur[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ConfigurationException("Il manque un argument !");
		}
		return (new Joueur(nomJoueur, stringToStrategie(nomStrategie, nomJoueur)));
	}

	/** Obtenir la stratégie d'un jeu à partir du nom de la stratégie et du
	 * nom du joueur.
	 * @param nomStrategie le nom de la stratégie
	 * @param nomJoueur le nom du joueur
	 * @return la stratégie dont le nom est nomStrategie
	 * @throws ConfigurationException
	 */
	private static Strat stringToStrategie(String nomStrategie, String nomJoueur) {
		switch (nomStrategie) {
			case "naif" :
				return new Naif();
			case "rapide" :
				return new Rapide();
			case "lente" :
				return new Lente();
			case "expert" :
				return new Expert();
			case "humain" :
				return new Humain(nomJoueur);
			case "tricheur" :
				return new Tricheur();
			default:
				throw new ConfigurationException("La stratégie n'existe pas.");
		}
	}

	
}
