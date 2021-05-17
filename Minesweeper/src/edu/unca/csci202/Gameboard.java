package edu.unca.csci202;

import java.util.Random;
import java.util.Scanner;


/**
 * Gameboard for Minesweeper. this class creates an 8x8 grid of cells. Then the first ten cells are set with mines.
 * the board is then shuffled.
 * The class then prompts the user for a peek, then prompts the user to guess on a cell. A wrong guess ends the game.
 * @author cblah
 *
 */

public class Gameboard {
	
	
	
	private char mine = 'M';
	private char checked = '-';
	private char zero = '0';
	private final int gb_size = 8;
	private int mines = 10;
	private Cell[][] cell;
	private Random rand = new Random();
	private Scanner scan = new Scanner(System.in);
	private int row, x;
	private int col, y;
	private int mine_guess;
	private int playAgain;
	private Cell temp;
	private boolean correct = true;
	private boolean playItAgain = true;
	private boolean down, right;
	private int turnCount = 0;
	private LinkedStack<Integer> stack;
	
	/**
	 * Constructor creates a new instance of a 2d array of cells, then places mines on the board.
	 */
	public Gameboard() {
		this.cell = new Cell[gb_size][gb_size];
		generateBoard(this.cell);
	}
	
	

	/**
	 * While the player wants to keep playing, this method prints out the board and lets the player
	 * guess until either player gets it wrong, or the board is filled.
	 */
	public void run() {
		while(this.playItAgain) {
			
			printBoard();
			
			while(this.correct) {
				
				guess();
			}
			
			if(this.turnCount == 64) {
				System.out.println("You win!!");
			}else {
				System.out.println("You lose");
			}
		
			this.playAgain = readNumberFromUser("Play again 1(Y) 2(N)");
			if(this.playAgain == 2) {
				this.playItAgain = false;
			}else if(this.playAgain == 1) {
				this.playItAgain = true;
				this.correct = true;
				this.turnCount = 0;
				this.mines = 10;
				this.cell = new Cell[this.gb_size][this.gb_size];
				generateBoard(this.cell);
			}else {
				System.out.println("Please enter either 1 or 2");
			}
				
		}
	}
	
	/**
	 * This method prints out the board in its current state.
	 */
	private void printBoard(){
		//prints out the board of cells at their current state
		for(int i = 0; i< cell.length; i++) {
			for(int j = 0; j<cell[i].length; j++) {
				cell[i][j].printState();
			}
			System.out.println();
		}
		
	}
	/**
	 * This method takes a 2d array of cells and sets mines on the first ten cells of the board.
	 * the board is then shuffles, and the remaining cells are checked to see how many mines are adjacent to each cell.
	 * @param cell
	 */
	private void generateBoard(Cell[][] cell) {
		//generates a board full of cells and sets mines on the first ten spots on the board, shuffles them and then checks the adjacent cells.
		for(int i = 0; i< this.cell.length; i++) {
			for(int j = 0; j < this.cell[i].length; j++) {
				this.cell[i][j] = new Cell();
				if(mines > 0) {
					this.cell[i][j].setMine();
					this.mines--;
				}
			}
		}
		
		shuffle();
		
		for(int i = 0; i< this.cell.length; i++) {
			for(int j = 0; j < this.cell[i].length; j++) {
				this.cell[i][j].checkAdj(this.cell, i, j);
				this.cell[i][j].setAdjCount(this.cell[i][j].checkAdj(this.cell, i, j));
			}
		}
		
	}
	
	
	/**
	 * This method shuffles the board so the mines placed in the first ten cells are randomly placed on the board without replacement.
	 * This guarantees that ten mines will be placed on the board and the game won't accidently place a mine in the same cell twice.
	 */
	private void shuffle() {
		//taken from a card class in another file that i have. this method shuffles the mines so they can be placed randomly without the possibility of the random class repeating placements
		for(int i = 0; i < this.cell.length; i++) {
			for(int j = 0; j<this.cell[i].length; j++) {
				this.row = rand.nextInt(this.cell.length);
				this.col = rand.nextInt(this.cell[this.row].length);
				this.temp = this.cell[this.row][this.col];
				this.cell[this.row][this.col] = this.cell[i][j];
				this.cell[i][j]=this.temp;
			}
		}
	}
	
	
	/**
	 * Functionality for making a guess. This method prompts the user for a peek. 
	 * Then asks the player to pick a row and column and state if it is a mine or not. 
	 * The answer is checked against the state of the cell and returns true if the guess is correct and false if not.
	 * @return true if the player guessed correctly and false if not.
	 */
	private boolean guess() {
		int ret_val = 2;
		this.row = 0;
		this.col = 0;
		do {
			
			ret_val = readNumberFromUser("would you like a peek 1(Y) or 2(N)");
			
			if(ret_val == 1) {
				peek();//toggles peek on
				printBoard();
				peek();//toggles peek off
				
			}else if(ret_val == 2){
				
			}else {
				System.out.println("please enter 1(Y) or 2(N)");
				
			}
			this.row = readNumberFromUser("enter a row number from 0-7: ");
			this.col = readNumberFromUser("enter a column number from 0-7: ");
			if(this.row >=8 || this.col >= 8) {
				//number entered is outside the board.
				System.out.println("Please enter a number less than 8");
			}else if(Character.compare(this.cell[this.row][this.col].getState(),checked)!= 0){
				//square was already played
				System.out.println("You already checked that spot. try another one");
			}else {
				//square is good to play
				this.mine_guess = readNumberFromUser("You think that is a mine? 1(Y) 2(N)");
				if(this.mine_guess == 1) {
					this.correct = this.cell[row][col].checkAnswer(this.mine);
					printBoard();
					this.turnCount++;
				}else if(this.mine_guess == 2) {
					this.correct = !(this.cell[row][col].checkAnswer(this.mine));
					if(Character.compare(this.cell[row][col].getState(), this.zero)==0) {
						
						expand(this.cell,row,col);
						playStack();
						printBoard();
					}else {
						
						
						printBoard();
						this.turnCount++;
					}
				}else {
					System.out.println("Please enter either 1 or 2");
				}
			}
			
		}while(row > 8 && col > 8);
		
		
		if(this.turnCount==64) {
			this.correct = false;
		}
		
		return this.correct;
	}
	
	
	/**
	 * Allows peeking for the board. this method check each cell. if it is a mine, then set state to visible.
	 */
	private void peek() {
		//toggles the peek of each cell to see if it is a mine. if it is not,toggle the peek back so the board only shows mines
		for(int i = 0; i < this.cell.length; i++) {
			for(int j = 0; j < this.cell[i].length; j++) {
				
				if(cell[i][j].checkMine()) {
					cell[i][j].togglePeek();
				}
			}
		}
		
	}
	
	/**
	 * Reads an input from the user and returns the appropriate number.
	 * @param prompt
	 * @return an appropriate number for a method to use.
	 * 
	 */
	
	public  int readNumberFromUser(String prompt) {
		//taken from lab2
		
		while(true) {
			try {
				System.out.print(prompt);
				String input = scan.nextLine();
				int ret_val = Integer.parseInt(input);
				return ret_val;
			}catch(NumberFormatException e) {
				System.out.println("Please enter an integer");
			}
		}
		
		
	}
	/**
	 * This method creates a stack of adjacent cells that contain '0' characters as their state when a non-mine guess is made.
	 * 
	 * @param cell
	 * @param row
	 * @param col
	 */
	public void expand(Cell[][] cell, int row, int col) {
		//TODO works mostly, but there are a few corner cases that it is missing.
		this.stack = new LinkedStack<Integer>();
		this.x = row;
		this.down = true;
		this.right = true;
		while(this.x!=-1) {
			this.y = col;
			while(this.y!=-1) {
				stack.push(this.x);
				stack.push(this.y);
				if(this.right) {
					if(this.y == this.gb_size-1) {
						this.right = false;
					}else if(Character.compare(cell[x][y].getAdjCount(), this.zero)>0) {
						this.right=false;
					}
				}else {
					if(this.y == 0) {
						this.y=-2;
						this.right = true;
					}else if(Character.compare(cell[x][y].getAdjCount(), this.zero)>0) {
						this.right=true;
						this.y=-2;
					}
				}
				if(this.right) {
					this.y++;
				}else {
					this.y--;
				}
			}
			this.y=col;
			if(this.down) {
				if(this.x == this.gb_size-1) {
					this.down = false;
				}else if(Character.compare(cell[x][y].getAdjCount(), this.zero)>0) {
					this.down=false;
				}
			}else {
				if(this.x == 0) {
					this.x=-2;
					this.down = true;
				}else if(Character.compare(cell[x][y].getAdjCount(), this.zero)>0) {
					this.down=true;
					this.x=-2;
				}
			}
			if(this.down) {
				this.x++;
			}else {
				this.x--;
			}
		}
				
		
	}
	
	public void playStack() {
		while (!this.stack.isEmpty()) {
			this.y = this.stack.pop();
			this.x = this.stack.pop();
			this.correct = !(this.cell[this.x][this.y].checkAnswer(this.mine));
			this.turnCount++;
		}
		this.turnCount--;
	}
	
	

}
