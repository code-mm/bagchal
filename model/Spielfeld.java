package bagchal.model;

/**
 * Ein Spielfeld mit Möglichkeit zur Anzeige und Änderung,
 * sowie Überprüfung gültiger Spielzüge.
 */
public class Spielfeld {
	private int[][] spielfeld;
	
	private static int [] [] zuege = {
		{0, 1, 2, 0, 0, 1, 1, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{1, 0, 1, 2, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{2, 1, 0, 1, 2, 0, 1, 1, 1, 0, 2, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 2, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 2, 1, 0, 0, 0, 0, 1, 1, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{1, 0, 0, 0, 0, 0, 1, 2, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{1, 1, 1, 0, 0, 1, 0, 1, 2, 0, 1, 1, 1, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0},
		{0, 0, 1, 0, 0, 2, 1 ,0, 1, 2, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 1, 1, 1, 0, 2, 1, 0, 1, 0, 0, 1, 1, 1, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 1, 0, 0, 2, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
		{2, 0, 2, 0, 0, 1, 1, 0, 0, 0, 0, 1, 2, 0, 0, 1, 1, 0, 0, 0, 2, 0, 2, 0, 0},
		{0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 2, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0},
		{2, 0, 2, 0, 2, 0, 1, 1, 1, 0, 2, 1, 0, 1, 2, 0, 1, 1, 1, 0, 2, 0, 2, 0, 2},
		{0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 2, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0},
		{0, 0, 2, 0, 2, 0, 0, 0, 1, 1, 0, 0, 2, 1, 0, 0, 0, 0, 1, 1, 0, 0, 2, 0, 2},
		{0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 2, 0, 0, 1, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 1, 1, 1, 0, 0, 1, 0, 1, 2, 0, 1, 1, 1, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 2, 1, 0, 1, 2, 0, 0, 1, 0, 0},
		{0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 1, 1, 1, 0, 2, 1, 0, 1, 0, 0, 1, 1, 1},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 2, 1, 0, 0, 0, 0, 0, 1},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 1, 1, 0, 0, 0, 0, 1, 2, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 2, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 2, 0, 1, 1, 1, 0, 2, 1, 0, 1, 2},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 2, 1, 0, 1},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 1, 1, 0, 0, 2, 1, 0}
	};
	
	/**
	 * Erzeugt das Spielfeld und setzt die Tiger für den Spielbeginn.
	 */
	public Spielfeld() {
		this.spielfeld = new int[5][5];
		
		// Tiger setzen
		this.spielfeld[0][0] = 1;
		this.spielfeld[0][4] = 1;
		this.spielfeld[4][0] = 1;
		this.spielfeld[4][4] = 1;
	}
	
	/**
	 * Ausgabe des aktuell gültigen Spielfeldes.
	 * @return	Gibt das Spielfeld zurück
	 */
	public int[][] getSpielfeld() {
		return this.spielfeld;
	}
	
	// Gibt das übergebene Feld aus der Adjazentmatrix zurück
	private int getZuege(int zeile, int spalte) {
		return Spielfeld.zuege[zeile][spalte];
	}
	
	// Ändert ein Spielfeld zum gegebenen Wert
	void feldSetzen(int zielZeile, int zielSpalte, int wert) {
		this.spielfeld[zielZeile][zielSpalte] = wert;
	}
	
	// Vertauscht den Wert zweier gegebener Spielfelder 
	void feldTausch(int ursprungsZeile, int ursprungsSpalte, int zielZeile, int zielSpalte) {
		int figur = this.spielfeld[ursprungsZeile][ursprungsSpalte];
		this.spielfeld[ursprungsZeile][ursprungsSpalte] = 0;
		this.spielfeld[zielZeile][zielSpalte] = figur;
	}

	// Prüft übergebene Spielfeldkoordinaten auf Gültigkeit
	private boolean pruefeSpielfeldWerte(int zeile, int spalte) {
		if(zeile >= 0 & zeile < 5 & spalte >= 0 & spalte < 5) {
			return true;
		} else {
			return false;
		}
	}
	
	// Prüft ob Figur auf Spielfeld gesetzt werden kann
	boolean pruefeSetzen(int zielZeile, int zielSpalte) {
		// Prüfen ob übergebene Spielfeldwerte gültig
		if(this.pruefeSpielfeldWerte(zielZeile, zielSpalte)) {
			// Prüfen ob Feld leer
			if(this.getSpielfeld()[zielZeile][zielSpalte] == 0) {
				return true;
			}
		}
		return false;
	}
	
	// Prüft ob Figur auf Spielfeld verschoben werden kann
	boolean pruefeVerschieben(int ursprungsZeile, int ursprungsSpalte, int zielZeile, int zielSpalte) {
		// Prüfen ob übergebene Spielfeldwerte gültig
		if(this.pruefeSpielfeldWerte(ursprungsZeile, ursprungsSpalte) & this.pruefeSpielfeldWerte(zielZeile, zielSpalte)) {
			// Prüfen ob Feld leer und verschieben erlaubt
			if(this.getSpielfeld()[zielZeile][zielSpalte] == 0 &
				this.getZuege((ursprungsZeile*5+ursprungsSpalte), (zielZeile*5+zielSpalte)) == 1) {
				return true;
			}
		}
		return false;
	}
	
	// Prüft ob Figur auf Spielfeld springen kann 
	boolean pruefeSpringen(int ursprungsZeile, int ursprungsSpalte, int zielZeile, int zielSpalte) {
		// Prüfen ob übergebene Spielfeldwerte gültig
		if(this.pruefeSpielfeldWerte(ursprungsZeile, ursprungsSpalte) & this.pruefeSpielfeldWerte(zielZeile, zielSpalte)) {
			// Prüfen ob Feld leer und springen erlaubt
			if(this.getSpielfeld()[zielZeile][zielSpalte] == 0 & this.getZuege(ursprungsZeile*5+ursprungsSpalte, zielZeile*5+zielSpalte) == 2) {
				return true;
			}
		}
		return false;
	}
}