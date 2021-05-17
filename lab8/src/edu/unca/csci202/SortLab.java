
package edu.unca.csci202;

import java.util.Random;

/**
 * lab8 sort lab for recursiveSelectionSort.
 * 
 * @author chris blaha
 * 
 * @version 1.0
 *
 */
public class SortLab {
	
	

	/**
	 * the main is going to make a few instances of RecursiveSelectionSort and run the sort methods on them.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		RecursiveSelectionSort<String> s1 = new RecursiveSelectionSort<String>(true);
		testStrings(s1);
		System.out.println(s1.toString());
		s1.sort();
		System.out.println(s1.toString());
		
		System.out.println("*******************************");
		
		RecursiveSelectionSort<String> s2 = new RecursiveSelectionSort<String>(false);
		generateStrings(100,s2);
		s2.sort();
		
		System.out.println("*******************************");
		
		RecursiveSelectionSort<String> s3 = new RecursiveSelectionSort<String>(false);
		generateStrings(1000,s3);
		s3.sort();
		
		System.out.println("*******************************");
		
		RecursiveSelectionSort<String> s4 = new RecursiveSelectionSort<String>(false);
		generateStrings(10000,s4);
		s4.sort();
		
		System.out.println("*******************************");
		
		//testing numbers
		RecursiveSelectionSort<Integer> s5 = new RecursiveSelectionSort<Integer>(true);
		testNumbers(s5);
		System.out.println(s5.toString());
		s5.sort();
		System.out.println(s5.toString());
		
		System.out.println("*******************************");
		
		RecursiveSelectionSort<Integer> s6 = new RecursiveSelectionSort<Integer>(false);
		generateNumbers(100,s6);
		s6.sort();
		
		System.out.println("*******************************");
		
		RecursiveSelectionSort<Integer> s7 = new RecursiveSelectionSort<Integer>(false);
		generateNumbers(1000,s7);
		s7.sort();
		
		System.out.println("*******************************");
		
		RecursiveSelectionSort<Integer> s8 = new RecursiveSelectionSort<Integer>(false);
		generateNumbers(10000,s8);
		s8.sort();
		
		System.out.println("*******************************");
	
	}

	/**
	 * this method takes a premade array of strings and populates them into the list.
	 * 
	 * @param sort / the list to be populated
	 */
	private static void testStrings(RecursiveSelectionSort<String> sort) {
		String[] arr = { "The", "Quick", "Brown", "Fox", "Jumps", "Over", "the" , "Lazy", "Dog", "A", "a", "1", "2", "3"};
		for(int i = 0; i< arr.length; i++) {
			sort.addToBack(arr[i]);
		}
	
	}
	
	/**
	 * taken from lab 2
	 * this is a premade array of numbers to test the sort algorithm
	 * 
	 * @param sort /the sort list to be populated
	 */
	private static void testNumbers(RecursiveSelectionSort<Integer> sort) {
		int[] arr = {0,1,9,2,8,3,7,4,6,5};
		for(int i = 0; i< arr.length; i++) {
			sort.addToBack(arr[i]);
		}
	}
	
	//generates random for the data
		/**
		 * taken from lab 2
		 * this method takes randomly generated strings and populates them into the given list
		 * 
		 * @param n number of strings to make
		 * @param sort / the sort list to be populated
		 */
		private static void generateStrings(int n,RecursiveSelectionSort<String> sort) {
			//String[] arr = new String[n];
			for(int i = 0; i < n; i++) {
				sort.addToBack(generateRandomString(10)); //generateRandomString(10);
			}
			
			
		}
		
		/**
		 * taken from lab 2
		 * This generates a string of random lower-case letters for the generateStrings method to use
		 * 
		 * @param length
		 * @return the random string
		 */
		private static String generateRandomString(int length) {
			Random rand = new Random();
			String returnString = "";
			for(int i=0; i<length; i++) {
				int asciiValue = rand.nextInt(26) + 97; // 'a' == 97
				returnString += Character.toString((char) asciiValue);
			}
			return returnString;
		}
		
		/**
		 * taken from lab2
		 * 
		 * This method generates random numbers to fill into the list
		 * 
		 * @param n number of integers
		 * @param sort / the sort list to populate the random numbers 
		 */
		private static void generateNumbers(int n, RecursiveSelectionSort<Integer> sort) {
			Random rand = new Random();
			for(int i = 0; i < n; i++) {
				sort.addToBack(rand.nextInt(1000));
			}
			
		}

}
