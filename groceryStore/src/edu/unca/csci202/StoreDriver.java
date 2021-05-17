package edu.unca.csci202;

/**
 * This store driver class contains a lovely main method to run the grocery store simulations.
 * 
 * @author cblah
 *@version 1.0
 */
public class StoreDriver {

	/**
	 * This is the main method for the grocery store simulation.
	 * It runs a few different scenarios of the grocery store class.
	 * One instance includes some pretty harsh punishment to a single cashier.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GroceryStore g1 = new GroceryStore(3);
		g1.run(123, 0.7d, 2, 10);
		g1.printData();
		
		GroceryStore g2 = new GroceryStore(2);
		g2.run(700, 0.3d, 1, 1);
		g2.printData();
		
		GroceryStore g3 = new GroceryStore(1);
		g3.run(1000000, 1d, 1, 100);
		g3.printData();
		
		GroceryStore g4 = new GroceryStore(10);
		g4.run(1000000, 0.05d, 3, 90);
		g4.printData();

	}

}
