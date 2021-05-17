package edu.unca.csci202;

public class Car extends MotorVehicle  {
	
	private Person owner;

	public Car(String make, String model, int year) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.odometer=0;
		this.owner = null;
		
	}
	
	

	@Override
	public void purchase(Person owner) {
		// TODO Auto-generated method stub
		
		this.owner = owner;
		
	}



	public Person getOwner() {
		return owner;
	}



	public void setOwner(Person newOwner) {
		this.owner = newOwner;
	}



	@Override
	public void drive(int miles) throws MotorVehicleEcxeption {
		// TODO Auto-generated method stub
		
		if(this.owner ==  null) {
			//raise exception
			throw new MotorVehicleEcxeption("This car is not owned. can not drive it yet");
		}
		this.odometer+=miles;
		
	}



	@Override
	public String toString() {
	
		if(this.owner == null) {
			return  this.year + " " + this.make + " " + this.model + " (" + this.odometer + " miles) is unowned";
		}else {
			return  this.year + " " + this.make + " " + this.model + " (" + this.odometer + " miles) is owned by "+this.owner.getName();
		}
		
	}
	
	
	
	

}
