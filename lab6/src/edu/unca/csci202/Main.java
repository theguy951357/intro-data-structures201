/**
 * 
 */
package edu.unca.csci202;

/**
 * main class for the LinkedDeque class
 * @author chris blaha
 *
 *@version 1.0
 */
public class Main {

	/**
	 * main method will make an instance of linkedDeque and do some things with it.
	 * the method will also make instances of Deque as a stack and a queue.
	 * @param args
	 */
	public static void main(String[] args) {
		// LinkedDeque
		
		LinkedDeque<String> strdq = new LinkedDeque<String>();
		char letter = 'A';
		
		for(int i = 0; i<10; i++) {
			strdq.addFirst(" " + Character.toString(letter)+ " ");
			letter++;
		}
		System.out.println("Add 10 characters to the front: "+strdq);
		System.out.println();
		
		for(int i = 0; i<5; i++) {
			strdq.removeLast();
		}
		System.out.println("remove 5 characters from the back: "+strdq);
		System.out.println();
		
		for(int i = 0; i<5; i++) {
			strdq.addLast(" " + Character.toString(letter)+ " ");
			letter++;
		}
		System.out.println("Add 5 characters to the front: "+strdq);
		System.out.println();
		
		for(int i = 0; i<10; i++) {
			strdq.addFirst(strdq.removeLast());
			System.out.println("Right shifted " + (i+1) + " times: " + strdq);
		}
		
		System.out.println();
		
		for(int i = 0; i<10; i++) {
			strdq.addLast(strdq.removeFirst());
			System.out.println("Left shifted " + (i+1) + " times: " + strdq);
		}
		System.out.println();
		
		System.out.println("the last element is: " + strdq.getLast());
		System.out.println();
	
	
		//Deque as a Stack
		StackADT<String> stack = new LinkedDeque<String>();
		letter = 'A';
		
		for(int i = 0; i<5; i++) {
			stack.push(" " + Character.toString(letter) + " ");
			letter++;
		}
		System.out.println("Here is the stack: " + stack);
		System.out.println();
		
		while(!stack.isEmpty()) {
			System.out.println("Popped element: "+stack.pop());
		}
		System.out.println();
		
		//Deque as a queue
		QueueADT<String> queue = new LinkedDeque<String>();
		letter = 'A';
				
		for(int i = 0; i<5; i++) {
			queue.enqueue(" " + Character.toString(letter) + " ");
			letter++;
		}
		System.out.println("Here is the queue: " + queue);
		System.out.println();
		
		while(!queue.isEmpty()) {
			System.out.println("Dequeued element: " + queue.dequeue());
		}
	}

}
