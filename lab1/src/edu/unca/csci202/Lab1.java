package edu.unca.csci202;

import java.util.Scanner;

public class Lab1 {

	public static void main(String[] args) {
		// this method asks for a certain amount of numbers and gives you the average of those numbers.
		
		Scanner scan = new Scanner(System.in);
		
		final int number_of_questions = 10;
		double total = 0;
		int count = 0;
		int[] data = new int[number_of_questions];
		//asks for a number until the array is filled.
		while(count < data.length) {
			if(data.length - count == 1) {
				System.out.println("You have " + (data.length - count) + " number left to pick.");
			}else {
				System.out.println("You have " + (data.length - count) + " numbers left to pick.");
			}
			System.out.print("Please pick a number.");
			String userInput = scan.nextLine();
			try {
				int userValue = Integer.parseInt(userInput);
				//int conversion was successful.
				data[count] = userValue;
				count ++;
			}catch(NumberFormatException e) {
				//int conversion was not successful.
				System.out.println("That is not a number. please enter a number. ");
			}
			
			
		}
		
		for(int i = 0; i< data.length; i++) {
			total += data[i];
		}
		
		System.out.println("The average is: " + (total/data.length));
	}

}
