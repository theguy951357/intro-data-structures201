package giggity.goo;

public class ExceptionScope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		level1();

	}

	public static void level1() {
		System.out.println("Level 1 beginning.");
		
		try {
			level2();
		}catch(Exception problem) {
			System.out.println();
			System.out.println("The exception problem is " + problem.getMessage());
			System.out.println();
			System.out.println("The call stack trace: ");
			problem.printStackTrace();
			System.out.println();
		}
		
		System.out.println("level 1 ending");
	}
	
	public static void level2() {
		System.out.println("level 2 beginning");
		
		level3();
		System.out.println("level 2 ending");
	}
	
	public static void level3() {
		int numerator = 10, denominator = 0;
		
		System.out.println("level 3 beginning");
		int result = numerator/ denominator;
		System.out.println("level 3 ending");
		
	}
}
