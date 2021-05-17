package edu.unca.csci202;

public class Minesweeper {
	
	/**
	 * Main method for minesweeper game. a new gameboard is created and the game is run.
	 * @param args
	 */
	public static void main(String[] args) {
		// makes an instance of a gameboard and runs it.
		
		Gameboard gm = new Gameboard();
		
		gm.run();

	}

}
