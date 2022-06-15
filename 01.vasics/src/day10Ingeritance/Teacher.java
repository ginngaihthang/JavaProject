package day10Ingeritance;

public class Teacher  extends Person{
	private String position;
	public Teacher(String name , String pos) {
		super(name);
		this.position = pos;
	}
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("Position: " + position);
		
	}
	
		
}
