package edu.unca.csci202;
/**
 * DO NOT MODIFY THIS FILE
 *
 * Interface to define a hand of cards in the card game
 */
public interface HandOfCards<T extends Card> {

	/** 
	 * Add a Card to the internal data structures
	 * of the class
	 * @param card to be added
	 */
	public void add(T card);

	/**
	 * Return the smallest value Card in the hand
	 * @return smallest value Card
	 */
	public T peekSmallest();
	
	/** 
	 * Return and remove smallest value Card in the hand
	 * @return smallest value Card
	 */
	public T removeSmallest();
	
	/**
	 * Get the sum of all the points from all the Cards
	 * in the hand
	 * @return sum of points of Cards in the hand
	 */
	public int getTotalScore();
	
	
	/**
	 * Get a comma separated list of the display
	 * values of all the the Cards in the hand
	 * 
	 * IMPORANT: this list MUST return sorted
	 * high to low.  Face cards/10's must be first, 
	 * and aces should be last.
	 * 
	 * @return
	 */
	public String toString();
	
}
