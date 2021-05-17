package edu.unca.csci202;

import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	private static Scanner scan;



	
	public static void main(String[] args) {
		// asks for number of files and data points
		
		int numFiles = 0;
		int data = 0;
		int sum;
		DecimalFormat df = new DecimalFormat("00");
		
		numFiles = generateThing(numFiles, "files");
		data = generateThing(data, "data points");
		//System.out.println(numFiles +" " + data);
		
		DataFileFactory dff = new DataFileFactory(numFiles, data);
		try {
			dff.writeFiles(0.25);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		int[][] files = new int[numFiles][data];
		FileReader fr = null;
		
		
		
		System.out.println("\nhere are your files.");
		
		
		
		//prints out the array while creating it.
		for(int i = 0; i<files.length; i++) {
			
			try {
				scan = new Scanner(fr = new FileReader(dff.getFileName(i)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("you got no files.");
				e.printStackTrace();
				
			}
			for(int j = 0; j < files[i].length; j++) {
				try {
					files[i][j] = Integer.parseInt(scan.nextLine());
				}catch(NumberFormatException e) {
					
				}
				if(j == files[i].length -1) {
					System.out.print(df.format(files[i][j]) + " ");
					//System.out.print(files[i][j] + " ");
				}else {
					System.out.print(df.format(files[i][j]) + ", ");
					//System.out.print(files[i][j] + ", ");
				}
				
				
			}
			System.out.println();
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		//gets the sum of the columns
		System.out.println();
		for(int k = 0; k < data; k++) {
			sum = 0;
			for( int l = 0; l< numFiles; l ++) {
				sum += files[l][k];
			}
			
			System.out.println("The sum of column "+k+ " = " +sum);
		}
		
		System.out.println();
		dff.removeFiles();
		
		
	}
	
	
	
	public static int generateThing(int number, String type) {
		scan = new Scanner(System.in);
		String userInput;
		//asks how many of something you want and checks to see if it is a number greater than 0.
		do {
			System.out.println("How many "+type+" would you like? ");
			userInput = scan.nextLine();
			try {
				number = Integer.parseInt(userInput);
			}catch(NumberFormatException e) {
				System.out.println("That is not a number");
			}
			
			if(number <=0) {
				System.out.println("Please pick a number greater than 0");
			}
		}while(number == 0);
	
		return number;
	}
	

}
