package battleship;

public class Battleship extends Ship {
	
	/**
	 * set the length variable to 4
	 */
	public Battleship() {
		super(4);
	}

	/**
	 * Returns string “battleship”
	 */
	@Override
	public String getShipType() {
		return "battleship";
	}

}