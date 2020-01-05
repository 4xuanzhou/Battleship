package battleship;

/**
 * set the length variable to 3
 */
public class Cruiser extends Ship {

	public Cruiser() {
		super(3);
	}
	
	/**
	 * Returns string “cruiser”
	 */
	@Override
	public String getShipType() {
		return "cruiser";
	}
}
