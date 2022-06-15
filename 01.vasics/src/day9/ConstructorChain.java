package day9;

public class ConstructorChain {
	public ConstructorChain() {
		this(7);
		System.out.println("This is defalut constructor");
	}
	public ConstructorChain(int i) {
		this(7,9);
		System.out.println(i);
	}
	public ConstructorChain(int i , int j) {
		System.out.println("i =" +i + "j =" + j);
	}
}
