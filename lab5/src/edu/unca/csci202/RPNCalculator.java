package edu.unca.csci202;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author cblah
 * @version 1.0
 *A reverse Polish notation calculator that reads the numbers first before the operator.
 */

public class RPNCalculator {
	
	//instance variable
	private LinkedStack<Double> calcStack;
	
	/**
	 * Prompts the user
	 * sets a string for the program to interpret
	 * sets a boolean for quit.
	 * Runs the program continuously until a "q" is entered by the user.
	 */
	
	private void run() {
		Scanner input = new Scanner(System.in);
		String line = "";
		boolean quit = false;
		
		while(!quit) {
			while(line.equals("")){
				System.out.print(":::> ");//output prompt
				line = input.nextLine().trim();
			}
			quit = interpretResult(line);
			printResult(quit);
			line="";
		}
	}
	
	/**
	 * This prints the results from the interpretResults method and either prints the stack which should be the answer to the equation, or "program ended" if a q is found.
	 * If the size of the stack is greater than 1. that means there are extra numbers left over.
	 * The equation was not entered properly an informs the user that too many operands were entered.
	 * 
	 * @param quit
	 */

	private void printResult(boolean quit) {
		// TODO Auto-generated method stub
		if(quit) {
			System.out.println("program ended");
		}else {
			if(calcStack.size()>1) {
				System.out.println("invalid input: too many operands");
				
				clear();
				calcStack.push(Double.NaN);
			}
				System.out.println(calcStack);
			
		}
	}

	/**
	 * 
	 * This interprets the input from the user and applies the appropriate operator to the equation.
	 * If a q is entered. then the boolean "quit" becomes true and the program ends. 
	 * By default, the method pushes the numbers to the stack.
	 * 
	 * @exception NumberFormatException if the input is anything other than a number or an operator.
	 * @param line
	 * @return true if "q" is entered and false otherwise.
	 */
	private boolean interpretResult(String line) {
		// TODO Auto-generated method stub
		calcStack = new LinkedStack<Double>();
		String[] arr = line.split(" ");
		String index;
		double op1, op2, num;
		
		//System.out.println(Arrays.toString(arr));
		
		for(int i = 0; i<arr.length; i++) {
			
			switch(arr[i]) {
			case "+":
				
				op1=checkStack(calcStack);
				op2=checkStack(calcStack);
				calcStack.push(op2+op1);
				continue;
			case "-":
				op1=checkStack(calcStack);
				op2=checkStack(calcStack);
				calcStack.push(op2-op1);
				continue;
			case "*":
				op1=checkStack(calcStack);
				op2=checkStack(calcStack);
				calcStack.push(op2*op1);
				continue;
			case "/":
				op1=checkStack(calcStack);
				op2=checkStack(calcStack);
				calcStack.push(op2/op1);
				continue;
			case "q":
				return true;
					
			default:
				try {
					num = Double.parseDouble(arr[i]);
					calcStack.push(num);
				}catch(NumberFormatException e) {
					clear();
					System.out.println("invalid input: unrecognized character");
					
					calcStack.push(Double.NaN);
					return false;
				}
				
				
			}
			
		}
		return false;
		
		
	}
	
	/**
	 * checks to see the if the stack is empty.
	 * If it is empty, then there is an operator trying to run on an operand that is not there.
	 * @exception catches Empty collection exception if there is no number to operate on.
	 * @param stack
	 * @return stack.pop if it finds a number and Double.NaN if there is not.
	 */
	public double checkStack(LinkedStack<Double> stack) {
		try {
			stack.peek();
		}catch(EmptyCollectionException e) {
			System.out.println("invalid input: not enough operands");
			clear();
			return Double.NaN;
		}
		
		return stack.pop();
	}
	/**
	 * Clears the stack when an exception is caught.
	 */
	public void clear(){
		while(!calcStack.isEmpty()) {
			calcStack.pop();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RPNCalculator calc = new RPNCalculator();
		calc.run();
	}

}
