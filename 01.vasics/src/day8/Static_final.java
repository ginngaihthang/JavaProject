package day8;

public class Static_final {
	public static void main(String[] args) {
		// accessing static data
		try {
			Employee emp1 = new Employee();
			emp1.initData("Aung Aung", 500000);
			Employee emp2 =new Employee();
			emp2.initData("Su Su",600000);
			Employee emp3 = new Employee();
			emp3.initData("Chery", 300000);
			//display
			emp1.showData();
			System.out.println("----------------------");
			emp2.showData();
			System.out.println("------------------------");
			emp3.showData();
			
			Employee emp4 = new Employee();
			emp4.initData("Naung Naung", 450000);
		} catch (AppException e) {
			System.err.println(e.getMessage());
		}
	}

}
class Employee {
	static int no_of_employee = 3;
	static int next_id =1;
	final int empId;
	static final float bonus = 2.5f;
	String name;
	int salary;
	
	Employee() throws AppException {
		if(next_id > no_of_employee) {
			throw new AppException("Sorry ! Limited number has been reached");
		}
		this.empId = next_id;
		next_id++;
		
	}
	void initData(String name,int salary) {
		this.name = name;
		this.salary = salary;
		
	}
	void changeDate(String edit_name, int edit_salary) {
		if(!name.equalsIgnoreCase(edit_name)) {
			this.name = edit_name;
		}
		if(salary != edit_salary) {
			this.salary = edit_salary;
		}
	}
	void showData() {
		System.out.println("Id: " + this.empId);
		System.out.println("Name: " + this.name);
		System.out.println("Salary: "+ this.salary);
	}
}
class AppException extends Exception{

	private static final long serialVersionUID = 1L;
	public AppException(String msg) {
		super(msg);
	}
}