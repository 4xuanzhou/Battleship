package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BattleshipTest {
	Battleship testBattleshipObject;
	@BeforeEach
	void setUp() throws Exception {
		testBattleshipObject = new Battleship();
	}

	@Test
	void testGetShipType() {
		assertEquals("battleship", testBattleshipObject.getShipType());
	}

	@Test
	void testBattleship() {
		assertEquals(4, testBattleshipObject.getLength());
	}

}
