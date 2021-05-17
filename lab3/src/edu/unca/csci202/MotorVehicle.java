package edu.unca.csci202;

public abstract class MotorVehicle {
	protected int odometer;
	protected String make;
	protected String model;
	protected int year;
	

	

	public abstract void drive(int miles) throws MotorVehicleEcxeption;
	
	public abstract void purchase(Person person);
	
	public int getOdometer() {
		return odometer;
	}

	public void setOdometer(int odometer) {
		this.odometer = odometer;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	
}
