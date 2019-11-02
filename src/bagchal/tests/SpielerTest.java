package bagchal.tests;

import junit.framework.TestCase;

public class SpielerTest extends TestCase {
	// Prüfen ob Ziege setzen funktioniert
	public void testZiegeSetzen() {
		bagchal.model.Spielfeld spielfeld = new bagchal.model.Spielfeld();
		bagchal.model.Spielstatus spielstatus = new bagchal.model.Spielstatus();
		bagchal.model.Spieler spieler = new bagchal.model.Spieler();
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 1);
		
		assertEquals(2, spielfeld.getSpielfeld()[0][1]);
	}
	
	// Prüfen ob Tiger verschieben funktioniert
	public void testTigerVerschieben() {
		bagchal.model.Spielfeld spielfeld = new bagchal.model.Spielfeld();
		bagchal.model.Spielstatus spielstatus = new bagchal.model.Spielstatus();
		bagchal.model.Spieler spieler = new bagchal.model.Spieler();

		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 1);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 1, 0);
		
		assertEquals(0, spielfeld.getSpielfeld()[0][0]);
		assertEquals(1, spielfeld.getSpielfeld()[1][0]);
	}
	
	// Prüfen ob Tiger springen funktioniert
	public void testTigerSpringen() {
		bagchal.model.Spielfeld spielfeld = new bagchal.model.Spielfeld();
		bagchal.model.Spielstatus spielstatus = new bagchal.model.Spielstatus();
		bagchal.model.Spieler spieler = new bagchal.model.Spieler();
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 1);
		spieler.tigerSprung(spielfeld, spielstatus, 0, 0, 0, 2);
		
		assertEquals(0, spielfeld.getSpielfeld()[0][0]);
		assertEquals(0, spielfeld.getSpielfeld()[0][1]);
		assertEquals(1, spielfeld.getSpielfeld()[0][2]);
	}
	
	// Prüfen ob Wechsel von Ziege setzen zu verschieben funktioniert
	public void testZiegeEingabeWechsel() {
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
		spieler.ziegeSetzen(spielfeld, spielstatus, 1, 2);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 1, 3);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 1, 0, 0);
		spieler.ziegeSetzen(spielfeld, spielstatus, 1, 4);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 2, 0);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 1, 0, 0);
		spieler.ziegeSetzen(spielfeld, spielstatus, 2, 1);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 2, 2);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 1, 0, 0);
		spieler.ziegeSetzen(spielfeld, spielstatus, 2, 3);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 2, 4);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 1, 0, 0);
		spieler.ziegeSetzen(spielfeld, spielstatus, 3, 0);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 3, 1);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 1, 0, 0);
		spieler.ziegeSetzen(spielfeld, spielstatus, 3, 2);
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
		
		assertTrue(spieler.figurVerschieben(spielfeld, spielstatus, 0, 2, 0, 1));
		assertEquals(0, spielfeld.getSpielfeld()[0][2]);
		assertEquals(bagchal.model.Spieler.SPIELER_NUMMER_ZIEGE, spielfeld.getSpielfeld()[0][1]);
	}
	
	// Prüfen ob Ziegen sich schon vor dem Setzen aller Ziegen verschieben lassen
	public void testZiegeEingabeWechselVorzeitig() {
		bagchal.model.Spielfeld spielfeld = new bagchal.model.Spielfeld();
		bagchal.model.Spielstatus spielstatus = new bagchal.model.Spielstatus();
		bagchal.model.Spieler spieler = new bagchal.model.Spieler();
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 2);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);

		assertFalse(spieler.figurVerschieben(spielfeld, spielstatus, 0, 2, 0, 3));
	}
	
	// Falche Werte für Zug innerhalb des Spielfeldes
	public void testFalscheWerteInnerhalbSpielfeld() {
		bagchal.model.Spielfeld spielfeld = new bagchal.model.Spielfeld();
		bagchal.model.Spielstatus spielstatus = new bagchal.model.Spielstatus();
		bagchal.model.Spieler spieler = new bagchal.model.Spieler();
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 2);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, 1);
		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 3);
		
		assertFalse(spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 1, 2));
	}
	
	
	// Falcher Wert für Zug außerhalb des Spielfeldes
	public void testFalscheWerteAusserhalbSpielfeld() {
		bagchal.model.Spielfeld spielfeld = new bagchal.model.Spielfeld();
		bagchal.model.Spielstatus spielstatus = new bagchal.model.Spielstatus();
		bagchal.model.Spieler spieler = new bagchal.model.Spieler();
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 2);
		
		assertFalse(spieler.figurVerschieben(spielfeld, spielstatus, 0, 0, 0, -1));
	}

	// Ziege auf andere Figur setzen
	public void testZiegeFalschSetzen() {
		bagchal.model.Spielfeld spielfeld = new bagchal.model.Spielfeld();
		bagchal.model.Spielstatus spielstatus = new bagchal.model.Spielstatus();
		bagchal.model.Spieler spieler = new bagchal.model.Spieler();
		
		assertFalse(spieler.ziegeSetzen(spielfeld, spielstatus, 0, 0));
	}
	
	// Tiger über Tiger springen
	public void testTigerSprungTiger() {
		bagchal.model.Spielfeld spielfeld = new bagchal.model.Spielfeld();
		bagchal.model.Spielstatus spielstatus = new bagchal.model.Spielstatus();
		bagchal.model.Spieler spieler = new bagchal.model.Spieler();
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 1);
		spieler.tigerSprung(spielfeld, spielstatus, 0, 0, 0, 2);
		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 0);
		spieler.figurVerschieben(spielfeld, spielstatus, 0, 4, 0, 3);
		spieler.ziegeSetzen(spielfeld, spielstatus, 1, 0);
		
		assertFalse(spieler.tigerSprung(spielfeld, spielstatus, 0, 3, 0, 1));
	}

	// Tiger über mehr als zwei Felder springen
	public void testTigerLangerSprung() {
		bagchal.model.Spielfeld spielfeld = new bagchal.model.Spielfeld();
		bagchal.model.Spielstatus spielstatus = new bagchal.model.Spielstatus();
		bagchal.model.Spieler spieler = new bagchal.model.Spieler();
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 1);
		
		assertFalse(spieler.tigerSprung(spielfeld, spielstatus, 0, 0, 0, 3));
	}
	
	// Spieler in falscher Reihenfolge spielen
	public void testSpielerReihenfolge() {
		bagchal.model.Spielfeld spielfeld = new bagchal.model.Spielfeld();
		bagchal.model.Spielstatus spielstatus = new bagchal.model.Spielstatus();
		bagchal.model.Spieler spieler = new bagchal.model.Spieler();
		
		spieler.ziegeSetzen(spielfeld, spielstatus, 0, 1);
		
		assertFalse(spieler.ziegeSetzen(spielfeld, spielstatus, 0, 1));
	}
}