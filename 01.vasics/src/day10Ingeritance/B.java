package day10Ingeritance;

public class B extends A{
	int j;
	public B() {
		System.out.println("B's defaut constructor");
	}
	public B(int a, int b) {
		System.out.println("B's argument constructor");
	}
	public static void main(String[] args) {
		B obj1 = new B();
		B obj2 = new B(10,20);
	}
}
