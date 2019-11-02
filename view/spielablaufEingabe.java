package bagchal.view;

import bagchal.model.Spieler;

/**
 * Verantwortlich für alle Texteingaben des Spiels auf der Konsole.
 */
public class spielablaufEingabe {
	private bagchal.model.Spielstatus spielstatus;
	private bagchal.model.Spielfeld spielfeld;
	private bagchal.model.Spieler spieler;
	private java.util.Scanner scanner;
	
	/**
	 * Erzeugt die Texteingaben, basierend auf Spielumgebung.
	 * @param spieler		Die Spieler mit den entsprechenden Spieloperationen
	 * @param spielfeld		Das genutzte Spielfeld zur Abbildung der Spielzüge
	 * @param spielstatus	Der Spielstatus des Spiels
	 * @param scanner		Scanner für Benutzereingaben
	 */
	public spielablaufEingabe(bagchal.model.Spieler spieler,
			bagchal.model.Spielfeld spielfeld,
			bagchal.model.Spielstatus spielstatus,
			java.util.Scanner scanner) {
		this.spielstatus = spielstatus;
		this.spielfeld = spielfeld;
		this.spieler = spieler;
		this.scanner = scanner;
	}
	
	// Prüft ob der eingegebene Wert ein Integer ist
	private int eingabeZugPruefen() {
		// Prüfen ob die Eingabe ein Integer ist
		while(! this.scanner.hasNextInt()) {
			System.out.println("Fehler: Bitte ganze Zahl eingeben.");
			this.scanner.nextLine();
		}
		return (this.scanner.nextInt()-1);
	}
	
	/**
	 * Prüft basierend auf Spielerreihenfolge sowie Benutzereingabe
	 * welcher Spielzug angefordert wurde und fordert diesen an.
	 */
	public void eingabeZug() {
		// Unterscheidung zwischen Tiger und Ziege
		if(this.spielstatus.aktuellerSpieler() == Spieler.SPIELER_NUMMER_TIGER) {
			eingabeZugTiger();
		} else {
			eingabeZugZiege();
		}
	}
	
	private void eingabeZugTiger() {
		System.out.print("Tiger Ursprungsfeld (Zeile): ");
		int ursprungsZeile = this.eingabeZugPruefen();
		System.out.print("Tiger Ursprungsfeld (Spalte): ");
		int ursprungsSpalte = this.eingabeZugPruefen();
		System.out.print("Tiger Zielfeld (Zeile): ");
		int zielZeile = this.eingabeZugPruefen();
		System.out.print("Tiger Zielfeld (Spalte): ");
		int zielSpalte = this.eingabeZugPruefen();
		
		// Unterscheidung zwischen Verschieben und Sprung
		if(Math.abs(zielZeile - ursprungsZeile) == 2 | Math.abs(zielSpalte - ursprungsSpalte) == 2) {
			// Prüfen ob Zug ausgeführt werden konnte
			if(! this.spieler.tigerSprung(spielfeld, spielstatus, ursprungsZeile, ursprungsSpalte, zielZeile, zielSpalte)) {
				System.out.println("Fehler: Ungültiger Zug");
			}
		} else {
			// Prüfen ob Zug ausgeführt werden konnte
			if(! this.spieler.figurVerschieben(spielfeld, spielstatus, ursprungsZeile, ursprungsSpalte, zielZeile, zielSpalte)) {
				System.out.println("Fehler: Ungültiger Zug");
			}
		}
	}
	
	private void eingabeZugZiege() {
		// Unterscheidung zwischen Ziege setzen oder bewegen
		if(this.spielstatus.zusetzendeZiegen() > 0) {
			System.out.print("Ziege setzen (Zeile): ");
			int zielZeile = this.eingabeZugPruefen();
			System.out.print("Ziege setzen (Spalte): ");
			int zielSpalte = this.eingabeZugPruefen();

			// Prüfen ob Zug ausgeführt werden konnte
			if(! this.spieler.ziegeSetzen(spielfeld, spielstatus, zielZeile, zielSpalte)) {
				System.out.println("Fehler: Ungültiger Zug");
			}
		} else {
			System.out.print("Ziege Ursprungsfeld (Zeile): ");
			int ursprungsZeile = this.eingabeZugPruefen();
			System.out.print("Ziege Ursprungsfeld (Spalte): ");
			int ursprungsSpalte = this.eingabeZugPruefen();
			System.out.print("Ziege Zielfeld (Zeile): ");
			int zielZeile = this.eingabeZugPruefen();
			System.out.print("Ziege Zielfeld (Spalte): ");
			int zielSpalte = this.eingabeZugPruefen();

			// Prüfen ob Zug ausgeführt werden konnte
			if(! this.spieler.tigerSprung(spielfeld, spielstatus, ursprungsZeile, ursprungsSpalte, zielZeile, zielSpalte)) {
				System.out.println("Fehler: Ungültiger Zug");
			}
		}
	}
}
