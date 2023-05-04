package allumettes;
import org.junit.*;
import static org.junit.Assert.*;

public class RapideTest {

	protected Jeu jeu;
	protected Strat niveau;

	@Before
	public void TestRapideInit() {
		this.niveau = new Rapide();
		this.jeu = new JeuAllu(13);
	}

	@Test
	public void testerRapideSupAPMax() {
		assertEquals(this.niveau.getPrise(this.jeu), Jeu.priseMax);
	}
	
	
	@Test
	public void testerRapideEquAPMax() {
		
		while (this.jeu.getNombreAllumettes() > Jeu.priseMax) {
			try {
				this.jeu.retirer(1);
			} catch (CoupInvalideException e) {
				// Impossible d'arriver ici.
			}
		}
		assertEquals(this.niveau.getPrise(this.jeu), Math.max(1, this.jeu.getNombreAllumettes() - 1));
	}
}
