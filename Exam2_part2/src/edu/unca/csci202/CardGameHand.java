/**
 * 
 */
package edu.unca.csci202;



/**
 * 
 * This is the class for the Card game hand.
 * @author chris blaha
 * @version 1.0
 *
 */
public class CardGameHand<T> implements HandOfCards<Card> {

	/**
	 * 
	 * this is a private class for the nodes.
	 * @author cblah
	 *
	 * @param <T>
	 */
	private class Node<T>{
		Node<T> next;
		Node<T> prev;
		Card data;
	}
	
	Node<T> head;
	int count;
	private int total;
	
	
	/**
	 * this is a constructor that sets the count to 0 and the head to null
	 * @param head
	 * @param count
	 */
	public CardGameHand() {
		this.head = null;
		this.count = 0;
	}

	/**
	 *This adds a card to the hand in order.
	 *it keeps putting one card out of order
	 */
	@Override
	public void add(Card card) {
		
		Node<T> temp = new Node<T>();
		temp.data = card;
		this.total+=temp.data.getPoints();
		Node<T> current = this.head;
		Node<T> trailing;
		
		if(this.count==0) {
			this.head=temp;
		}else {
			if(this.count == 1) {
				if(current.data.compareTo(card)<0) {
					this.head.next=temp;
					temp.prev=this.head;
				}else {
					
					temp.next=this.head;
					this.head=temp;
					//temp.prev=null;
					temp.next.prev=temp;
					
				}
			}else {
					while(current.next!=null&&current.data.compareTo(card)<0) {
						
						trailing=current;
						trailing.next=current.next;
						current=current.next;
						current.prev=trailing;
						
					}
					if(current.next!=null) {
						if(current.prev==null) {
							
							temp.next=this.head;
							//temp.prev=null;
							this.head=temp;
							
							this.head.next.prev=temp;
							
						}else {
							current.prev.next=temp;
							temp.next=current;
							temp.prev=current;
						}
					}else {
						current.next=temp;
						temp.prev=current;
						temp.next=null;
					}

					
				}
			}
		if(this.head.prev!=null) {
			this.head.prev=null;
		}
		count++;
		
	}

	/**
	 *this allows you to peek at the smallest card in the hand.
	 *@return returns the head data which is the smallest card.
	 */
	@Override
	public Card peekSmallest() {
		
		return this.head.data;
	}

	/**
	 *This removes the first element in the hand which is the smallest card.
	 *@return returns the card that was removed.
	 */
	@Override
	public Card removeSmallest() {
		total-=this.head.data.getPoints();
		Card temp = this.head.data;
		this.head=this.head.next;
		this.head.prev=null;
		count--;
		
		return temp;
	}

	/**
	 *This gets the total score.
	 *@return returns the total score of the players hand.
	 */
	@Override
	public int getTotalScore() {
		
		return this.total;
	}

	/**
	 *a string representation of the hand
	 *@return returns the string representation of the hand
	 */
	@Override
	public String toString() {
		Node<T> current = this.head;
		String nodeString = "";
		while(current != null) {
			nodeString += current.data;
			current = current.next;
		}
		return "CardGameHand [ "+ nodeString + " ]";
	}

	
	
	

}
