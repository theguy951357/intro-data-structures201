
package edu.unca.csci202;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * This is a linked ordered list that uses the OrderedListADT interface
 * @author cblah
 *
 * @param <T>
 */
public class LinkedOrderedList<T extends Comparable<T>> implements OrderedListADT<T> {

	

	
	/**
	 * 
	 * This is a private class for the Node
	 * @author cblah
	 *
	 * @param <T>
	 */
	private class Node<T>{
		Node<T> next;
		T data;
	}
	
	Node<T> head;
	int count;
	
	/**
	 * This constructor sets the head to null and the count to 0.
	 */
	public LinkedOrderedList() {
		this.head = null;
		this.count = 0;
	}
	
	/**
	 *provides a string representation of the list.
	 *@return a string representation of the list.
	 */
	@Override
	public String toString() {
		Node<T> current = this.head;
		String nodeString = "";
		while(current != null) {
			nodeString += current.data;
			current = current.next;
		}
		return "LinkedOrderedList [ "+ nodeString + " ]";
	}
	
	
	
	/**
	 *This removes a node from the list with the specified element.
	 *@return the removed element from the list.
	 *@throws NoSuchElementException 
	 */
	@Override
	public T remove(T element) throws NoSuchElementException {
		if(this.count==0) {
			throw new NoSuchElementException("LinkedOrderedList is empty");
		}else if(this.count==1){
			//check the first element
			if(this.head.data.equals(element)) {
				return this.removeFirst();
			}else {
				throw new NoSuchElementException("Could not find element: " + element);
			}
		}else {
			//search through the list for the element match
			Node<T> current = this.head;
			Node<T> trailing = null;
			while(current.next != null && !current.data.equals(element)) {
				trailing = current;
				current = current.next;
				
			}
			
			if(current.next == null) {
				throw new NoSuchElementException("Could not find element: " + element);
			}
			T temp = current.data;
			trailing.next=current.next;
			count--;
		    return temp;
		}
		
	}

	/**
	 *this removes the first element from the list.
	 *@return the removed element from the list if it is not empty.
	 *@throws NoSuchElementException
	 */
	@Override
	public T removeFirst() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(this.count == 0) {
			throw new NoSuchElementException("LinkedOrderedList is empty");
		}
		T temp = this.head.data;
		this.head = this.head.next;
		this.count--;
		return temp;
	}

	/**
	 *this removes the last element from the list.
	 *@return the removed element from the list if it is not empty.
	 *@throws NoSuchElementException
	 */
	@Override
	public T removeLast() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(this.count==0) {
			throw new NoSuchElementException("LinkedOrderedList is empty");
		}else if(this.count==1){
			return this.removeFirst();
		}else {
			Node<T> current = this.head;
			Node<T> trailing = null;
			while(current.next != null) {
				trailing = current;
				current = current.next;
				
			}
			trailing.next=null;
			count--;
		    return current.data;
		}
		
	}

	/**
	 *This provides a reference to the first node in the list.
	 *@return the first node in the list if it is not empty.
	 *@throws NoSuchElementException
	 */
	@Override
	public T first() throws NoSuchElementException {
		if(this.count==0) {
			throw new NoSuchElementException("LinkedOrderedList is empty");
		}
		return this.head.data;
	}

	/**
	 *This provides a reference to the last node in the list.
	 *@return the last node in the list if it is not empty.
	 *@throws NoSuchElementException
	 */
	@Override
	public T last() throws NoSuchElementException {
		if(this.count==0) {
			throw new NoSuchElementException("LinkedOrderedList is empty");
		}else {
			Node<T> current = this.head;
			while(current.next != null) {
				current = current.next;
			}
			
			return current.data;
		}
		
	}

	/**
	 *This is a boolean to check if the list is empty.
	 *@return true if the list is empty, false if otherwise.
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (this.count == 0);
	}

	/**
	 *This checks for the size of the list.
	 *@return the current count.
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.count;
	}
	
	/**
	 * This is a private Iterator class for the public iterator method to operate on.
	 * @author cblah
	 *
	 * @param <T>
	 */
	private class LinkedOrderedListIterator<T> implements Iterator<T>{

		private Node<T> current;
		
		/**
		 * constructor for the LinkedOrderedListIterator class sets the current to the specified node
		 * @param node
		 */
		public LinkedOrderedListIterator(Node<T> node){
			this.current = node;
		}

		/**
		 *This checks to see if the current element has a reference to a next element.
		 */
		@Override
		public boolean hasNext() {
			
			return this.current != null;
		}

		/**
		 *Moves to the next node in the list.
		 */
		@Override
		public T next() {
			T temp = this.current.data;
			this.current = this.current.next;
			return temp;
		}
		
	}

	/**
	 *This is a method to allow iteration through the list outside of the class.
	 */
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new LinkedOrderedListIterator(this.head);
	}

	
	/**
	 * This adds a node containing the element to the ordered list in the right spot.
	 *@param T element
	 */
	@Override
	public void add(T element) {
		// TODO Auto-generated method stub
		Node<T> temp = new Node<T>();
		temp.data = element;
		Node<T> current = this.head;
		Node<T> trailing = null;
		
		if(count == 0) {
			
			this.head = temp;
			
			

		}else {
			while(current.next != null && current.data.compareTo(element)<0) {
				trailing = current;
				current = current.next;
				
			}
			
			if (current.next == null) {
//				current.next = temp;
				temp.next = this.head;
				this.head = temp;
				
				
			}else {
				trailing = current;
				current = current.next;
				//trailing.next = temp;
				//temp.next = current;
				temp.next = this.head;
				this.head = temp;
				
			}
		}
		count++;
		
	}

	
	
	

}
