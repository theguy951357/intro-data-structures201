package edu.unca.csci202;


/**
 * 
 * @author cblah
 *
 *@version 1.0
 *
 * @param <T>
 * Implementation of a Linked Stack. This behaves like a stack and has a reference to the node next to it in the stack.
 */

public class LinkedStack<T> implements StackADT<T> {
	//need a node to use as the links in this linked list
	//inner class
	private class LinkedNode<T>{
		T data;
		LinkedNode <T> next;
		LinkedNode <T> rear;
	}
	
	//Instance variables
	private int count;
	private LinkedNode<T> head;
	
	/**
	 * constructor that initializes the linked stack to null with a count of 0.
	 */
	//constructors
	public LinkedStack() {
		this.count = 0;
		this.head = null;
	}
	

	/**
	 * add an element to the beginning of the linked list in the 
	 * LinkedStack
	 * @param element to be added to the stack
	 */
	@Override
	public void push(T element) {
		LinkedNode<T> node = new LinkedNode<T>();//new link in our list
		node.data = element;//assign the data pointer.
		
		node.next = this.head;//assign the next pointer to the current first element in the list
		
		this.head = node;//change the head pointer to our new node.
		this.count++;

	}

	

	
	/**
	 * Method to push an element to the end of the list.
	 * This will make a new element and move all the other elements over.
	 * @param element
	 */
	
	public void pushEnd(T element) {
		LinkedNode<T> node = new LinkedNode<T>();
		node.data = element;//assign the data pointer.
		//these two are the same
		//if list is empty, make a new list
		if(this.head == null) {
			this.head = new LinkedNode<T>();
		}
		//make the next reference null since it is at the end of the list
		node.next = null;
		//make a new node to reference the previous ones and set them the their own next references.
		LinkedNode<T> rear = this.head;
		while(rear.next != null) {
			rear = rear.next;
		}
		//set previous's next reference to the current node.
		rear.next = node;
		this.count++;
	}

	/**
	 * Remove and return the first element in the linked structure.
	 * @return the element on the top of the stack.
	 * @throws EmptyCollectionException if the stack is empty.
	 */
	@Override
	public T pop() {
		if(this.isEmpty()) {
			throw new EmptyCollectionException("linkedStack is empty.");
		}
		LinkedNode<T> node = this.head;
		this.head = node.next;
		this.count--;
		return node.data;
	}

	/**
	 * Return the first element in the linked structure.
	 * @return the element on the top of the stack.
	 * @throws EmptyCollectionException if the stack is empty.
	 */
	@Override
	public T peek() {
		if(this.isEmpty()) {
			throw new EmptyCollectionException("linkedStack is empty.");
		}
		return this.head.data;
	}

	/**
	 * returns true if the stack is empty, false if not.
	 * @return true if stack is empty or false if not.
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (this.count==0);
	}

	/**
	 * Returns the size of the stack.
	 * @return an int representing the size of the stack.
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.count;
	}
	
	/**  
	 * Returns a string representation of this linked stack. 
	 * @return a string representation of the linked stack
	 */
	public String toString() {
		LinkedNode<T> node = this.head;//temp pointer
		//String ret = "LinkedStack [";
		String ret = "";
		while(node!= null) {
			ret += node.data;
			node = node.next;//move temp pointer to next node in the list
		}
		
		/*
		 * for loop method
		 * for(LinkedNode<T> node = this.head; node!=null; node=node.next ){
		 * 	ret += node.data;
			node = node.next;
		 * }
		 */
		
		//ret+="]";
		
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedStack<String> s = new LinkedStack<String>();
		s.push("A, ");
		System.out.println(s);
		s.pushEnd("B, ");
		System.out.println(s);
		s.pushEnd("C, ");
		System.out.println(s);
		s.push("-A, ");
		System.out.println(s);
		
		
		while(!s.isEmpty()) {
			System.out.println("pop = " + s.pop() + "  " + s);
		}
	}

}
