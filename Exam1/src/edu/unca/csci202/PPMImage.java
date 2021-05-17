package edu.unca.csci202;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PPMImage {
	
	private Pixel[][] original;
	private Pixel[][] flipped;
	private Scanner scan;
	private int width, height,max, red, green ,blue;
	private FileWriter fw;
	private BufferedWriter bw;
	private PrintWriter output;
	
	
	
	public PPMImage(String fileName) throws FileNotFoundException, FileMismatchException {
		//checks to make sure the file entered is a ppm format, then generates a 2d array of pixels.
		
		//this.fileName = fileName;
			scan = new Scanner(new FileReader(fileName));
			if(!scan.nextLine().equals("P3")) {
				throw new FileMismatchException();
				
			}else {
				
				while(scan.hasNext()) {
					if (scan.hasNextInt()) {
						if(this.width == 0 && this.height==0) {
							this.width = scan.nextInt();
							this.height = scan.nextInt();
							this.max = scan.nextInt();
							this.original = new Pixel[this.height][this.width];
						}else {
							for(int i = 0; i<this.original.length; i++) {
								for(int j = 0; j < this.original[i].length; j++) {
									this.red = scan.nextInt();
									this.green = scan.nextInt();
									this.blue = scan.nextInt();
									if(!(this.red <= this.max)) {
										this.red = 255;
									}else if(!(this.green <= this.max)) {
										this.green = 255;
									}else if(!(this.blue <= this.max)) {
										this.blue = 255;
									}
									
									this.original[i][j]= new Pixel(this.red,this.green,this.blue);
									
								}
							}
						}
					}else {
						scan.nextLine();
						
					}
				}	
			}
	} 
	
	
	
	
	public void rotate(){
		//makes a 2d array with the pixels rearranged so the image is rotated 90 degrees
		this.flipped = new Pixel[this.width][this.height];
		for(int i = 0; i < this.original.length; i++) {
			for(int j = 0; j< this.original[i].length; j++) {
				this.flipped[j][i]=this.original[this.original.length-1-i][j];
			}
		}
	}


	
	
	
	public void write(String userInput) {
		//writes the rotated 2d array to a new ppm file
		try {
			this.fw = new FileWriter(userInput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bw = new BufferedWriter(fw);
		this.output = new PrintWriter(bw);
		System.out.println("writing to " +userInput);
		this.output.print("P3\n" +this.height + " " + this.width + "\n" + this.max + "\n");
		for(int i = 0; i< this.flipped.length; i++) {
			for(int j = 0; j < this.flipped[i].length; j++) {
				this.output.print(this.flipped[i][j].toString());
			}
		}
		
		System.out.println("printed to " +userInput);
		this.output.close();
	}
}
