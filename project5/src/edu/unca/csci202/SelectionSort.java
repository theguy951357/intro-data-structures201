
package edu.unca.csci202;

/**
 * selectionSort for project5
 * @author cblah
 *
 */
public class SelectionSort<T extends Comparable<T>> extends SortingAlgorithm<T> {

	/**
	 *A selection sort algorithm
	 */
	@Override
	public void sort() {
		for(Node<T> i = this.head; i != null; i = i.next) {
			Node<T> smallest = i;
			for(Node<T> j = i; j!= null; j= j.next) {
				this.numberOfComparisons++;
				if (j.data.compareTo(smallest.data)<0) {
					smallest=j;
				}
			}
			if(i.data.compareTo(smallest.data)>0) {
				this.swap(smallest, i);
			}
			
		}

	}

}
