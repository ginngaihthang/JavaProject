package day12;

public class Futional_Interface {

	public static void main(String[] args) {
		Interface1 myInterface2 = new Interface1() {
			
			@Override
			public void display(String name) {
				// TODO Auto-generated method stub
				System.out.println(name);
			}
		};
		myInterface2.display("Aung Aung");
		Interface1 myInterface3 = (str) -> System.out.println(str);
		myInterface3.display("Cherry");
		
		Interface3 test = (name,pass) -> {
			if(name.equals("jeon") && pass.equals("123")) 
				return true;
			else
				return false;
		};
		
		System.out.println(test.checkLogin("jeon" , "123")? "Login Success" : "Invalid");
		System.out.println(test.checkLogin("ngaih" , "123")? "Login Success" : "Invalid");
		
		Interface2 sum = (a, b) -> a + b;
		Interface2 mul = (a, b) -> a * b;
		Interface2 div = (a, b) -> a / b;
		
		System.out.println("Sum: " + sum.operate(100,50));
		System.out.println("Mul: " + mul.operate(100,50));
		System.out.println("Div: " + div.operate(100,50));
	}
}
