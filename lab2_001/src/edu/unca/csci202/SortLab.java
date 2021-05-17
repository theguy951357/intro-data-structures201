package edu.unca.csci202;

import java.util.Random;
import java.util.Scanner;

public class SortLab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ask first question
		
		int validation_or_speed; 
		while(true) {
			validation_or_speed = readNumberFromUser("Which test do you want to run: validation (1) or speed (2)");
			if(validation_or_speed == 1 || validation_or_speed == 2) {
				break;
			}
		
		}
		// ask second question
		int string_or_int;
		while(true) {
			string_or_int = readNumberFromUser("Which type do yu want to use: int(1) or String (2)");
			if(string_or_int == 1 || string_or_int == 2) {
				break;
			}
		}
		//ask third question
		int algorithm;
		while(true) {
			algorithm = readNumberFromUser("Which algorithm do you want to use: Bubble(1) Insertion(2) or Selection(3)");
			if(algorithm == 1 || algorithm == 2 ||algorithm == 3 ) {
				break;
			}
		}
		//ask fourth question
		int num_items = 0;
		if(validation_or_speed == 2) {
			while(true) {
				num_items = readNumberFromUser("How many items do you want to sort: ");
				if(num_items > 0) {
					break;
				}
			}
		}
		
//		while(true) {
//			num_items = readNumberFromUser("How many items do you want to sort: ");
//			if(num_items > 0) {
//				break;
//			}
//		}
		
		
		//create sorting algorithm object
		SortAlgorithm sortObj = null;
		
		if(algorithm == 1) {
			//bubble sort
			sortObj = new BubbleSort();
		}else if(algorithm == 2) {
			//insertion sort
			sortObj = new InsertionSort();
		}else if(algorithm == 3) {
			//selection sort
			sortObj = new SelectionSort();
		}
		
		//run the test
		if(validation_or_speed == 1) {
			//validation test
			if(string_or_int == 1) {//int
				int[] test_data = testNumbers();
				print_array(test_data);
				sortObj.sort(test_data, true);
				print_array(test_data);
				sortObj.printStats();
				
			}else {//string
				String[] test_data = testStrings();
				sortObj.print_array(test_data);
				sortObj.sort(test_data, true);
				sortObj.print_array(test_data);
				sortObj.printStats();
			}
		}else {
			//speed test
			if(string_or_int == 1) {//int
				int[] test_data = generateNumbers(num_items);
				long start_time = System.currentTimeMillis();
				sortObj.sort(test_data, false);
				long stop_time = System.currentTimeMillis();
				sortObj.printStats();
				
				System.out.println("Sorting took " + (stop_time - start_time)+ " millisecond");
				
			}else {//string
				String[] test_data = generateStrings(num_items);
				long start_time = System.currentTimeMillis();
				sortObj.sort(test_data, false);
				long stop_time = System.currentTimeMillis();
				sortObj.printStats();
				
				System.out.println("Sorting took " + (stop_time - start_time)+ " millisecond");
			}}
			

	}
	
	
	private static String[] testStrings() {
		String[] arr = {
				"The", "quick", "brown", "fox",
				"jumps", "over", "the", "lazy",
				"dog"
		};
		return arr;
	}


	private static int[] testNumbers() {
		int[] arr = {
				9,1,2,8,3,7,4,6,5
				
		};
		return arr;
	}

//  since sorting classes will be outputting arrays, I have moved the methods to the parent class.
	private static void print_array(int[] test_data) {
		for(int i = 0; i < test_data.length; i++) {
			System.out.print(test_data[i] + " ");
		}
		System.out.println();
		
	}
	
	private static void print_array(String[] test_data) {
		for(int i = 0; i < test_data.length; i++) {
			System.out.print(test_data[i] + " ");
		}
		System.out.println();
		
	}
	
	private static int[] generateNumbers(int n) {
		Random rand = new Random();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = rand.nextInt(1000);
		}
		return arr;
	}
	//generates random for the data
	private static String[] generateStrings(int n) {
		String[] arr = new String[n];
		for(int i = 0; i < n; i++) {
			arr[i] = generateRandomString(10);
		}
		
		return arr;
	}
	
	private static String generateRandomString(int length) {
		Random rand = new Random();
		String returnString = "";
		for(int i=0; i<length; i++) {
			int asciiValue = rand.nextInt(26) + 97; // 'a' == 97
			returnString += Character.toString((char) asciiValue);
		}
		return returnString;
	}
	


	public static int readNumberFromUser(String prompt) {
		
		Scanner scan = new Scanner(System.in);
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
	
	

}
