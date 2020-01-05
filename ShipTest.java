package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShipTest {
	Ship testShipObject;
	Ship testShipObject2;
	@BeforeEach
	void setUp() throws Exception {
		testShipObject = new Battleship();
		testShipObject2 = new Cruiser();
	}

	@Test
	void testGetBowRow() {
		assertEquals(0, testShipObject.getBowRow());
	}

	@Test
	void testSetBowRow() {
		testShipObject.setBowRow(3);
		assertEquals(3, testShipObject.getBowRow());
	}

	@Test
	void testGetBowColumn() {
		assertEquals(0, testShipObject.getBowColumn());
	}

	@Test
	void testSetBowColumn() {
		testShipObject.setBowColumn(3);
		assertEquals(3, testShipObject.getBowColumn());
	}

	@Test
	void testGetLength() {
		assertEquals(4, testShipObject.getLength());
	}

	@Test
	void testIsHorizontal() {
		assertFalse(testShipObject.isHorizontal());
	}

	@Test
	void testSetHorizontal() {
		testShipObject.setHorizontal(true);
		assertTrue(testShipObject.isHorizontal());
	}

	@Test
	void testGetHit() {
		boolean[] array = new boolean[4];
		assertArrayEquals(array, testShipObject.getHit());
	}

	@Test
	void testGetShipType() {
		assertEquals("battleship", testShipObject.getShipType());
	}

	@Test
	void testOkToPlaceShipAt() {
		Ocean ocean1 = new Ocean();
		assertFalse(testShipObject.okToPlaceShipAt(0, 2, true, ocean1));
		assertFalse(testShipObject.okToPlaceShipAt(2, 2, false, ocean1));
		
		
		testShipObject.placeShipAt(0, 3, true, ocean1);
		assertFalse(testShipObject2.okToPlaceShipAt(0, 6, true, ocean1));
		
	}

	@Test
	void testPlaceShipAt() {
		Ocean ocean2 = new Ocean();
		testShipObject.placeShipAt(0, 3, true, ocean2);
		assertEquals(0, testShipObject.getBowRow());
		assertEquals(3, testShipObject.getBowColumn());
		assertTrue(testShipObject.isHorizontal());
		
		assertEquals(testShipObject,ocean2.getShipArray()[0][3]);
	}

	@Test
	void testShootAt() {
		Ocean ocean3 = new Ocean();
		testShipObject.placeShipAt(0, 4, true, ocean3);
		assertTrue(testShipObject.shootAt(0,3));
		
		EmptySea empty = new EmptySea();
		empty.okToPlaceShipAt(0, 5, true, ocean3);
		assertFalse(empty.shootAt(0,5));
		
	}

	@Test
	void testIsSunk() {
		assertFalse(testShipObject.isSunk());
	}

	@Test
	void testToString() {
		EmptySea emptySea = new EmptySea(); 
		assertEquals("-", emptySea.toString());
		
		assertEquals("x", testShipObject.toString());
	}

}
