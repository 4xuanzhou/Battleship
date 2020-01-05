package battleship;

public class Destroyer extends Ship {

	/**
	 * set the length variable to 2
	 */
	public Destroyer() {
		super(2);
	}

	/**
	 * Returns string “destroyer”
	 */
	@Override
	public String getShipType() {
		return "destroyer";
	}
}
