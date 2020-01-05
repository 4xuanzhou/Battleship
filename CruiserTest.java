package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CruiserTest {
	Cruiser testCruiserObject;
	@BeforeEach
	void setUp() throws Exception {
		testCruiserObject = new Cruiser();
	}

	@Test
	void testGetShipType() {
		assertEquals("cruiser", testCruiserObject.getShipType());
	}

	@Test
	void testCruiser() {
		assertEquals(3, testCruiserObject.getLength());
	}

}
