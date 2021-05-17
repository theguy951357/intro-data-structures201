/**
 * 
 */
package edu.unca.csci202;



/**
 * RecursiveSelectionSort for project 5
 * @author cblah
 *
 */
public class RecursiveSelectionSort<T extends Comparable<T>> extends SortingAlgorithm<T> {

	/**
	 *sort calls sort_sub
	 */
	@Override
	public void sort() {
		// TODO Auto-generated method stub
		this.sort_sub(this.head);
	}
	
	/**
	 * Sort_sub does most of the sorting work
	 * @param current
	 * @return returns the current node
	 */
	private Node<T> sort_sub(Node<T> current){
		Node<T> temp = current; // iterator to go through the list
		Node<T> min = current; // which node has the minimum value of this sub-list
		T temp_swap;
		this.numberOfComparisons++;
		if(current == null) {
			return current;
		}
		//iterate through the list, find the minimum element.
		while (temp != null) {
			if(min.data.compareTo(temp.data) > 0 ) {
				min = temp;// temp is the minimum so far. save that info
			}
			temp = temp.next;
		}
		//swap the value from the beginning to the min value.
		if (min != current) {
			this.swap(current, min);
		}
		//sort the sublist - recursive call
		current.next = this.sort_sub(current.next);
		//return the sorted sublist
		return current;
	}

	/**
	 *An override for the printStats so the output matches the expected output
	 */
	@Override
	public void printStats() {
		// TODO Auto-generated method stub
		System.out.print("#numberOfSwaps: "+this.numberOfSwaps+"  ");
		System.out.println("#numberOfRecursionCalls: "+this.numberOfComparisons);
	}
	
	


}
