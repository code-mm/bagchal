package bagchal.main;

import java.util.Scanner;

/**
 * Eine Klasse zum Test des BagChal-Spiels.
 */
public class Main {
	
	/**
	 * Hauptmethode für Programmaufruf.
	 */
	public static void main(String[] args) {
		// Scanner für Texteingabe des Spielers
		Scanner scanner = new Scanner(System.in);
		
		// Objekte des bagchal MVC
		bagchal.model.Spieler spieler = new bagchal.model.Spieler();
		bagchal.model.Spielfeld spielfeld = new bagchal.model.Spielfeld();
		bagchal.model.Spielstatus spielstatus = new bagchal.model.Spielstatus();
		bagchal.view.spielablaufAusgabe spielablaufAusgabe =
				new bagchal.view.spielablaufAusgabe(spieler, spielfeld, spielstatus);
		bagchal.view.spielablaufEingabe spielablaufEingabe =
				new bagchal.view.spielablaufEingabe(spieler, spielfeld, spielstatus, scanner);
		bagchal.controller.Controller bagchal =
				new bagchal.controller.Controller(spielstatus,
				spielablaufAusgabe, spielablaufEingabe);
		
		// Starten des Spiels durch den Controller
		bagchal.starteSpiel();
		
		// Schließen der Eingabe für Spielzüge
		scanner.close();
	}
}