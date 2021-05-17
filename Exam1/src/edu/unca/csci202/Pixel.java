package edu.unca.csci202;

public class Pixel {
	
	private int red;
	private int green;
	private int blue;
	public Pixel(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	
	
	@Override
	public String toString() {
		return  + red + " " + green + " " + blue + "\n";
	}
	
	

}
