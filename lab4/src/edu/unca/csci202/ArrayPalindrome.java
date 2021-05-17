package edu.unca.csci202;

public class ArrayPalindrome {
	
	/**
	 * class will take an ArrayStack and pop each element
	 */
	private ArrayStack<Character> check;
	private ArrayStack<Character> forward;
	private ArrayStack<Character> backward;
	
	/**
	 * Constructor makes three new instances of ArrayStack:
	 * one to check against backwards,
	 * one to fill with forward,
	 * and one to pop off of forward and push onto backward.
	 */
	public ArrayPalindrome() {
		this.check = new ArrayStack<Character>();
		this.forward = new ArrayStack<Character>();
		this.backward = new ArrayStack<Character>();
	}
	
	
	/**
	 * Takes a string and fills the check and forward ArrayStack instances, char by char.
	 * Then pops chars off of forward and pushes them to backward to make the word backwards.
	 * Then pop items off of backwards and check and compares each char to see if it is a palindrome.
	 * 
	 * @param word
	 * @return true if word is a palindrome,or false if not.
	 */
	public boolean isPalindrome(String word) {
		
		//found on stack overflow. replace all non word characters and make all letters lower case.
		String justWord = word.replaceAll("[\\W]", "").toLowerCase();
		
		clear();
		
		for(int i = 0; i < justWord.length(); i++) {
			
			
			
//			if(word.charAt(i)== ' ') {
//				continue;
//			}
			check.push(justWord.charAt(i)); //fills check with word
			forward.push(justWord.charAt(i)); //fills forward with word
		}
		
		while(! forward.isEmpty()) {
			backward.push(forward.pop()); //fills backward with word in reverse order.
		}
		
		while(! check.isEmpty()) {
			if(check.peek()!=backward.peek()) {
				System.out.println("\"" + word + "\"" + " is not a palindrome\n");
				
				return false;
			}else {
				check.pop();
				backward.pop();
			}
		}
		
		System.out.println("\"" + word + "\"" + " is a palindrome\n");
		return true;
	}
	
	public void clear() {
		while(!check.isEmpty()) {
			check.pop();
		}
		
		while(!forward.isEmpty()) {
			forward.pop();
		}
		
		while(!backward.isEmpty()) {
			backward.pop();
		}
	}
	
	public static void main(String args[]) {
		
		ArrayPalindrome test = new ArrayPalindrome();
		test.isPalindrome("lionoil");
		test.isPalindrome("");
		test.isPalindrome("race                car");
		test.isPalindrome("giggity");
		test.isPalindrome("the end");
		test.isPalindrome("saippuakivikauppias");
		test.isPalindrome("Sir, I demand, I am a maid named Iris.");
		
		
	}
	

}
