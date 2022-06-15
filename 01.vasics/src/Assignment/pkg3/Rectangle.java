package Assignment.pkg3;

public class Rectangle extends AbstractionAssignment{

	@Override
	public double Area() {
		System.out.println("Area of rectangle -> " + length*width);
		return length*width;
	}
	int length;
	int width;
	Rectangle(String color,int length, int width) {
		super.setColor(color);
		this.length = length;
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	
	
}
