/**
 * 
 */
package edu.unca.csci202;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/**
 * @author cblah
 *
 */
public class RandomBSTSort<T extends Comparable<T>> extends BSTSort<T> {

	//private ArrayList<T> array = new ArrayList<T>();
	private Random rand;
	
	/**
	 *sort algorithm puts the contents of a list into an array, shuffles the array, and inserts them into a BST
	 */
	public void sort() {
		
		rand = new Random();
		int n = list.size();
		int half = n/2;
		//randomizing the arraylist.
		int i;
		Object[] array = list.toArray();
		

		
		for(i=0; i< half; i++) {
			this.swap(array[i], array[rand.nextInt(half-i)+1]);
			this.swap(array[i+half], array[rand.nextInt(n-(i+half))+1]);
			this.numberOfEdgesFollowed += this.tree.insert((T) array[i])+this.tree.insert((T) array[i+half]);
			
//			this.numberOfEdgesFollowed += this.tree.insert((T) array[i+half]);
		}
		
//		for(i=0; i< list.size();) {
//			
//			T tmp = list.remove(rand.nextInt(list.size()-i));
//			//this.swap(tmp, list.get(rand.nextInt(n-i)));
//			this.numberOfEdgesFollowed += this.tree.insert(tmp);
//			
//		}

		
		
		
		
	}
	
	
	/**
	 * a swap method for the array
	 * @param t
	 * @param t2
	 */
	private void swap(Object t, Object t2) {
		// TODO Auto-generated method stub
		Object tmp = t2;
		t2 = t;
		t = tmp;
	}
}
