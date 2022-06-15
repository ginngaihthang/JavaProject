package Assignment.pkg4;

public class Cricle implements Shape{
	int  r;
	Cricle(int r ) {
		this.r = r;
	}
	@Override
	public double Area() {
		System.out.println("Area of cricle -> " + 3.14*r*r );
		return 3.14*r*r;
	}

	@Override
	public double Volume() {
		// TODO Auto-generated method stub
		return 0;
	}

}
