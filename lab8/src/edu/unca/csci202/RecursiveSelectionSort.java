
package edu.unca.csci202;

/**
 * recursive selection sort for lab8
 * @author cblah
 * @version 1.0
 *
 */
public class RecursiveSelectionSort<T extends Comparable<T>> {

	private int number_of_comparisons;
	private int number_of_swaps;
	
	private class Node<T>{
		Node<T> next;
		T data;
	}
	
	private Node<T> head;
	private Node<T> tail;
	private int count;
	private boolean debug;
	
	/**
	 * constructor sets the debug to the param and the head and tail to null and the count to 0
	 * 
	 * @param debug
	 */
	public RecursiveSelectionSort(boolean debug) {
		this.debug = debug;
		this.head = null;
		this.tail = null;
		this.count = 0;
	}
	
	/**
	 * constructor for debug set to false by default
	 */
	public RecursiveSelectionSort() {
		this.debug = false;
		this.head = null;
		this.tail = null;
		this.count = 0;
	}
	
	/**
	 * this method adds a node with the param at the end of the list
	 * 
	 * @param element to be added to the list
	 */
	public void addToBack(T element) {
		Node<T> temp = new Node<T>();
		temp.data=element;
		temp.next = null;//always true for the end of the list
		if(tail==null) {
			this.tail = temp;
			this.head = temp;
		}else {
			this.tail.next = temp;
			this.tail = temp;
		}
		this.count++;
		
	}
	
	
	
	/**
	 *sets the full list's data to a string
	 */
	public String toString() {
	
		return getSubString(this.head);
		
	}
	
	/**
	 * @param curr / the starting node to print its data to the end of the list
	 * @return a string containing the data of the current node to the end of the list
	 */
	private String getSubString(Node<T> curr) {
		String ret = "[";
		while(curr != null) {
			ret += curr.data;
			
			if(curr.next != null) {
				ret += ", ";
			}
			curr = curr.next;
		}
		
		return ret + "]";
	}
	
	/**
	 * sort the linked list in place
	 */
	public void sort() {
		long start_time = 0;
		if(this.debug==false) {
			start_time = System.currentTimeMillis();
		}
		this.head = sort_sub(this.head);
		if(this.debug==false) {
			long stop_time = System.currentTimeMillis();
			System.out.println("***** STATS *****");
			System.out.println("Number of comparisons " + this.number_of_comparisons);
			System.out.println("Number of swaps " + this.number_of_swaps);
			System.out.println("Sorting took " + (stop_time - start_time)+ " millisecond");
		}
		
	}
	
	/**
	 * Sort the sublist using a recursive algorithm.
	 * @param current, head node of a sub list.
	 * @return head node of a sorted sublist.
	 */
	private Node<T> sort_sub(Node<T> current){
		Node<T> temp = current; // iterator to go through the list
		Node<T> min = current; // which node has the minimum value of this sub-list
		T temp_swap;
		
		if(current == null) {
			return current;
		}
		
		if(this.debug) {
			System.out.println(this.getSubString(current));
		}
		
		//iterate through the list, find the minimum element.
		while (temp != null) {
			this.number_of_comparisons++;
			if(min.data.compareTo(temp.data) > 0 ) {
				min = temp;// temp is the minimum so far. save that info
			}
			temp = temp.next;
		}
		//swap the value from the beginning to the min value.
		if (min != current) {
			this.number_of_swaps++;
			temp_swap = current .data;//swap value, not nodes. no need to change next
			current.data = min.data;
			min.data = temp_swap;
		}
		//sort the sublist - recursive call
		
		current.next = this.sort_sub(current.next);
		
		if(this.debug) {
			System.out.println(this.getSubString(current));
		}
		//return the sorted sublist
		return current;
	}
}
