/**
 * 
 */
package edu.unca.csci202;

import java.util.Iterator;
import java.util.Random;

/**
 * @author Brian Drawert
 * @data Oct 28th, 2020
 * 
 */
public class SortLab3 {

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
		
		Object algos[] = new Object[2];//TODO remember to change this back to [2] and uncomment RandomBSTSort when ready.
		algos[0] = new Algo<Integer>(new BSTSort<Integer>(),      "     BST Sort       ",true,true);
		algos[1] = new Algo<Integer>(new RandomBSTSort<Integer>(),"     Random BST Sort",true,true);
		
		// Test the LinkedBST implement 
		LinkedBST<Integer> bst = new LinkedBST<Integer>();
		//int[] numbers = {13, 7, 24, 4, 10, 18, 37, 2,  9, 12, 18, 37, 22};
		int[] numbers = {42, 23, 58, 13, 49, 63, 17, 51,  53};
		for(int i=0;i<numbers.length;i++) {
			bst.insert(numbers[i]);
		}
		System.out.println(bst);
		System.out.print("height:"+bst.height());
		System.out.print(" min:"+bst.minimum());
		System.out.println(" max:"+bst.maximum());
		System.out.println("InOrder Traversal:");
		Iterator<Integer> itr = bst.iteratorInOrder();
		while(itr.hasNext()) {
			System.out.print(itr.next() + ", ");
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		// validation test
		for(int a=0; a<algos.length; a++) {
			Algo<Integer> A = (Algo<Integer>) algos[a];
			if(A.enabled && A.runTest) {
				System.out.println("Testing: "+A.name);
				A.s.clear();
				testNumbers(A.s);
				A.s.sort();
				System.out.println(A.s);
				A.s.debug = true;
				A.s.printStats();
				A.s.debug = false;
			}
		}
		
		
		// Speed test
		double[] exp = {1,2,3,4,5,6,6.5,7};
		for(int i=0;i<exp.length; i++) {
			int size = (int) Math.floor(Math.pow(10, exp[i]));
			System.out.println("=============================");
			System.out.println("Timing: sort list of "+size+" integers (10^"+exp[i]+")");
			//=============================
			for(int t=0; t<3; t++) {
				if(t==0) {
					System.out.println("Random numbers");
				}else if(t==1) {
					System.out.println("Sequential numbers");
				}else {
					System.out.println("Reversed Sequential numbers");
				}
				for(int a=0; a<algos.length; a++) {
					Algo<Integer> A = (Algo<Integer>) algos[a];
					if(A.enabled) {
						A.s.clear();
						if(t==0) {
							generateRandomNumbers(size,A.s);
						}else if(t==1) {
							generateSequenceNumbers(size,A.s);
						}else {
							generateReverseSequenceNumbers(size,A.s);
						}
						try {
							tic = System.currentTimeMillis();
							A.s.sort();
							long time = System.currentTimeMillis()-tic;
							System.out.print(A.name+": "+time+"ms  ");
							A.s.printStats();							
							if(time > 10000) {
								System.out.println("\tTook longer than 10 seconds, disabling "+A.name);
								A.enabled = false;
								break;
							}
						}catch(StackOverflowError e) {
							System.out.println(e);
							A.enabled = false;
							System.out.println("\tStackOverflow, disabling "+A.name);
							break;
						}
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

	public static void generateRandomNumbers(int howMany, SortingAlgorithm<Integer> s) {
		Random r = new Random();
		for(int i=0; i<howMany; i++) {
			s.addToBack(r.nextInt());
		}
	}
	
	public static void generateSequenceNumbers(int howMany, SortingAlgorithm<Integer> s) {
		for(int i=0; i<howMany; i++) {
			s.addToBack(i);
		}
	}
	public static void generateReverseSequenceNumbers(int howMany, SortingAlgorithm<Integer> s) {
		for(int i=howMany-1; i>=0; i--) {
			s.addToBack(i);
		}
	}
}