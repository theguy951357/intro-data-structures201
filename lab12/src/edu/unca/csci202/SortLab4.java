/**
 * 
 */
package edu.unca.csci202;

import java.util.Iterator;
import java.util.Random;

/**
 * @author Brian Drawert
 * @data Nov 4th, 2020
 * 
 */
public class SortLab4 {

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
		
		Object algos[] = new Object[2];
		algos[0] = new Algo<Integer>(new BSTSort<Integer>(),   "     BST Sort       ",true,true);
		algos[1] = new Algo<Integer>(new AVLSort<Integer>(),   "     AVL Sort       ",true,true);
		
		// Test the LinkedBST implement 
		BinarySearchTreeADT<Integer> bst = new AVLTree<Integer>();
		int[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		//int[] numbers = {34,45,3,87,65,32,1,12,17};
		for(int i=0;i<numbers.length;i++) {
			System.out.println("_____________________________________________________________");
			System.out.println("inserting "+ numbers[i]+" and printing tree:");
			bst.insert(numbers[i]);
			System.out.println(bst);
		}
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
		
		//AVLSort<Integer>x = new AVLSort<Integer>();
		//testNumbers(x);
		//x.sort();
		//System.out.println(x.getTree());
		
		
		// validation test
		for(int a=0; a<algos.length; a++) {
			Algo<Integer> A = (Algo<Integer>) algos[a];
			if(A == null) break;
			if(A.enabled && A.runTest) {
				System.out.println("Validation Testing: "+A.name);
				A.s.clear();
				A.s.debug = true;
				testNumbers(A.s);  
				A.s.sort();// TODO print out after each insert
				System.out.println(A.s);
				A.s.printStats();
				//AVLSort<Integer> B = (AVLSort<Integer>) A.s;
				//System.out.println(B.getTree());
				A.s.debug = false;
				break;
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
					if(A == null) break;
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