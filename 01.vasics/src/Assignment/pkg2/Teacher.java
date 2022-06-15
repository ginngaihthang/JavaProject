package Assignment.pkg2;

public class Teacher extends Person{
	String position;
	String department;
	int salary;
	Teacher() {
		
	}
	Teacher(String name, String nrc, String address, String phone, String position, String department, int salary) {
		super(name,nrc,address,phone);
		this.position = position;
		this.department = department;
		this.salary = salary;
	}
	void setPosition(String position) {
		this.position = position;
	}
	String getPosition() {
		return position;
	}
	
	void setDepartment(String department) {
		this.department = department;
	}
	String getDepartment() {
		return department;
	}
	
	void setSalary(int salary) {
		this.salary = salary;
	}
	int getSalary() {
		return salary;
	}
	
	void Promote(String _position, int _salary) {
		this.position = _position;
		this.salary = _salary;
	}
	void Transfer(String depart) {
		this.department = depart;
	}
	void TeacherInfo() {
		System.out.println("Name -> " + super.name);
		System.out.println("NRCNO -> " + super.nrc);
		System.out.println("Address ->  " + super.address);
		System.out.println("Phone -> " + super.phone);
		System.out.println("Position -> " + position);
		System.out.println("Department -> " + department);
		System.out.println("Salary -> " + salary);
	}
}
