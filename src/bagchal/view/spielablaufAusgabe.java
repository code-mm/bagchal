package bagchal.view;

import bagchal.model.Spieler;

/**
 * Verantwortlich für alle Textausgaben des Spiels auf der Konsole.
 */
public class spielablaufAusgabe {
	private bagchal.model.Spielstatus spielstatus;
	private bagchal.model.Spielfeld spielfeld;
	
	/**
	 * Erzeugt die Textausgaben, basierend auf Spielumgebung.
	 * 
	 * @param spielfeld		Das genutzte Spielfeld zur Abbildung der Spielzüge
	 * @param spielstatus	Der Spielstatus des Spiels
	 */
	public spielablaufAusgabe(bagchal.model.Spieler spieler, bagchal.model.Spielfeld spielfeld, bagchal.model.Spielstatus spielstatus) {
		this.spielstatus = spielstatus;
		this.spielfeld = spielfeld;
	}
	
	/**
	 * Zeigt das Spielfeld aufgelöst in die jeweiligen Figuren und mit den Spielfeldlinien.
	 */
	public void zeigeSpielfeld() {
		// Durchläuft das Spielfeld zeilenweise
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				// Feld ausgeben mit Auflösung der Spielerkürzel
				if(spielfeld.getSpielfeld()[i][j] == bagchal.model.Spieler.SPIELER_NUMMER_TIGER) {
					System.out.print("T");
				} else if(spielfeld.getSpielfeld()[i][j] == bagchal.model.Spieler.SPIELER_NUMMER_ZIEGE) {
					System.out.print("Z");
				} else {
					System.out.print("+");
				}
				
				// Horizontale Verbindungsstriche ausgeben oder neue Zeile
				if(j < 4) {
					System.out.print("---");
				} else {
					System.out.println();
				}
			}
			
			// Vertikale Verbindungsstriche ausgeben
			if(i == 0 | i == 2) {
				System.out.println("|\\  |  /|\\  |  /|");
				System.out.println("| \\ | / | \\ | / |");
				System.out.println("|  \\|/  |  \\|/  |");
			} else if(i == 1 | i == 3) {
				System.out.println("|  /|\\  |  /|\\  |");
				System.out.println("| / | \\ | / | \\ |");
				System.out.println("|/  |  \\|/  |  \\|");
			}
		}
		System.out.println();
	}
	
	/**
	 * Gibt den aktuellen Spieler aus.
	 */
	public void zeigeAktuellenSpieler() {
		// Überprüft welcher Spieler an der Reihe ist
		if(this.spielstatus.aktuellerSpieler() == Spieler.SPIELER_NUMMER_TIGER) {
			System.out.println("Spieler 'Tiger' ist am Zug.");
		} else {
			System.out.println("Spieler 'Ziege' ist am Zug.");
		}
		
	}
	
	/**
	 * Gibt die bereits gefressenen Ziegen aus.
	 */
	public void zeigeGefresseneZiegen() {
		System.out.println("Anzahl gefressener Ziegen: " + this.spielstatus.gefresseneZiegen());
	}
	
	/**
	 * Gibt die noch zu setzenden Ziegen aus.
	 */
	public void zeigeZusetzendeZiegen() {
		System.out.println("Anzahl zu setzender Ziegen: " + this.spielstatus.zusetzendeZiegen());
	}
	
	/**
	 * Gibt den Gewinner des Spiels, aufgelöst in Spielernamen aus.
	 */
	public void spielGewonnen() {
		// Überprüfen ob Spieler "Tiger" gewonnen hat
		if(spielstatus.spielGewonnenSpieler() == Spieler.SPIELER_NUMMER_TIGER) {
			System.out.println("\n++++ Spieler Tiger hat das Spiel gewonnen. ++++");
		}
		
		// Überprüfen ob Spieler "Ziege" gewonnen hat
		if(spielstatus.spielGewonnenSpieler() == Spieler.SPIELER_NUMMER_ZIEGE) {
			System.out.println("\n++++ Spieler Ziege hat das Spiel gewonnen. ++++");
		}
	}
	
	/**
	 * Gibt eine Seperatorlinie für Spielschrittabtrennung aus.
	 */
	public void spielschrittSeperator() {
		System.out.println();
		System.out.println("------------------------------");
		System.out.println();
	}
}