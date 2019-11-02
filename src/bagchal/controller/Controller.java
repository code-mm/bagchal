package bagchal.controller;

/**
 * Controller ist verantwortlich für die korrekte
 * Abarbeitung der einzelnen Spieloperationen. 
 */
public class Controller {
	private bagchal.model.Spielstatus spielstatus;
	private bagchal.view.spielablaufAusgabe spielablaufAusgabe;
	private bagchal.view.spielablaufEingabe spielablaufEingabe;
	
	/**
	 * Erzeugt die notwendigen Objekte für die Spielumgebung.
	 * 
	 * @param spielstatus			Der Spielstatus des Spiels
	 * @param spielablaufAusgabe	Erzeugt alle Ausgaben des Spiels
	 * @param spielablaufEingabe	Nimmt alle Eingaben des Spiels entgegen
	 */
	public Controller(bagchal.model.Spielstatus spielstatus,
			bagchal.view.spielablaufAusgabe spielablaufAusgabe,
			bagchal.view.spielablaufEingabe spielablaufEingabe) {
		this.spielstatus = spielstatus;
		this.spielablaufAusgabe = spielablaufAusgabe;
		this.spielablaufEingabe = spielablaufEingabe;
	}
	
	/**
	 * Startet den Spielablauf und
	 * steuert diesen bis zum Spielende.
	 */
	public void starteSpiel() {		
		while(!spielstatus.spielGewonnen()) {
			// Spielfeld anzeigen
			spielablaufAusgabe.zeigeSpielfeld();
			
			// Anzahl der gefressenen Ziegen ausgeben
			spielablaufAusgabe.zeigeGefresseneZiegen();
			
			// Anzahl der zu setzenden Ziegen ausgeben
			spielablaufAusgabe.zeigeZusetzendeZiegen();
			
			// Ausgabe des aktuellen Spielers
			spielablaufAusgabe.zeigeAktuellenSpieler();
			
			// Abfrage der zu setzenden Figuren - Tiger/Ziege
			spielablaufEingabe.eingabeZug();
			
			// Grenze zu neuer Spieloperation
			spielablaufAusgabe.spielschrittSeperator();
		}
			
		// Ausgabe das Spiel gewonnen mit Spieler
		spielablaufAusgabe.spielGewonnen();
	}
}
