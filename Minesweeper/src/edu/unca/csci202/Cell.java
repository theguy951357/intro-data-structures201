package edu.unca.csci202;

/**
 * Cell class handles if the square on the gameboard is a mine or not and
 * if not, finds out if there are any adjacent mines.
 * @author cblah
 *
 */
public class Cell {
	
	private boolean isMine = false;
	private boolean isGuessed = false;
	private boolean hidden = true;
	private char adjCount = '0';
	
	private char state;
	/**
	 * Constructor sets the cell to hidden as a default.
	 */
	public Cell() {
		// TODO Auto-generated constructor stub
		
			setState(true);
	}
	
	/**
	 * Toggles the state between hidden and not hidden.
	 */
	public void togglePeek() {
		this.hidden = !this.hidden;
		setState(this.hidden);
	}
	
	/**
	 * Sets a mine in the cell
	 */
	public void setMine() {
		this.isMine = true;
		
	}
	
	
	/**
	 * This checks if the user input matches the cell.
	 * @param userInput
	 * @return true if user input matches and false if not.
	 */
	public boolean checkAnswer(char userInput) {
	
		this.setState(false);
		
		
		this.isGuessed = true;
		if(Character.compare(this.state, userInput)==0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * This gets the current state of the cell.
	 * @return the current state of the cell.
	 */
	public char getState() {
		return this.state;
	}
	
	/**
	 * Sets the state to either hidden or not hidden.
	 * if it is hidden, the state is "-".
	 * if not hidden, it will check if it is a mine "M", or adjacent to a mine.
	 * @param hidden
	 */
	public void setState(boolean hidden) {
		
		this.hidden = hidden;
		if (hidden && !this.isGuessed) {
			this.state = '-';
			
		}else if(this.isMine) {
				this.state = 'M';
			}else {
				this.state = adjCount;
			}
		
	}
	/**
	 * getter for the adjacent count.
	 * @return char representing the number of adjacent mines to the current cell.
	 */
	public char getAdjCount() {
		
		return adjCount;
	}
	

	/**
	 * setter for the adjacent count. this takes in an integer and sets the adjacent count as a character data type.
	 * @param adjCount
	 */
	public void setAdjCount(int adjCount) {
		
		this.adjCount = Character.forDigit(adjCount, 10);
	}

	
	/**
	 * Prints the state of the cell.
	 */
	public void printState() {
		System.out.print(" " +this.state);
	}
	
	/**
	 * This will take a 2d cell array and a will check all adjacent cells for the 
	 * given row and column. if there is a mine, the count is incremented for that cell.
	 * @param cell
	 * @param row
	 * @param col
	 * @return number of adjacent mines to the current cell
	 */
	public int checkAdj(Cell[][] cell, int row, int col) {
		//checks all adjacent cells for mines
		int num = 0;
		//if the cell is not a mine, check all adjacent cells for mines and return the number.
		if(!cell[row][col].isMine) {
			if((col + 1)< cell[col].length && cell[row][col+1].isMine ) {
				//left
				//this.adjCount++;
				num++;
			}
			if((row+1) < cell.length && (col + 1)< cell[col].length && cell[row+1][col+1].isMine ) {
				//left down
				//this.adjCount++;
				num++;
			}
			if(row > 0 && (col + 1)< cell[col].length && cell[row-1][col+1].isMine ) {
				//left up
				//this.adjCount++;
				num++;
			}
			if(col > 0 && cell[row][col-1].isMine ) {
				//right
				//this.adjCount++;
				num++;
			}
			if((row+1) < cell.length && col > 0 && cell[row+1][col-1].isMine ) {
				//right down
				//this.adjCount++;
				num++;
			}
			if(row > 0 && col > 0 && cell[row-1][col-1].isMine ) {
				//right up
				//this.adjCount++;
				num++;
			}
			if(row > 0 && cell[row -1][col].isMine ) {
				//up
				//this.adjCount++;
				num++;
			}
			if((row+1) < cell.length && cell[row +1][col].isMine ) {
				//down
				//this.adjCount++;
				num++;
			}
			
			
	
		
		}
		
		return num;
	}

	/**
	 * Checks to see if cell contains a mine
	 * @return true if cell contains a mine, and false if not
	 */
	public boolean checkMine() {
		
		return isMine;
	}
}
