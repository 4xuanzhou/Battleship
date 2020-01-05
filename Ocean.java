package battleship;

import java.util.Random;

public class Ocean {

	/**
	 * Used to quickly determine which ship is in any given location
	 */
	private Ship[][] ships = new Ship[10][10];

	/**
	 * The total number of shots fired by the user
	 */
	private int shotsFired;

	/**
	 * The number of times a shot hit a ship. If the user shoots the same part of a
	 * ship more than once, every hit is counted, even though additional “hits”
	 */
	private int hitCount;

	/**
	 * The number of ships sunk (10 ships in all
	 */
	private int shipsSunk;

	/**
	 * Creates an ”empty” ocean (and fills the ships array with EmptySea objects)
	 * Also initializes any game variables
	 */
	public Ocean() {

		for (int i = 0; i < this.ships.length; i++) {
			for (int j = 0; j < this.ships[i].length; j++) {
				this.ships[i][j] = new EmptySea();
			}
		}

		this.shotsFired = 0;
		this.hitCount = 0;
		this.shipsSunk = 0;
	}

	/**
	 * Place all ten ships randomly on the (initially empty) ocean.
	 */
	void placeAllShipsRandomly() {

		Random random = new Random();
		int row;
		int column;
		boolean horizontal;

		row = random.nextInt(10);
		column = random.nextInt(10);
		int i = random.nextInt(2);
		if (i == 0) {
			horizontal = false;
		} else {
			horizontal = true;
		}

		Ship battleship = new Battleship();

		while (!battleship.okToPlaceShipAt(row, column, horizontal, this)) {
			row = random.nextInt(10);
			column = random.nextInt(10);
			int a = random.nextInt(2);
			if (a == 0) {
				horizontal = false;
			} else {
				horizontal = true;
			}
		}
		battleship.placeShipAt(row, column, horizontal, this);

		for (int nc1 = 0; nc1 < 2; nc1++) {
			Ship cruiser = new Cruiser();

			while (!cruiser.okToPlaceShipAt(row, column, horizontal, this)) {
				row = random.nextInt(10);
				column = random.nextInt(10);
				int b = random.nextInt(2);
				if (b == 0) {
					horizontal = false;
				} else {
					horizontal = true;
				}
			}
			cruiser.placeShipAt(row, column, horizontal, this);

		}

		for (int nd1 = 0; nd1 < 3; nd1++) {
			Ship destroyer = new Destroyer();

			while (!destroyer.okToPlaceShipAt(row, column, horizontal, this)) {
				row = random.nextInt(10);
				column = random.nextInt(10);
				int c = random.nextInt(2);
				if (c == 0) {
					horizontal = false;
				} else {
					horizontal = true;
				}
			}
			destroyer.placeShipAt(row, column, horizontal, this);
		}

		for (int ns1 = 0; ns1 < 4; ns1++) {
			Ship submarine = new Submarine();

			while (!submarine.okToPlaceShipAt(row, column, horizontal, this)) {
				row = random.nextInt(10);
				column = random.nextInt(10);
				int d = random.nextInt(2);
				if (d == 0) {
					horizontal = false;
				} else {
					horizontal = true;
				}
			}
			submarine.placeShipAt(row, column, horizontal, this);
		}
	}

	/**
	 * Returns true if the given location contains a ship, false if it does not
	 * @return whether the given location contains a ship or not
	 */
	boolean isOccupied(int row, int column) {

		if (this.ships[row][column].getShipType() == "empty") {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Returns true if the given location contains a ”real” ship, still afloat, (not
	 * an EmptySea), false if it does not. In addition, this method updates the
	 * number of shots that have been fired, and the number of hits
	 * 
	 * @param row the row the user shot
	 * @param column the column the user shot
	 * @return whether shot at the given location is hit or miss
	 */
	boolean shootAt(int row, int column) {

		this.shotsFired += 1;
		if (this.ships[row][column].getShipType() != "empty" && this.ships[row][column].isSunk() == false) {
			this.hitCount += 1;
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Returns the number of shots fired (in the game)
	 */
	int getShotsFired() {
		return this.shotsFired;
	}

	/**
	 * Returns the number of hits recorded (in the game).
	 */
	int getHitCount() {
		return this.hitCount;
	}

	/**
	 * Returns the number of ships sunk (in the game)
	 */
	int getShipSunk() {
		return this.shipsSunk;
	}

	/**
	 * Returns true if all ships have been sunk, otherwise false
	 */
	boolean isGameOver() {
		if (this.shipsSunk == 10) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the 10x10 array of Ships.
	 */
	Ship[][] getShipArray() {
		return this.ships;
	}

	/**
	 * Prints the Ocean. Use ‘x’ to indicate a location that you have fired upon and
	 * hit a (real) ship Use ‘-’ to indicate a location that you have fired upon and
	 * found nothing there Use ‘s’ to indicate a location containing a sunken ship
	 * use ‘.’ (a period) to indicate a location that you have never fired upon
	 */
	void print() {
	System.out.print("   ");
	for(int i = 0; i<10; i++){
		System.out.print(i + "  ");
	}
	System.out.print("\n");

	for(int i = 0; i<10; i++){
		System.out.print(i + "  ");
		for (int j = 0; j < 10; j++) {
			if (this.getShipArray()[i][j].isSunk() || this.shootAt(i, j)) {
				System.out.print(this.ships[i][j] + "  ");
			} else {
				System.out.print(".  ");
			}
		}
		System.out.print("\n");
	}
	}



	/**
	 * print a message telling the user of the shot is hit or miss
	 * @param row the row the user shot
	 * @param column the column the user shot
	 */
	public void printHitOrMiss(int row, int column) {
		if (this.ships[row][column].shootAt(row, column)) {
			System.out.println("hit");
		} else {
			System.out.println("miss");
		}
	}

	/**
	 * print a message telling the user a ship has been sunk
	 * @param ship a part of ship in the ocean
	 */
	void tellShipSunk(Ship ship) {
		if (ship.isSunk()) {
			this.shipsSunk += 1;
			System.out.println("You just sank a ship - (" + ship.getShipType() + ").");
			System.out.println();
		}
	}

}