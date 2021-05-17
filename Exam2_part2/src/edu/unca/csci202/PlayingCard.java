package edu.unca.csci202;
/**
 * Playing card class that implements Card interface
 * @author chris blaha
 * @version 1.0
 */
public class PlayingCard implements Card {

	private int points;
	private String display;
	private int thisval;
	private int cardval;
	
	
	
	/**
	 * Constructor sets the points and the card rank to the playing card.
	 * @param points
	 * @param display
	 */
	public PlayingCard(int points, String display) {
		this.points = points;
		this.display = display;
	}

	
	/**
	 *Method gets the points for the card.
	 *@return returns the points that the card is worth.
	 */
	@Override
	public int getPoints() {
		// TODO Auto-generated method stub
		return this.points;
	}

	/**
	 *This method compares this card to the card entered in the parameter.
	 *@param the card to be compared to this card.
	 *@return the result of the compareto method. (<0,==0,>0)
	 */
	@Override
	public int compareTo(Card card) {
		
		return this.getPoints()-card.getPoints();
	}

	/**
	 *The toString method
	 *@return returns a string representation of the Card.
	 */
	@Override
	public String toString() {
		return this.display;
	}

	
}
