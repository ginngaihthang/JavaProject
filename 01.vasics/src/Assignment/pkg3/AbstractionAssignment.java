package Assignment.pkg3;

public abstract class AbstractionAssignment {
	private String color;
	void setColor(String color) {
		this.color = color;
	}
	String getColor() {
		return color;
	}
	void dataShow() {
		System.out.println("Color -> " + color);
	}
	//abstract
	public abstract double Area();
	
}
