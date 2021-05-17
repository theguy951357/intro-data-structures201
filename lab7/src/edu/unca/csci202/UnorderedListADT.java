package edu.unca.csci202;

import java.util.NoSuchElementException;

public interface UnorderedListADT<T> extends ListADT<T> {
	
	public void addToFront(T element);
	
	public void addToRear(T element);
	
	public void addAfter(T element, T target) throws NoSuchElementException;

}
