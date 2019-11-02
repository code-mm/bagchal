package bagchal.tests;

import junit.framework.TestCase;

public class SpielstatusTest extends TestCase {
	// Prüfen ob Inkrementierung von  gefressenen Ziegen funktioniert
	public void testZiegenFressen() {
		bagchal.model.Spielfeld spielfeld = new bagchal.model.Spielfeld();
		bagchal.model.Spielstatus spielstatus = new bagchal.model.Spielstatus();
		bagchal.model.Spieler spieler = new bagchal.model.Spieler();
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 1);
		spieler.tigerSprung(spielfeld, spielstatus, 0, 0, 0, 2);
		
		assertEquals(1, spielstatus.gefresseneZiegen());
	}
	
	// Prüfen ob Dekrementierung von noch zusetzenden Ziegen funktioniert
	public void testZiegenSetzen() {
		bagchal.model.Spielfeld spielfeld = new bagchal.model.Spielfeld();
		bagchal.model.Spielstatus spielstatus = new bagchal.model.Spielstatus();
		bagchal.model.Spieler spieler = new bagchal.model.Spieler();
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 1);
		
		assertEquals(19, spielstatus.zusetzendeZiegen());
	}
	
	// Prüfen ob Spieler jeweils abwechselnd aufgerufen werden
	public void testSpielerWechsel() {
		bagchal.model.Spielfeld spielfeld = new bagchal.model.Spielfeld();
		bagchal.model.Spielstatus spielstatus = new bagchal.model.Spielstatus();
		bagchal.model.Spieler spieler = new bagchal.model.Spieler();
		
		assertEquals(bagchal.model.Spieler.SPIELER_NUMMER_ZIEGE, spielstatus.aktuellerSpieler());
		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 1);
		assertEquals(bagchal.model.Spieler.SPIELER_NUMMER_TIGER, spielstatus.aktuellerSpieler());
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 1, 0);
		assertEquals(bagchal.model.Spieler.SPIELER_NUMMER_ZIEGE, spielstatus.aktuellerSpieler());
	}
	
	// Prüfe ob Spiel als gewonnen ausgegeben wird --> Tiger -- spielGewonnen()
	public void testSpielGewonnenTiger() {
		bagchal.model.Spielfeld spielfeld = new bagchal.model.Spielfeld();
		bagchal.model.Spielstatus spielstatus = new bagchal.model.Spielstatus();
		bagchal.model.Spieler spieler = new bagchal.model.Spieler();
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 1);
		spieler.tigerSprung(spielfeld, spielstatus, 0, 0, 0, 2);
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 1, 4);
		spieler.tigerSprung(spielfeld, spielstatus, 0, 4, 2, 4);
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 4, 3);
		spieler.tigerSprung(spielfeld, spielstatus, 4, 4, 4, 2);
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 3, 0);
		spieler.tigerSprung(spielfeld, spielstatus, 4, 0, 2, 0);
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 2, 1);
		spieler.tigerSprung(spielfeld, spielstatus, 2, 0, 2, 2);
		
		assertTrue(spielstatus.spielGewonnen());
	}

	// Prüfe ob Spiel als gewonnen ausgegeben wird --> Ziege -- spielGewonnen()
	public void testSpielGewonnenZiege() {
		bagchal.model.Spielfeld spielfeld = new bagchal.model.Spielfeld();
		bagchal.model.Spielstatus spielstatus = new bagchal.model.Spielstatus();
		bagchal.model.Spieler spieler = new bagchal.model.Spieler();
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 2);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 3);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 1, 0, 0);
		spieler.ziegeSetzen(spielfeld, spielstatus, 1, 0);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 1, 1);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 1, 0, 0);
		spieler.ziegeSetzen(spielfeld, spielstatus, 1, 3);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 1, 4);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 1, 0, 0);
		spieler.ziegeSetzen(spielfeld, spielstatus, 2, 0);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 2, 2);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 1, 0, 0);
		spieler.ziegeSetzen(spielfeld, spielstatus, 2, 4);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 3, 0);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 1, 0, 0);
		spieler.ziegeSetzen(spielfeld, spielstatus, 3, 1);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 3, 3);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 1, 0, 0);
		spieler.ziegeSetzen(spielfeld, spielstatus, 3, 4);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 4, 1);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 1, 0, 0);
		spieler.ziegeSetzen(spielfeld, spielstatus, 4, 2);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 4, 3);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 1, 0, 0);
		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 1);
		
		assertTrue(spielstatus.spielGewonnen());
	}
	
	// Prüfen ob Spiel als gewonnen oder nicht gewonnen erkannt wird --> Tiger -- spielGewonnenSpieler()
	public void testSpielGewonnenAusgabeTiger() {
		bagchal.model.Spielfeld spielfeld = new bagchal.model.Spielfeld();
		bagchal.model.Spielstatus spielstatus = new bagchal.model.Spielstatus();
		bagchal.model.Spieler spieler = new bagchal.model.Spieler();
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 1);
		spieler.tigerSprung(spielfeld, spielstatus, 0, 0, 0, 2);
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 1, 4);
		spieler.tigerSprung(spielfeld, spielstatus, 0, 4, 2, 4);
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 4, 3);
		spieler.tigerSprung(spielfeld, spielstatus, 4, 4, 4, 2);
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 3, 0);
		spieler.tigerSprung(spielfeld, spielstatus, 4, 0, 2, 0);
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 2, 1);
		spieler.tigerSprung(spielfeld, spielstatus, 2, 0, 2, 2);
		
		assertEquals(bagchal.model.Spieler.SPIELER_NUMMER_TIGER, spielstatus.spielGewonnenSpieler());
	}
	
	// Prüfen ob Spiel als gewonnen oder nicht gewonnen erkannt wird --> Ziege -- spielGewonnenSpieler()
	public void testSpielGewonnenAusgabeZiege() {
		bagchal.model.Spielfeld spielfeld = new bagchal.model.Spielfeld();
		bagchal.model.Spielstatus spielstatus = new bagchal.model.Spielstatus();
		bagchal.model.Spieler spieler = new bagchal.model.Spieler();
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 2);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 3);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 1, 0, 0);
		spieler.ziegeSetzen(spielfeld, spielstatus, 1, 0);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 1, 1);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 1, 0, 0);
		spieler.ziegeSetzen(spielfeld, spielstatus, 1, 3);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 1, 4);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 1, 0, 0);
		spieler.ziegeSetzen(spielfeld, spielstatus, 2, 0);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 2, 2);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 1, 0, 0);
		spieler.ziegeSetzen(spielfeld, spielstatus, 2, 4);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 3, 0);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 1, 0, 0);
		spieler.ziegeSetzen(spielfeld, spielstatus, 3, 1);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 3, 3);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 1, 0, 0);
		spieler.ziegeSetzen(spielfeld, spielstatus, 3, 4);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 4, 1);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 1, 0, 0);
		spieler.ziegeSetzen(spielfeld, spielstatus, 4, 2);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 4, 3);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 1, 0, 0);
		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 1);
		
		assertEquals(bagchal.model.Spieler.SPIELER_NUMMER_ZIEGE, spielstatus.spielGewonnenSpieler());
	}
}