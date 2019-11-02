package bagchal.tests;

import java.util.Arrays;

import junit.framework.TestCase;

public class SpielfeldTest extends TestCase {
	
	// Prüfen ob initiales Spielfeld korrekt ist
	public void testSpielfeldInitial() {
		bagchal.model.Spielfeld spielfeld = new bagchal.model.Spielfeld();
		
		int[][] initSpielfeld = {
			{1,0,0,0,1},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{1,0,0,0,1},
		};
		
		assertTrue(Arrays.deepEquals(initSpielfeld, spielfeld.getSpielfeld()));
	}
}