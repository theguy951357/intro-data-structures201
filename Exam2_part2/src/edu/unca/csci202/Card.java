package edu.unca.csci202;
/**
 * DO NOT MODIFY THIS FILE
 * 
 * Interface to define a playing card in the card game *
 */
public interface Card extends Comparable<Card> {

	/**
	 * Printable string of the card
	 * @return display value of card
	 */
	public String toString();
	
	/**
	 * Get the number of points this card is worth
	 * @return points card is worth
	 */
	public int getPoints();
	
	/**
	 * Compare to another card
	 * @param card to compare to this card
	 * @return 0 if this object is worth the same number of 
	 * 		   points as the 'card' argument, a positive 
	 *         value (e.g. 1) if this object has more points
	 *         than the argument 'card', and negative 
	 *         (e.g. -1) if this object has fewer points 
	 *         than the 'card' argument.
	 */
	public int compareTo(Card card);
	
}
