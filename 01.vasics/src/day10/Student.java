package day10;

public class Student extends Person{
	private int rno;
	
	public Student(int rno, String name, String phone) {
		super(name,phone);
		this.rno = rno;
	}
	public int getRno() {
		return rno;
	}
}
