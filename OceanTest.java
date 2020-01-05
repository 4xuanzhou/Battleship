package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OceanTest {
	Ocean testOceanObject;
	@BeforeEach
	void setUp() throws Exception {
		testOceanObject = new Ocean();
	}

	@Test
	void testOcean() {
		assertEquals(0, testOceanObject.getShotsFired());
		assertEquals(0, testOceanObject.getHitCount());
		assertEquals(0, testOceanObject.getShipSunk());
		
		testOceanObject.getShipArray()[0][0] = new EmptySea();
		assertEquals(1, testOceanObject.getShipArray()[0][0].getLength());
	}

	@Test
	void testIsOccupied() {
		assertFalse(testOceanObject.isOccupied(1, 1));
	}

	@Test
	void testShootAt() {
		testOceanObject.shootAt(1, 1);
		assertEquals(1, testOceanObject.getShotsFired());
		assertFalse(testOceanObject.shootAt(1, 1));
	}

	@Test
	void testGetShotsFired() {
		assertEquals(0, testOceanObject.getShotsFired());
		testOceanObject.shootAt(1, 1);
		assertEquals(1, testOceanObject.getShotsFired());
	}

	@Test
	void testGetHitCount() {
		assertEquals(0, testOceanObject.getHitCount());
		testOceanObject.shootAt(1, 1);
		assertEquals(0, testOceanObject.getHitCount());
	}

	@Test
	void testGetShipSunk() {
		assertEquals(0, testOceanObject.getShipSunk());
	}

	@Test
	void testIsGameOver() {
		assertFalse(testOceanObject.isGameOver());
	}

	@Test
	void testGetShipArray() {
		testOceanObject.getShipArray()[0][0] = new EmptySea();
		assertEquals(1, testOceanObject.getShipArray()[0][0].getLength());
	}

}
