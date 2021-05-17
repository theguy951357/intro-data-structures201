package edu.unca.csci202;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		PPMImage img1;
		while (true) {
		
			System.out.println("Gimme a file name: ");
		
			try {
				img1 = new PPMImage(scan.nextLine());
				break;
			} catch (FileNotFoundException e ) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("That file does not exist");
			} catch(FileMismatchException m) {
				System.out.println("That file is not a ppm format");
			}
		}
		
		img1.rotate();
		System.out.println("what do you want the output file to be named? ");
		img1.write(scan.nextLine());
		
		
		
	}

}
