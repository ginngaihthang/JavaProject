package day10;

public class Cat extends Animal{
	void sound() {
		System.out.println("myaung");
	}
	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.show();
		cat.sound();
	}
}
