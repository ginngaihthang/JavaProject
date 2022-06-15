package day18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
	private int id;
	private String name;
	private String address;
	public Employee(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public Employee(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public static Employee getEmployeeFromLine(String line) {
		String[] data = line.split("\t");
		Employee emp = new Employee();
		emp.setId(Integer.parseInt(data[0]));
		emp.setName(data[1]);
		emp.setAddress(data[2]);
		
		return emp;
		
	}
}
public class Reading_1 {

	public static void main(String[] args) throws IOException {
		
		List<String> lines = Files.readAllLines(Path.of("src/day18/emplist.txt"));
		
		List<Employee> emplist = lines.stream()
									.map(Employee::getEmployeeFromLine)
									.collect(Collectors.toList());
		
		emplist.forEach(obj -> {
			System.out.println("Id - " + obj.getId());
			System.out.println("Name - " + obj.getName());
			System.out.println("Address - " + obj.getAddress());
			System.out.println("----------------");
		});
	}
}
