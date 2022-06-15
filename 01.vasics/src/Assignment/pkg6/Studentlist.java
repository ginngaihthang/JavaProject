package Assignment.pkg6;

public class Studentlist implements Comparable<Studentlist>{
	private int rno;
	private String name;
	private String city;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Studentlist(int rno, String name, String city) {
		super();
		this.rno = rno;
		this.name = name;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Studentlist [rno=" + rno + ", name=" + name + ", city=" + city + "]";
	}
	@Override
	public int compareTo(Studentlist student1) {
		//this > student1 = +
		// this < student1 = -
		// this == student1 = 0
		if(this.getRno() > student1.getRno())
			return 1;
		else
			return -1;
		
	
	}
	
}
