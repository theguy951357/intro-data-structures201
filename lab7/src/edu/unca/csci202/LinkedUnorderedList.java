package edu.unca.csci202;

import java.util.Iterator;
import java.util.NoSuchElementException;









/**
 * @author cblah
 *
 */
public class LinkedUnorderedList<T extends Comparable<T>> implements UnorderedListADT<T> {
	
	
	
	private class Node<T>{
		Node<T> next;
		T data;
	}
	
	Node<T> head;
	int count;
	
	public LinkedUnorderedList() {
		this.head = null;
		this.count = 0;
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
			throw new NoSuchElementException("LinkedUnorderedList is empty");
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
			throw new NoSuchElementException("LinkedUnorderedList is empty");
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
	 *This removes a node from the list with the specified element.
	 *@return the removed element from the list.
	 *@throws NoSuchElementException 
	 */
	@Override
	public T remove(T element) throws NoSuchElementException {
		if(this.count==0) {
			throw new NoSuchElementException("LinkedUnorderedList is empty");
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
	 *This provides a reference to the first node in the list.
	 *@return the first node in the list if it is not empty.
	 *@throws NoSuchElementException
	 */
	@Override
	public T first() throws NoSuchElementException {
		if(this.count==0) {
			throw new NoSuchElementException("LinkedUnorderedList is empty");
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
			throw new NoSuchElementException("LinkedUnorderedList is empty");
		}else {
			Node<T> current = this.head;
			while(current.next != null) {
				current = current.next;
			}
			
			return current.data;
		}
		
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.count == 0;
	}


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
	private class LinkedUnorderedListIterator<T> implements Iterator<T>{

		private Node<T> current;
		
		/**
		 * constructor for the LinkedOrderedListIterator class sets the current to the specified node
		 * @param node
		 */
		public LinkedUnorderedListIterator(Node<T> node){
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
		return new LinkedUnorderedListIterator(this.head);
	}



	/**
	 * This method adds a node to the front of the list
	 * 
	 *@param element to be added
	 */
	@Override
	public void addToFront(T element) {
		Node<T> add = new Node<T>();
		add.data = element;
		add.next = this.head;
		this.head = add;
		count++;
		
	}


	/**
	 * This method adds a node to the rear of the list
	 * 
	 *@param element to be added
	 */
	@Override
	public void addToRear(T element) {
		Node<T> add = new Node<T>();
		Node<T> current = this.head;
		add.data = element;
		while(current.next != null) {
			current = current.next;
		}
		current.next = add;
		count++;
		
		
	}

	/**
	 * This adds a node containing the element to the unordered list in the spot after the target.
	 *@param T element
	 */
	@Override
	public void addAfter(T element, T target) throws NoSuchElementException {
		
		Node<T> temp = new Node<T>();
		temp.data = element;
		if(this.count==0) {
			this.head = temp;
			
		}else {
				
			
			Node<T> current = this.head;
			Node<T> trailing = null;
			
			if(count == 0) {
				this.head = temp;
				
			}else {
				while(current.next != null && current.data.compareTo(target)!=0) {
					trailing = current;
					current = current.next;
					
				}
				
				if(current == null) {
					throw new NoSuchElementException("Could not find target element: " + element);
				}
				
				if (current.next == null) {
					current.next = temp;
				}else {
					trailing = current;
					current = current.next;
					trailing.next = temp;
					temp.next = current;
				}
			}
		}
		count++;
	
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
		return "LinkedUnorderedList [ "+ nodeString + " ]";
	}
	


	
}
