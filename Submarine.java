package battleship;

public class Submarine extends Ship {

	/**
	 * set the length variable to 1
	 */
	public Submarine() {
		super(1);
	}

	/**
	 * Returns string “submarine”
	 */
	@Override
	public String getShipType() {
		return "submarine";
	}
}
