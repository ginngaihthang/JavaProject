package day2;

public class Java_Methods {
	
	int num1 = 10; // instance field
	static int num2 = 20;//static field
	
	public void instance_method() {
		System.out.println("num1 =" + num1);
		System.out.println("num2 = " + num2);
	}
	public static void static_method() {
		System.out.println("Num2 = " + num2);
		
	}
	public static void main(String[] args) {
		// con's access because num1 is instance data
		
		Java_Methods obj = new Java_Methods();
		
		obj.instance_method();
		
		Java_Methods.static_method();
	}
}
