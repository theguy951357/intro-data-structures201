package edu.unca.csci202;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//BE SURE TO CHANGE THIS TO 'true' before you submit
		boolean production = true;
		
		if(production) {
			productionTests();
		}else {
			interactiveTest();
		}
	}
	
	private static void productionTests() {
		System.out.println("Running performanceTest() tests.");
		for(int num_items : new int[]{1000,10000} ) {
			for(int num_ops : new int[]{10000,100000} ) {
				for(int type : new int[]{1,2,3} ) {
					performanceTest(type, num_ops, num_items);
				}
			}
		}
		System.out.println("Running priceRangeSearch() tests.");
		for(int type : new int[]{1,2,3} ) {
			priceTest(type);
		}

	}

	public static void interactiveTest() {
		Scanner scan = new Scanner(System.in);	
		
		int type = getNumberFromUser(scan,
				"Search Method: (1) iterative, (2) recursive, (3) binary");
		int num_ops= getNumberFromUser(scan,
				"How many test operations: ");
		int num_items= getNumberFromUser(scan,
				"How many warehouse items: ");
		
		performanceTest(type, num_ops, num_items);
		priceTest(type);
	}
	

	private static Warehouse<Widget> createWarehouse(int type){
		Warehouse<Widget> widgetBarn;
		if(type==1) {
			System.out.print("IterativeSearch ");
			widgetBarn = new IterativeSearchWarehouse<Widget>();
		}else if(type==2) {
			System.out.print("RecursiveSearch ");
			widgetBarn = new RecursiveSearchWarehouse<Widget>();
		}else if(type==3) {
			System.out.print("BinarySearch    ");
			widgetBarn = new BinarySearchWarehouse<Widget>();
		}else {
			throw new RuntimeException("Unknown search method");
		}
		return widgetBarn;
	}
	
	private static void performanceTest(int type, int num_ops, int num_items) {
		
		Warehouse<Widget> widgetBarn = createWarehouse(type);

		System.out.print(num_items+" items ");
		WidgetFactory widgetFarm = new WidgetFactory();
		Iterator<InventoryItem> i = widgetFarm.createItems(num_items);
		while(i.hasNext()){
			widgetBarn.addItem(i.next());
		}
		
		System.out.print(num_ops+" operations: ");
		long tic = System.currentTimeMillis();
		runTest(widgetBarn, num_ops, num_items);
		System.out.println( ((System.currentTimeMillis()-tic)/1000.0)+" seconds.");

	}
	
	private static int getNumberFromUser(Scanner scan, String prompt) {
		while(true) {
			try {
				System.out.print(prompt);
				return Integer.parseInt(scan.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Could not parse number");
			}
		}
	}
	
	private static void runTest(Warehouse<Widget> db, int num_ops, int num_items) {
		Random rnd = new Random();
		for(int i=0; i<num_ops; i++) {
			int sku = rnd.nextInt(num_items);  // find random item
			double price = 100.0 * rnd.nextDouble();
			int quantity = rnd.nextInt(1000);
			db.updateItemPrice(sku, price);
			db.updateItemQuantity(sku, quantity);
		}
	}
	
	private static void priceTest(int type) {
		Warehouse<Widget> widgetBarn = createWarehouse(type);
		for(int i=0;i<10;i++) {
			widgetBarn.addItem(new Widget(i,"item"+i,(double) i*10,0));
		}
		System.out.print("priceRangeSearch(25,75): ");
		Iterator<InventoryItem> itr = widgetBarn.priceRangeSearch(25.0, 75.0);
		while(itr.hasNext()) {
			System.out.print(itr.next() + ", ");
		}
		System.out.println();
		
	}
	
	

}
