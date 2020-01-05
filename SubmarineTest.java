package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubmarineTest {
	Submarine testSubmarineObject;
	@BeforeEach
	void setUp() throws Exception {
		testSubmarineObject = new Submarine();
	}

	@Test
	void testGetShipType() {
		assertEquals("submarine", testSubmarineObject.getShipType());
	}

	@Test
	void testSubmarine() {
		assertEquals(1, testSubmarineObject.getLength());
	}

}
