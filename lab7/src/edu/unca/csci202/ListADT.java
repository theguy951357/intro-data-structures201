/**
 * 
 */
package edu.unca.csci202;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Chris blaha
 * @version 1.0
 *
 */
public abstract interface ListADT<T> {
	
	/**
	 * remove and return first element
	 * @returns first element in list
	 */
	public T removeFirst();
	
	/**
	 * remove and return last element
	 * @returns last element in list
	 * @throws NoSuchElementException
	 */
	public T removeLast() throws NoSuchElementException;
	
	public T remove(T element) throws NoSuchElementException;
	
	/**
	 * return first element
	 * @returns first element in list
	 * @throws NoSuchElementException
	 */
	public T first() throws NoSuchElementException;

	public T last() throws NoSuchElementException;
	
	public boolean isEmpty();
	
	public int size();
	
	
	public Iterator<T> iterator();
	
	public String toString();
}
