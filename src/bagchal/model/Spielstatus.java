package bagchal.model;

/**
 * Spielstatus ist verantwortlich für den Spielstatus und aktualisiert
 * diesen bei Aufruf.
 */
public class Spielstatus {
	private boolean spielGewonnen;
	private int spielGewonnenSpieler;
	private int gefresseneZiegen;
	private int zusetzendeZiegen;
	private int aktuellerSpieler;
	
	/**
	 * Erzeugt die am Anfang des Spiels benötigten Spielstati.
	 */
	public Spielstatus() {
		this.spielGewonnen = false;
		this.spielGewonnenSpieler = 0;
		this.gefresseneZiegen = 0;
		this.zusetzendeZiegen = 20;
		this.aktuellerSpieler = 2;
	}
	
	/**
	 * Die Anzahl der durch Figur Tiger übersprungenen Ziegen. 
	 * @return	Anzahl der übersprungenen Ziegen 
	 */
	public int gefresseneZiegen() {
		return this.gefresseneZiegen;
	}
	
	// Erhöht die durch Spieler "Tiger" übersprungenen Figuren
	void gefresseneZiegenErhoehen() {
		this.gefresseneZiegen++;
	}
	
	/**
	 * Die Anzahl der noch zu setzenden Figuren des Spielers Ziege.
	 * @return	Anzahl der noch zu setzenden Ziegen
	 */
	public int zusetzendeZiegen() {
		return this.zusetzendeZiegen;
	}
	
	// Reduziert die noch durch Spieler "Ziege" zu setzenden Figuren
	void zusetzendeZiegenReduzieren() {
		this.zusetzendeZiegen--;
	}
	
	/**
	 * Die Spielernummer des aktuell für einen Zug berechtigten Spielers.
	 * @return	Spielernummer des aktuellen Spielers
	 */
	public int aktuellerSpieler() {
		return this.aktuellerSpieler;
	}
	
	// Wechselt zum anderen Spieler, für nächste Spielrunde
	void naechsterSpieler() {
		if(this.aktuellerSpieler() == Spieler.SPIELER_NUMMER_TIGER) {
			this.aktuellerSpieler = Spieler.SPIELER_NUMMER_ZIEGE;
		} else {
			this.aktuellerSpieler = Spieler.SPIELER_NUMMER_TIGER;
		}
	}
	
	// Prüft ob Spiel durch einen Spieler gewonnen wurde
	void pruefeGewonnen(bagchal.model.Spielfeld spielfeld) {
		if(this.gefresseneZiegen() == 5) {
			this.spielGewonnenSpieler = Spieler.SPIELER_NUMMER_TIGER;
			this.spielGewonnen = true;
		}
		
		if(this.keineVerbleibendeZuege(spielfeld)) {
			this.spielGewonnenSpieler = Spieler.SPIELER_NUMMER_ZIEGE;
			this.spielGewonnen = true;
		}
	}
	
	/*
	 * Prüft ob für Spieler "Tiger" noch weitere Züge möglich sind.
	 * Gibt True zurück, wenn keine Züge mehr möglich sind.
	 */
	private boolean keineVerbleibendeZuege(bagchal.model.Spielfeld spielfeld) {
		int[][] tigerFelder = tigerFinden(spielfeld);
		
		// Schleife für die Anzahl der Tiger
		for(int i = 0; i < tigerFelder.length; i++) {
			// Schleife für Zeilen des Spielfeldes
			for(int j = 0; j < spielfeld.getSpielfeld().length; j++) {
				// Schleife für Spalten des Spielfeldes
				for(int k = 0; k < spielfeld.getSpielfeld()[j].length; k++) {
					// Prüfen ob ein gültiger Zug für Spieler "Tiger" existiert
					if(spielfeld.pruefeVerschieben(tigerFelder[i][0], tigerFelder[i][0], j, k) |
							spielfeld.pruefeSpringen(tigerFelder[i][0], tigerFelder[i][0], j, k)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	// Gibt die Felder mit der Figur "Tiger" zurück
	private int[][] tigerFinden(bagchal.model.Spielfeld spielfeld) {
		int[][] tigerFelder = new int[4][2];
		int tigerFelderZaehler = 0;
		
		// Suche nach Tigern auf Spielfeld
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(spielfeld.getSpielfeld()[i][j] == Spieler.SPIELER_NUMMER_TIGER) {
					tigerFelder[tigerFelderZaehler][0] = i;
					tigerFelder[tigerFelderZaehler][1] = j;
					tigerFelderZaehler++;
				}
			}
		}
		return tigerFelder;
	}
	
	/**
	 * Gibt an ob das Spiel gewonnen wurde.
	 * @return	Gibt True zurück wenn Spiel gewonnen wurde
	 */
	public boolean spielGewonnen() {
		return this.spielGewonnen;
	}
	
	/**
	 * Gibt die Spielernummer des Gewinners an.
	 * @return	Gibt die Spielernummer des Gewinners zurück
	 */
	public int spielGewonnenSpieler() {
		return this.spielGewonnenSpieler;
	}
}