package day10;

public class Person {
	private String name;
	protected String phone;
	
	public Person(String name,String phone) {
		this.name = name;
		this.phone = phone;
		
	}
	
	void Display() {
		System.out.println("Name - " + name);
		System.out.println("Phone -" + phone);
	}
}
