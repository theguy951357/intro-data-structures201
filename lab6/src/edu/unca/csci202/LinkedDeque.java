/**
 * 
 */
package edu.unca.csci202;

import java.util.NoSuchElementException;



/**
 * @author cblah
 *@version 1.0
 */
public class LinkedDeque<E> implements DequeADT<E>, QueueADT<E>,StackADT<E> {

	/**
	 * A private class for a node that contains the data, and a reference to the previous and next node.
	 * @author cblah
	 *
	 * @param <E>
	 */
	//private node class
	private class Dnode<E>{
		E data;
		Dnode<E> prev; //reference to previous node.
		Dnode<E> next; //reference to next node.
	}
	
	//instance variables
	private int count;
	private Dnode<E> head; // reference to first node in the list.
	private Dnode<E> tail; //reference to the last node in the list.
	
	//constructor
	/**
	 * Constructor sets the count to zero and the head and tail to null.
	 */
	public LinkedDeque() {
		this.count = 0;
		this.head = null;
		this.tail = null;
	}
	
	/**
	 * Method adds a node to the first part of the list.
	 * 
	 * this is the beginning of the DequeADT interface.
	 * @param <E>
	 */
	@Override
	public void addFirst(E element) {
		// TODO Auto-generated method stub
		Dnode<E> node = new Dnode<E>();
		node.data = element;
		node.next = this.head;//since we add to the front, the element after this is the current head node.
		node.prev = null;
		
		this.head = node;
		if(node.next != null) {
			node.next.prev = node;//connect the former head node's prev ref to this node.
		}
		if(this.tail == null) {
			this.tail = node;//if the list is empty, the node is the tail too.
		}
		this.count++;
		
	}
	/**
	 * removes the first element from the list
	 */
	@Override
	public E removeFirst() throws NoSuchElementException {
		if(this.head == null) {
			throw new NoSuchElementException("LinkedDeque is empty.");
		}
		E tmp = this.head.data;
		this.head = this.head.next;
		if(this.head != null) {
			this.head.prev = null;
		}
		if(this.head == null) {
			this.tail = null;
		}
		this.count--;
		return tmp;
	}

	/**
	 * gets the first node in the list.
	 * @return the data at the head node.
	 */
	@Override
	public E getFirst() {
		// gets the first node in the list.
		
		return this.head.data;
	}
	/**
	 * add an element to the end of the list.
	 */
	@Override
	public void addLast(E element) {
		Dnode<E> node = new Dnode<E>();
		node.data = element;
		node.prev = this.tail;
		node.next = null;
		
		this.tail = node;
		if(node.prev != null) {
			node.prev.next = node;
		}
		if(this.head == null) {
			this.head = node;
		}
		this.count++;
		
	}

	/**
	 * removes an element from the end of the list
	 */
	@Override
	public E removeLast() {
		if(this.tail == null) {
			throw new NoSuchElementException("LinkedDeque is empty.");
		}
		E tmp = this.tail.data;
		this.tail = this.tail.prev;
		if(this.tail != null) {
			this.tail.next = null;
		}
		if(this.tail == null) {
			this.head = null;
		}
		this.count--;
		return tmp;
	}

	/**
	 * gets the last node in the list.
	 *
	 * @return the data of the tail node in the list.
	 */
	@Override
	public E getLast() {
		// returns the last node on the list.
		return this.tail.data;
	}

	/**
	 * beginning of the StackADT interface.
	 * pushes an element to the end of the stack by using the addLast method from the Deque.
	 * 
	 * @param <E>
	 */
	@Override
	public void push(E element) {
		addLast(element);
		
	}

	/**
	 * removes the element from the end of the Stack by using the removeLast method from the deque.
	 * 
	 * @return returns the result from the removeLast method.
	 */
	@Override
	public E pop() {
		
		return removeLast();
	}

	/**
	 * allows you to view the last element of the list.
	 * 
	 * @return returns the result of the getLast() method.
	 */
	@Override
	public E peek() {
		
		return getLast();
	}
	
	

	/**
	 * Beginning of the QueueADT interface
	 * 
	 * This method will add an element to the end of the list with the addLast() method.
	 * @param <E> the element to be added.
	 */
	@Override
	public void enqueue(E element) {
		addLast(element);
		
	}

	/**
	 * this method removes an element from the front of the list with the removeFirst() method.
	 * 
	 * @return the result of the removeFirst() method.
	 */
	@Override
	public E dequeue() {
		
		return removeFirst();
	}

	/**
	 * retrieves the first element of the list
	 */
	@Override
	public E first() {
		// TODO Auto-generated method stub
		return getFirst();
	}

	/**
	 * checks if the list is empty.
	 * 
	 * @return true if the count is 0, false if not.
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (this.count==0);
	}

	/**
	 * Tells the size of the list
	 * 
	 * @return the current size of the list.
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.count;
	}

	/**
	 * A toString override that prints out the  contents of the stack
	 * 
	 * @return returns a string of the elements in the list.
	 */
	@Override
	public String toString() {
		Dnode<E> node = this.head;//temp pointer
		String ret = "LinkedStack [";
		//String ret = "";
		while(node!= null) {
			ret += node.data;
			node = node.next;//move temp pointer to next node in the list
		}
		
		ret+="]";
		return ret;
	}
	
	

}
