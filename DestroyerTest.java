package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DestroyerTest {
	Destroyer testDestroyerObject;
	@BeforeEach
	void setUp() throws Exception {
		testDestroyerObject = new Destroyer();
	}

	@Test
	void testGetShipType() {
		assertEquals("destroyer", testDestroyerObject.getShipType());
	}

	@Test
	void testDestroyer() {
		assertEquals(2, testDestroyerObject.getLength());
	}

}
