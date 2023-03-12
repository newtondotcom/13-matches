package allumettes;
import org.junit.*;
import static org.junit.Assert.*;

public class TestRapide {

	protected Jeu jeu;
    protected Arbitre arb;

	@Before
	public void TestRapideInit() {
        Joueur j1 = new Joueur(false,"Joueur 1");
        Joueur j2 = new Joueur(true,"rapide","Joueur 2");
		this.jeu = new JeuAllumettes(13);
		this.arb = new Arbitre(j2,j1);
	}

	@Test
	public void testerRapideSupAPMax() {
        int a = this.arb.j1.getPrise();
		assertEquals(a, Jeu.PRISE_MAX);
	}
	
	
	@Test
	public void testerRapideEquAPMax() {
		
		while (this.jeu.getNombreAllumettes() > Jeu.PRISE_MAX) {
			try {
				this.jeu.retirer(1);
			} catch (CoupInvalideException e) {
				// Impossible d'arriver ici.
			}
		}
		assertEquals(this.arb.j1.getPrise(), Math.max(1, this.jeu.getNombreAllumettes() - 1));
	}
}