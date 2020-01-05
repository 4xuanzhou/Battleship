package battleship;

public abstract class Ship {
	
	/**
	 * row that contains the bow (front part of the ship)
	 */
	private int bowRow;
	
	/**
	 * column that contains the bow (front part of the ship) 
	 */
	private int bowColumn;
	
	/**
	 * length of the ship
	 */
	private int length;
	
	/**
	 * represents whether ship is going to be placed horizontally or vertically 
	 */
	private boolean horizontal;
	
	/**
	 * array of 4 booleans that indicate whether that part of the ship has been hit or not
	 */
	private boolean[] hit;
	
	/**
	 * sets the length property of the particular ship and initializes the hit array
	 * @param length of ship 
	 */
	public Ship(int length) {
		this.length = length;
		this.hit = new boolean[4];
	}
	
	/**
	 * Returns the row corresponding to the position of the bow
	 * @return row of bow
	 */
	public int getBowRow() {
		return bowRow;
	}

	/**
	 * Sets the value of bowRow
	 * @param bowRow row of bow
	 */
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}

	/**
	 * Returns the bow column location
	 * @return column of bow
	 */
	public int getBowColumn() {
		return bowColumn;
	}

	/**
	 * Sets the value of bowColumn
	 * @param bowColumn column of bow
	 */
	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}

	/**
	 * Returns the ship length
	 * @return length of ship
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Returns whether the ship is horizontal or not
	 * @return whether the ship is horizontal or not
	 */
	public boolean isHorizontal() {
		return horizontal;
	}

	/**
	 * Sets the value of the instance variable horizontal
	 * @param horizontal whether the ship will be horizontal or not
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	
	
	/**
	 * Returns the hit array
	 * @return the hit array
	 */
	public boolean[] getHit() {
		return hit;
	}
	
	/**
	 * Returns the type of ship as a String
	 */
	public abstract String getShipType();
	
	/**
	 * Based on the given row, column, and orientation, returns true if it is okay 
	 * to put a ship of this length with its bow in this location; false otherwise.
	 * @param row randomly generated row of bow
	 * @param column randomly generated column of bow
	 * @param horizontal randomly generated orientation of bow
	 * @param ocean the ocean to place ship in
	 * @return if it is okay to put a ship of this length with its bow in this location
	 */
	boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		int shipLength = this.getLength();
		//Ship[][] shipArray = ocean.getShipArray();
		
		if (horizontal) {
			int stern = column - (shipLength - 1);
			if (stern < 0) {
				return false;
			} 
			
			//check all around ship for other adjacent ships
			for (int i = column; i >= stern; i--) {
				
				//check if there is another ship in that column
				if (ocean.isOccupied(row, i)) {
					return false;
				}
				
				//if it's the bow
				if (i == column) {
					
					//adjacent right
					if ((column + 1) <= 9) {
						if (ocean.isOccupied(row, i+1)) {
							return false;
						}
					}
					
					//top
					if((row - 1) >= 0) {
						
						//adjacent top-right
						if ((i + 1) <= 9){
							if (ocean.isOccupied(row-1, i+1)) {
								return false;
							}
						}
						
						//adjacent top
						if (ocean.isOccupied(row-1, i)) {
							return false;
						}
					}
					
					//bottom
					if((row + 1) <= 9) {
						
						//adjacent bottom-right
						if ((i + 1) <= 9){
							if (ocean.isOccupied(row+1, i+1)) {
								return false;
							}
						}
						
						//adjacent bottom
						if (ocean.isOccupied(row+1, i)) {
							return false;
						}
					}	
				}
				
				//if it's the stern
				if (i == stern) {
					
					//adjacent left
					if ((i-1 >= 0)) {
						if (ocean.isOccupied(row, i-1)) {
							return false;
						}
					}
					
					//top
					if ((row -1 >= 0)) {
						
						//adjacent top-left
						if ((i - 1) >= 0) {
							if (ocean.isOccupied(row-1, i-1)) {
								return false;
							}
						}
						
						//adjacent top
						if (ocean.isOccupied(row-1, i)) {
							return false;
						}
					}
					
					//bottom
					if ((row + 1) <= 9) {
						
						//adjacent bottom-left
						if ((i-1) >= 0) {
							if (ocean.isOccupied(row+1, i-1)) {
								return false;
							}
						}
						
						//adjacent bottom
						if (ocean.isOccupied(row+1, i)) {
							return false;
						}
					}
				}
				
				//every other location
				if ((i<column)&& (i > stern)) {
					
					//adjacent top
					if ((row - 1)>=0) {
						if (ocean.isOccupied(row-1, i)) {
							return false;
						}
					}
					
					//adjacent bottom
					if ((row + 1) <= 9) {
						if (ocean.isOccupied(row+1, i)) {
							return false;
						}
					}
				}
			}
		} else if (!horizontal) {
			
			int stern = row - (shipLength - 1);
			if (stern <0) {
				return false;
			}
			
			//check all around ship for other adjacent ships
			for (int i = row; i >= stern; i--) {
				
				//check if there is another ship in that location
				if (ocean.isOccupied(i, column)) {
					return false;
				}
				
				//if it's the bow
				if (i == row) {
					
					//adjacent bottom
					if ((i+1 <= 9)) {
						if (ocean.isOccupied(i+1, column)) {
							return false;
						}
					}
					
					//left
					if ((column - 1) >= 0) {
						
						//adjacent bottom-left
						if ((i+1) <= 9) {
							if (ocean.isOccupied(i+1, column-1)) {
								return false;
							}
						}
						
						//adjacent left
						if (ocean.isOccupied(i, column-1)) {
							return false;
						}
					}
					
					//right
					if ((column + 1) <= 9) {
						
						//adjacent bottom-right
						if ((i+1) <= 9) {
							if (ocean.isOccupied(i+1, column+1)) {
								return false;
							}
						}
						
						//adjacent right
						if (ocean.isOccupied(i, column+1)) {
							return false;
						}
					
					}						
					
				}
				
				//if it's the stern
				if (i == stern) {
					
					//adjacent top
					if ((i-1 >= 0)) {
						if (ocean.isOccupied(i-1, column)) {
							return false;
						}
					}
					
					//left
					if ((column - 1) >= 0) {
						
						//adjacent top-left
						if ((i-1) >= 0) {
							if (ocean.isOccupied(i-1, column-1)) {
								return false;
							}
						}
						
						//adjacent left
						if (ocean.isOccupied(i, column-1)) {
							return false;
						}
					}
					
					//right
					if ((column + 1) <= 9) {
						
						//adjacent top-right
						if ((i-1) >= 0) {
							if (ocean.isOccupied(i-1, column+1)) {
								return false;
							}
						}
						
						//adjacent right
						if (ocean.isOccupied(i, column+1)) {
							return false;
						}				
					}			
				}
				
				//every other location
				if ((i<row)&& (i > stern)) {
					
					//adjacent left
					if ((column - 1)>=0) {
						if (ocean.isOccupied(i, column-1)) {
							return false;
						}
					}
					
					//adjacent right
					if ((column + 1) <= 9) {
						if (ocean.isOccupied(i, column+1)) {
							return false;
						}
					}
				}
			}
		} 
		return true;
	}

	
	
	/**
	 * “Puts” the ship in the ocean. Involves giving values to the bowRow, 
	 * bowColumn, and horizontal instance variables in the ship, and it also 
	 * involves putting a reference to the ship in each of 1 or more locations 
	 * (up to 4) in the ships array in the Ocean object
	 * @param row given row of bow
	 * @param column given column of bow
	 * @param horizontal given orientation of ship
	 * @param ocean the ocean to place ship in
	 */
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		this.setBowRow(row);
		this.setBowColumn(column);
		this.setHorizontal(horizontal);
		
		
		int shipLength = this.getLength();
		if (this.isHorizontal()) {
			int stern = column - (shipLength - 1);
			for (int i = column; i >= stern; i--) {
				ocean.getShipArray()[row][i] = this;
			} 
		}
		else {
				int stern = row - (shipLength - 1);
				for (int i = row; i >= stern; i--) {
					ocean.getShipArray()[i][column] = this;
				}
			}
		}
		

	/**
	 * If a part of the ship occupies the given row and column, and the ship hasn’t
	 * been sunk, mark that part of the ship as “hit” and return true; otherwise return false 
	 * @param row given row to shoot at
	 * @param column given column to shoot at
	 * @return if a part of ship is hit
	 */
	boolean shootAt(int row, int column) {
		
		if (this.getShipType() != "empty" && this.isSunk() == false) {
			if (this.isHorizontal()) {
				this.hit[this.bowColumn - column] = true;
				} else {
				this.hit[this.bowRow - row] = true;
			}		
			return true;
		} else {
			return false;
		}
}
	
	/**
	 * Return true if every part of the ship has been hit, false otherwise
	 * @return whether every part of the ship has been hit
	 */
	boolean isSunk(){
		
		for(int i = 0; i < this.length; i++) if (!this.hit[i]) return false;
		return true;
	}
	
	/**
	 * Returns a single-character String to use in the Ocean’s print method.
	 * @return ”s” if the ship has been sunk and ”x” if it has not been sunk
	 */
	@Override
	public String toString() {
		if (this.isSunk()) {
			return "s";
		} else {
			return "x";
		}
	}
}
