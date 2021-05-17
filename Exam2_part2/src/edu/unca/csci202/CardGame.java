package edu.unca.csci202;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
/**
 * DO NOT MODIFY THIS FILE
 * 
 * Class that defines the card game
 */
public class CardGame {
	
	private Queue<Card> drawPile;
	private Stack<Card> discardPile;
	
	
	public static void main(String[] args) {
		// ==== Testing ====
		Card c1 = new PlayingCard(1,"A" + "\u2660");
		System.out.println(c1);  // This should print: A♠
		Card c2 = new PlayingCard(2,"2" + "\u2661");
		System.out.println(c2);  // This should print: 2♡
		
		HandOfCards h = new CardGameHand();
		h.add(c1);
		h.add(c2);
		System.out.println(h);  // This should print:  A♠, 2♡
		
		
		// ==== Play the game ====
		Player[] players = new Player[2];
		players[0] = new Player("Player 1");
		players[1] = new Player("Player 2");
		
		CardGame game = new CardGame();
		game.run(players);
		
	}
	
	public CardGame() {
		drawPile = new ArrayDeque<Card>();
		discardPile = new Stack<Card>();
	}
	
	public void shuffleDeck() {
		System.out.println("======== Shuffling Deck ========");
		
		drawPile.clear();
		discardPile.clear();
		
		List<Card> unshuffled = new ArrayList<Card>();
		
		//String[] suits = {"Spades","Hearts","Diamonds","Clubs"};
		String[] suits = {"\u2660","\u2661","\u2662","\u2663"};
		String[] values = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		for(int v=0; v<values.length; v++) {
			for(int s=0;s<suits.length; s++) {
				//==================================================
				// Face cards are worth 10 points, aces worth 1 point.
				int points = Math.min(v+1, 10); 
				//==================================================
				// TODO: PlayingCard needs to be implemented
				Card card = new PlayingCard( points, values[v] + suits[s] );
				//==================================================
				unshuffled.add(card);
			}
		}
		System.out.println("Unshuffled["+ unshuffled.size() +"]:" + unshuffled );
		
		Random rand = new Random();
		while(unshuffled.size() > 0) {
			int index = rand.nextInt(unshuffled.size());
			Card card = unshuffled.remove(index);
			drawPile.add(card);
		}
		System.out.println("Shuffled["+ drawPile.size() +"]: " + drawPile);
		
	}
		
	public void run(Player[] players) {
		
		int round = 0;
		
		shuffleDeck();
		
		while(true) {
			System.out.println("======== Round " + round + " ========");
			for(int i=0; i<players.length; i++) {
				System.out.println("======== " + players[i] + "'s turn ========");
				System.out.println("Draw Pile: " + drawPile.size() + " cards");
				if(drawPile.size() == 0) {
					System.out.println("Out of cards, game over!");
					System.exit(0);
				}
				System.out.print("Discard Pile: "+ discardPile.size() + " cards");
				if(discardPile.size() > 0) {
					System.out.print(", " + discardPile.peek() + " on top");
				}
				System.out.println();
				
				if(round == 0) {
					players[i].drawInitalHand(drawPile);
				}
				
				players[i].takeTurn(drawPile, discardPile);
				
				if(players[i].hasWon()) {
					System.out.println("Winner: "+ players[i]);

					return;
				}
			}
			// End of round
			round++;
		}

	}

}
