package bagchal.model;

/**
 * Spieler ist verantwortlich für den korrekten und
 * vollständigen Ablauf der Spieloperationen.
 */
public class Spieler {
	/**
	 * Spielernummer des Spielers "Tiger" für Spielfeld
	 */
	public static final int SPIELER_NUMMER_TIGER = 1;
	/**
	 * Spielernummer des Spielers "Ziege" für Spielfeld
	 */
	public static final int SPIELER_NUMMER_ZIEGE = 2;

	/**
	 * Erzeugt die Spieler mit den jeweiligen Spielernummern
	 * und die zum bewegen der Figuren benötigten Operationen. 
	 */
	public Spieler() {
	}

	/**
	 * Setzt Figur "Ziege" auf Spielfeld.
	 * 
	 * @param spielfeld		Das genutzte Spielfeld zur Abbildung der Spielzüge
	 * @param spielstatus	Der Spielstatus des Spiels
	 * @param zielZeile		Die Zeile in der die Ziege gesetzt werden soll
	 * @param zielSpalte	Die Spalte in der die Ziege gesetzt werden soll
	 * @return				Gibt True zurück wenn setzen erfolgreich war
	 */
	public boolean ziegeSetzen(bagchal.model.Spielfeld spielfeld,
			bagchal.model.Spielstatus spielstatus, int zielZeile, int zielSpalte) {
		// Überprüfen ob eingebene Spielfeldwerte gültig und setzen möglich
		if(spielfeld.pruefeSetzen(zielZeile, zielSpalte)) {
			// Überprüfen ob Spieler an der Reihe und verbleibende Ziegen zu setzen
			if(spielstatus.aktuellerSpieler() == SPIELER_NUMMER_ZIEGE & spielstatus.zusetzendeZiegen() > 0) {
				spielfeld.feldSetzen(zielZeile, zielSpalte, 2);
				spielstatus.zusetzendeZiegenReduzieren();
				spielstatus.pruefeGewonnen(spielfeld);
				spielstatus.naechsterSpieler();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Bewegt Figuren "Tiger" oder "Ziege" schrittweise über das Spielfeld.
	 * 
	 * @param spielfeld			Das genutzte Spielfeld zur Abbildung der Spielzüge
	 * @param spielstatus		Der Spielstatus des Spiels
	 * @param ursprungsZeile	Die Zeile von welcher die Figur verschoben werden soll
	 * @param ursprungsSpalte	Die Spalte von welcher die Figur verschoben werden soll
	 * @param zielZeile			Die Zeile in der die Ziege gesetzt werden soll
	 * @param zielSpalte		Die Spalte in der die Ziege gesetzt werden soll
	 * @return					Gibt True zurück wenn verschieben erfolgreich war
	 */
	public boolean figurVerschieben(bagchal.model.Spielfeld spielfeld,
			bagchal.model.Spielstatus spielstatus, int ursprungsZeile, int ursprungsSpalte,
			int zielZeile, int zielSpalte) {
		// Überprüfen ob eingebene Spielfeldwerte gültig und Verschieben möglich
		if(spielfeld.pruefeVerschieben(ursprungsZeile, ursprungsSpalte, zielZeile, zielSpalte)) {
			// Überprüfen ob Spieler "Ziege" an der Reihe, verbleibende Ziegen vorhanden und Figur auf Spielfeld Ziege ist
			if(spielstatus.aktuellerSpieler() == SPIELER_NUMMER_ZIEGE &&
					(spielstatus.zusetzendeZiegen() == 0 &
					spielfeld.getSpielfeld()[ursprungsZeile][ursprungsSpalte] == SPIELER_NUMMER_ZIEGE)) {
				spielfeld.feldTausch(ursprungsZeile, ursprungsSpalte, zielZeile, zielSpalte);
				spielstatus.pruefeGewonnen(spielfeld);
				spielstatus.naechsterSpieler();
				return true;
			}
			
			// Überprüfen ob Spieler "Tiger" an der Reihe und Figur auf Spielfeld Tiger ist
			if(spielstatus.aktuellerSpieler() == SPIELER_NUMMER_TIGER &&
					spielfeld.getSpielfeld()[ursprungsZeile][ursprungsSpalte] == SPIELER_NUMMER_TIGER) {
				spielfeld.feldTausch(ursprungsZeile, ursprungsSpalte, zielZeile, zielSpalte);
				spielstatus.pruefeGewonnen(spielfeld);
				spielstatus.naechsterSpieler();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Bewegt die Figur "Tiger" zwei Spielfelder weiter und
	 * löscht das übersprungene Spielfeld, wenn auf diesem
	 * die Figur "Ziege" stand.
	 * 
	 * @param spielfeld			Das genutzte Spielfeld zur Abbildung der Spielzüge
	 * @param spielstatus		Der Spielstatus des Spiels
	 * @param ursprungsZeile	Die Zeile von welcher der Tiger springen soll
	 * @param ursprungsSpalte	Die Spalte von welcher der Tiger springen soll
	 * @param zielZeile			Die Zeile in welche der Tiger springen soll
	 * @param zielSpalte		Die Spalte in welcher der Tiger springen soll
	 * @return					Gibt True zurück wenn springen erfolgreich war
	 */
	public boolean tigerSprung(bagchal.model.Spielfeld spielfeld,
			bagchal.model.Spielstatus spielstatus, int ursprungsZeile, int ursprungsSpalte,
			int zielZeile, int zielSpalte) {
		// Überprüfen ob eingebene Spielfeldwerte gültig und Sprung möglich
		if(spielfeld.pruefeSpringen(ursprungsZeile, ursprungsSpalte, zielZeile, zielSpalte)) {
			// Überprüfen ob Spieler "Tiger" an der Reihe, Figur auf Spielfeld Tiger ist und übersprungenes Spielfeld eine Zeige enthält
			if(spielstatus.aktuellerSpieler() == SPIELER_NUMMER_TIGER &&
					(spielfeld.getSpielfeld()[ursprungsZeile][ursprungsSpalte] == SPIELER_NUMMER_TIGER &
					spielfeld.getSpielfeld()[ursprungsZeile - ((ursprungsZeile - zielZeile) / 2)]
							[ursprungsSpalte - ((ursprungsSpalte - zielSpalte) / 2)] == SPIELER_NUMMER_ZIEGE)) {
				spielfeld.feldTausch(ursprungsZeile, ursprungsSpalte, zielZeile, zielSpalte);
				spielfeld.feldSetzen(ursprungsZeile - ((ursprungsZeile - zielZeile) / 2), ursprungsSpalte - ((ursprungsSpalte - zielSpalte) / 2), 0);
				spielstatus.gefresseneZiegenErhoehen();
				spielstatus.pruefeGewonnen(spielfeld);
				spielstatus.naechsterSpieler();
				return true;
			}
		}
		return false;
	}
}