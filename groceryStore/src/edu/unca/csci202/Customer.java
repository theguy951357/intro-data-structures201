package edu.unca.csci202;

import java.util.Random;

/**
 * Customer class containing the number of groceries 
 * and the time it takes for the transaction to finish.
 * 
 * @author cblah
 *@version 1.0
 */

public class Customer {
	
	
	private int numGroceries;
	private int transactionTime;
	/**
	 * constructor will instantiate the number of groceries and the transaction time.
	 * 
	 * @param numGroceries
	 * @param transactionTime
	 */
	public Customer(int numGroceries, int transactionTime) {
		this.numGroceries = numGroceries;
		this.transactionTime = numGroceries*transactionTime;
	}
	/**
	 * A getter for the number of groceries.
	 * @return the numGroceries
	 */
	public int getNumGroceries() {
		return numGroceries;
	}
	/**
	 * A getter for the transaction time.
	 * @return the transactionTime
	 */
	public int getTransactionTime() {
		return transactionTime;
	}
	
	/**
	 * A method for decrementing the transaction time.
	 */
	public void decrementTime() {
		this.transactionTime--;
	}
	
	
	
	

}
