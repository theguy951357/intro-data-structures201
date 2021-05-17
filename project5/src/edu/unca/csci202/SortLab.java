/**
 * 
 */
package edu.unca.csci202;

import java.util.Random;

/**
 * @author Brian Drawert
 * @data Oct 7th, 2020
 * 
 */
public class SortLab {

	/**
	 * This private class holds information on each of the sorting algorithms
	 *
	 * @param <T>
	 */
	private static class Algo<T extends Comparable<T>> {
		public  Algo(SortingAlgorithm<T> s, String name, boolean enabled, boolean runTest) {
			super();
			this.s = s;
			this.name = name;
			this.enabled = enabled;
			this.runTest = runTest;
		}

		SortingAlgorithm<T> s;
		String name;
		boolean enabled;
		boolean runTest;
	
	}

	public static void main(String[] args) {		
		long tic;
		
		Object algos[] = new Object[5];
		algos[0] = new Algo<Integer>(new QuickSort<Integer>(),             "QuickSort             ",true,true);
		algos[1] = new Algo<Integer>(new RecursiveSelectionSort<Integer>(),"RecursiveSelectionSort",true,true);
		algos[2] = new Algo<Integer>(new SelectionSort<Integer>(),         "SelectionSort         ",true,true);
		algos[3] = new Algo<Integer>(new BubbleSort<Integer>(),            "BubbleSort            ",true,true);
		algos[4] = new Algo<Integer>(new InsertionSort<Integer>(),         "InsertionSort         ",true,true);
				
		for(int a=0; a<algos.length; a++) {
			Algo<Integer> A = (Algo<Integer>) algos[a];
			if(A.enabled && A.runTest) {
				System.out.println("Testing: "+A.name);
				A.s.clear();
				testNumbers(A.s);
				System.out.println(A.s);
				A.s.sort();
				System.out.println(A.s);
			}
		}
		
		double[] exp = {1,2,3,4,5,6,6.5,7,7.5};
		for(int i=0;i<exp.length; i++) {
			int size = (int) Math.floor(Math.pow(10, exp[i]));
			System.out.println("=============================");
			System.out.println("Timing: sort list of "+size+" integers (10^"+exp[i]+")");
			//=============================
			for(int a=0; a<algos.length; a++) {
				Algo<Integer> A = (Algo<Integer>) algos[a];
				if(A.enabled) {
					A.s.clear();
					generateNumbers(size,A.s);
					tic = System.currentTimeMillis();
					try {
						A.s.sort();
					}catch(StackOverflowError e) {
						System.out.println(e);
						A.enabled = false;
						System.out.println("\tStackOverflow, disabling "+A.name);
					}
					long time = System.currentTimeMillis()-tic;
					System.out.print(A.name+": "+time+"ms  ");
					A.s.printStats();
					if(time > 10000) {
						System.out.println("\tTook longer than 10 seconds, disabling "+A.name);
						A.enabled = false;
					}
				}
			}
		}
		

	}
	
	private static void testNumbers(SortingAlgorithm<Integer> s) {
		int[] arr = { 9,0,8,1,7,2,6,3,5,4 };
		for(int i=0; i< arr.length; i++) {
			s.addToBack(arr[i]);
		}
	}

	private static void testString(SortingAlgorithm<String> s) {
		String[] arr = {
			"The", "Quick", "Brown", "Fox", "jumps", "over","the",
			"Lazy", "Dog", "A", "a", "Z", "z", "1", "2", "3"
		};
		for(int i=0; i< arr.length; i++) {
			s.addToBack(arr[i]);
		}
	}

	public static void generateNumbers(int howMany, SortingAlgorithm<Integer> s) {
		Random r = new Random();
		for(int i=0;i<howMany;i++) {
			s.addToBack(r.nextInt());
		}
	}
	
	public static void generateStrings(int n, SortingAlgorithm<String> s) {
		Random r = new Random();
		for(int i=0; i<n; i++) {
			int char_n = r.nextInt(10)+3;
			char[] char_arr = new char[char_n];
			for(int j=0; j<char_n; j++) {
				char_arr[j] = (char) (r.nextInt(94)+33);
			}
			s.addToBack(new String(char_arr));
		}
	}

	
	


}
