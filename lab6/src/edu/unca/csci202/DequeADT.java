package edu.unca.csci202;

public interface DequeADT<E> {
  /**
  * The DequeADT (double-ended queue) provides methods for inserting, deleting
  * and getting either the first or last element of a sequence of elements.
  */

  /**
  * Adds a new element to the head of this deque.
  * @param element the element to insert at the head of this deque
  */
  public void addFirst(E element);

  /**
  * Removes and returns the head element of this deque.
  * @return the head element of this deque
  * @throws NoSuchElementException if this deque is empty
  */
  public E removeFirst();

  /**
  * @return the head element of this deque
  * @throws NoSuchElementException if this deque is empty
  */
  public E getFirst();

  /**
  * Adds a new element to the tail of this deque.
  * @param element the element to insert at the tail of this deque
  */
  public void addLast(E element);

  /**
  * Removes and returns the tail element of this deque.
  * @return the tail element of this deque
  * @throws NoSuchElementException if this deque is empty
  */
  public E removeLast();

  /**
  * @return the tail element of this deque
  * @throws NoSuchElementException if this deque is empty
  */
  public E getLast();


}
