package edu.unca.csci202;
import java.util.Queue;
import java.util.Stack;
/**
 * DO NOT MODIFY THIS FILE
 * 
 * Class that defines the card player
 */
public class Player {
	
	private int numberOfTurnsTaken;
	private HandOfCards<Card> hand;
	private String name;
	
	public Player(String name) {
		//===========================================
		// TODO: CardGameHand and PlayingCard must be implemented
		hand = new CardGameHand<PlayingCard>();
		//===========================================
		numberOfTurnsTaken = 0;
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public void drawInitalHand(Queue<Card> drawPile) {
		System.out.print("Initial draw: ");
		for(int i=0;i<5;i++) {
			Card drawn = drawPile.remove();
			System.out.print(drawn + ", ");
			hand.add(drawn);
		}
		System.out.println();
	}
	
	public void takeTurn(Queue<Card> drawPile, Stack<Card> discardPile){
		numberOfTurnsTaken++;
		System.out.println("Hand (before draw): "+ hand);
		boolean cardDrawn = false;
		if(discardPile.size() > 0) {
			Card lowest = hand.peekSmallest();
			if(discardPile.peek().compareTo(lowest) > 0) {
				Card drawn = discardPile.pop();
				System.out.println("\tDrew "+drawn+" from discard pile");
				hand.add(drawn);
				cardDrawn = true;
			}
		}
		// If a card was not drawn from the discard pile
		if(!cardDrawn) {
			Card drawn = drawPile.remove();
			System.out.println("\tDrew "+drawn+" from draw pile");
			hand.add(drawn);
		}
		System.out.println("Hand (after draw): "+ hand);
		// discard
		Card discard = hand.removeSmallest();
		System.out.println("Discarded "+discard);
		discardPile.push(discard);
		System.out.println("Hand (after discard): "+ hand);
	}
	
	public boolean hasWon() {
		int score =  hand.getTotalScore();
		System.out.println(this + "'s score is "+ score);
		if(score >= 50) {
			return true;
		}
		return false;
	}

}
