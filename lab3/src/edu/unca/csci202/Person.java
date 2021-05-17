package edu.unca.csci202;

public class Person {

	private String name;
	private int age;
	private double height;
	private String eyeColor;
	private String location;
	
	

	public Person(String name,int age,double d, String eyeColor) {
		
		this.name = name;
		this.age = age;
		this.height = d;
		this.eyeColor = eyeColor;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public double getHeight() {
		return height;
	}



	public void setHeight(float height) {
		this.height = height;
	}



	public String getEyeColor() {
		return eyeColor;
	}



	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	@Override
	public String toString() {
		//return "Person [name=" + name + ", age=" + age + ", height=" + height + ", eyeColor=" + eyeColor + "]";
		return this.name + " (age " + this.age + ") is " + this.height + " tall, and has " + this.eyeColor + " eyes.";
	}



	
	
	

}
