package Assignment.pkg4;

public class Cube implements Shape{
	int x;
	
	public Cube(int x) {
		this.x = x;
	}
	@Override
	public double Area() {
		System.out.println("Area of Cube -> " + 6*x*x);
		return 6*x*x;
	}

	@Override
	public double Volume() {
		System.out.println("Volume of Cube -> " + x*x*x);
		return x*x*x;
		
	}
	
	
}
