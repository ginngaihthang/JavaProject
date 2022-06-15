package day12;

public class InterfaceChanges {
	
	public static void main(String[] args) {
		Myclass obj = new Myclass();
		obj.method1();
		obj.method2();
		InterfaceTest.method3();
	}
}
interface InterfaceTest {
	void method1();
		
	public default void method2() {
		System.out.println("Add new method.It can be overriden");
		
	}
	public static void method3() {
		System.out.println("Add new static method .It cannot be override");
	}
	
}

class Myclass implements InterfaceTest {

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}
	public void method2() {
		System.out.println("Default method is override");
	}
	
}