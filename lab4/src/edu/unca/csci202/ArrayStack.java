package edu.unca.csci202;

import java.util.Arrays;

/**
 * Array based implementation of a stack abstract data type ADT. Uses generic types
 * @author Chris Blaha
 * @version 1.0
 *
 */
public class ArrayStack<T> implements StackADT<T> {
	
	//instance variables.
	private T[] stack;//array of type T.
	private int top; //size.
	private final static int DEFAULT_CAPACITY = 100;
	
	/**
	 * constructor: create empty stack using the default capacity
	 */
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * 
	 * constructor create empty stack at initial capacity.
	 * 
	 * @param int initialCapacity
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack(int initialCapacity) {
		this.top = 0;
		//this.stack = new T[initialCapacity]; //not possible
		this.stack = (T[]) (new Object[initialCapacity]);
	}
	
	
	
	/**
	 * pushes a new element to the stack if there is enough space
	 * 
	 * @param T element 
	 */

	@Override
	public void push(T element) {
		if(this.size() == this.stack.length) {
			//stack is currently full. need to make it bigger.
			this.expandCapacity();
		}
		this.stack[this.top] = element;
		this.top++; //increase size.
		
	}
	
	/**
	 * create a new stack at a bigger capacity.
	 */

	private void expandCapacity() {
		this.stack = Arrays.copyOf(this.stack, this.stack.length * 2);
		
	}

	/**
	 * removes the element at the top of the stack and return a reference to it
	 * 
	 * @return element at the top of the stack.
	 * @throws EmptyCollectionException if stack is empty.
	 */
	@Override
	public T pop() {
		if(this.isEmpty()) {
			throw new EmptyCollectionException("ArrayStack is empty");
		}
		this.top--;
		T result = this.stack[top];
		this.stack[top] = null;
		return result;
	}

	/**
	 * shows you the element at the top position
	 * 
	 * @return the element at the top of the stack
	 * @throws EmptyCollectionException if stack is empty.
	 */
	@Override
	public T peek() {
		if(this.isEmpty()) {
			throw new EmptyCollectionException("ArrayStack is empty");
		}
		return this.stack[this.top-1];
	}

	/**
	 * check if stack is empty
	 * @return returns true if stack is empty, false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		
		return (this.top == 0);// this is O(1).
	}

	/**
	 * return number of elements in the stack.
	 */
	@Override
	public int size() {
		
		return this.top; //this is O(1).
	}
	
	
//	public static void main(String args[]) {
//		//demo test of ArrayStack
//		
//		ArrayStack<String> stringStack = new ArrayStack<String>();
//		stringStack.push("hello");
//		stringStack.push("how are you");
//		stringStack.push("good bye");
//		while(! stringStack.isEmpty()) {
//			System.out.println(stringStack.pop());
//		}
//	}

}
