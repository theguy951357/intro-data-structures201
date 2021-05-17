package edu.unca.csci202;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("Chris Blaha",38,5.8,"hazel");
		System.out.println(p1.toString());
		
		Person p2 = new Person("Dracula",500,5.1,"red");
		Person p3 = new Person("james",12,6.11,"orange");
		
		System.out.println(p2.toString());
		System.out.println(p3.toString());
		
		Car c1 = new Car("Honda", "Civic", 2001);
		Car c2 = new Car("Tesla", "Cybertruck", 2022);
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		
		try {
			c1.drive(10);
		} catch (MotorVehicleEcxeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		
		try {
			c2.drive(500);
		} catch (MotorVehicleEcxeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		
		c1.purchase(p1);
		c2.purchase(p2);
		try {
			c1.drive(10);
		} catch (MotorVehicleEcxeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		
		try {
			c2.drive(500);
		} catch (MotorVehicleEcxeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
	}

}
