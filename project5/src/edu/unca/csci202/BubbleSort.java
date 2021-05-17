package edu.unca.csci202;

import edu.unca.csci202.SortingAlgorithm.Node;

/**
 * Bubble sort class for project5
 * @author cblah
 *
 * @param <T>
 */
public class BubbleSort<T extends Comparable<T>> extends SortingAlgorithm<T> {
	
	public BubbleSort() {
		super();
	}
	
	public BubbleSort(boolean debug) {
		super(debug);
	}

	/**
	 *A bubble sort algorithm
	 */
	@Override
	public void sort() {
		
		for(Node<T> i= this.tail; i!= null; i=i.prev) {
			
			for(Node<T> j = this.head; j != i; j=j.next) {
				this.numberOfComparisons++;
				if(j.data.compareTo(j.next.data)>0) {
					this.swap(j.next, j);
//					T temp = j.data;
//					j.data = j.next.data;
//					j.next.data=temp;
//					this.numberOfSwaps++;
				}
			}
			
		}

	}

}
