package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmptySeaTest {
	EmptySea testEmptySeaObject;
	@BeforeEach
	void setUp() throws Exception {
		testEmptySeaObject = new EmptySea();
	}

	@Test
	void testGetShipType() {
		assertEquals("empty", testEmptySeaObject.getShipType());
	}

	@Test
	void testShootAt() {
		assertFalse(testEmptySeaObject.shootAt(0,5));
		assertFalse(testEmptySeaObject.shootAt(5,5));
	}

	@Test
	void testIsSunk() {
		assertFalse(testEmptySeaObject.isSunk());
	}

	@Test
	void testToString() {
		assertEquals("-", testEmptySeaObject.toString());
	}

	@Test
	void testEmptySea() {
		assertEquals(1, testEmptySeaObject.getLength());
	}

}
