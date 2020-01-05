package battleship;

public class EmptySea extends Ship {
	/**
	 * sets the length variable to 1 
	 */
	public EmptySea() {
		super(1);
	}

	/**
	 * overrides shootAt(int row, int column) that is inherited from Ship, 
	 * and always returns false to indicate that nothing was hit
	 */
	@Override
	boolean shootAt(int row, int column) {
		return false;
	}
	
	/**
	 * This method overrides isSunk() that is inherited from Ship, and always 
	 * returns false to indicate that you didn’t sink anything
	 */
	@Override
	boolean isSunk() {
		//System.out.print(this);
		return false;
	}
	
	/**
	 * Returns the single-character“-“String to use in the Ocean’s print method
	 */
	@Override
	public String toString() {
		return "-";
	}
	
	/**
	 * returns the string “empty”
	 */
	@Override
	public String getShipType() {
		return "empty";
	}
	
	
	
}
