package edu.unca.csci202;

/**
 * QuickSort for project 5
 * @author cblah
 *
 */
public class QuickSort<T extends Comparable<T>> extends SortingAlgorithm<T> {

	/**
	 *Sort method calls quicksort
	 */
	@Override
	public void sort() {
		this.quicksort(this.head, this.tail);
	}
	
	/**
	 * quicksort recursively partitions the list until it is sorted.
	 * @param min
	 * @param max
	 */
	private void quicksort(Node<T> min, Node<T> max) {
		if(min.prev!=max && min != max)  {
			//create partitions
			Node<T> partition = this.partition(min, max);	
			//sort the left partitions
			if(partition!= null) {
				//System.out.println("sorting left");
				this.quicksort(min, partition.prev);
			}
			//sort the right partitions
			if(partition.next != null ) {
				//System.out.println("sorting right");
				this.quicksort(partition.next, max);	
			}
		} 
	}
	
	/**
	 * The partition method takes the partition node and separates the elements that are higher and lower than the partition node
	 * @param min
	 * @param max
	 * @return returns the element between the two partitions
	 */
	private Node<T> partition(Node<T> min, Node<T> max){
		this.numberOfComparisons++;
		Node<T> partition=min;
		boolean less = true;
		while(less) {
			//search for an element that is > the partition element
			while(less && min.data.compareTo(partition.data)<=0) {
				min=min.next;
				if(min == max) {
					less = false;
				}
			}
			//search for element that is < the partition element
			while( max.data.compareTo(partition.data)>0) {
				max=max.prev;
				if(min == max) {
					less = false;
				}
			}	
			//swap the elements if the left is less than the right 
			if(less) {
				this.swap(min, max);
			}
		}
		//move the partition element to the right position
		this.swap(partition, max);
		return max;
	}
	
//	private int getCount(Node<T> min, Node<T> max) {
//		int count = 0;
//		Node<T> current = min;
//		while(current != null) {
//			
//			count++;
//			//System.out.println(count);
//			if(current == max) {break;}
//			current = current.next;
//		}
//		return count;
//		
//		
//	}
	
	
	
	/**
	 *An override for the printstats so that it prints out the same as the expected output
	 */
	@Override
	public void printStats() {
		
		System.out.print("#Swaps: "+this.numberOfSwaps+"  ");
		System.out.println("#QuickSortCalls: "+this.numberOfComparisons);
	}
	

}
