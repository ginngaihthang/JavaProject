package day15;

import java.util.Comparator;
import java.util.List;

public class Reduction_1 {

	public static void main(String[] args) {
		List<Employee> employees = List.of(
				new Employee("Kyaw Kyaw", 9800, "Yangon"),
				new Employee("Aung Aung", 6000, "Mandalay"), 
				new Employee("Mg Mg", 10000, "Mandalay"),
				new Employee("Yuri", 6000, "Yangon"), 
				new Employee("Jeon", 7800, "Monywa")
				);
			
				int total = employees.stream().mapToInt(Employee::getSalary).sum();
				double avg = employees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
				int max = employees.stream().mapToInt(e -> e.getSalary()).max().getAsInt();
				long count = employees.stream().filter(e -> e.getSalary() > 6000).count();
				Employee empMax = employees.stream().max(Comparator.comparingInt(e -> e.getSalary())).get();
				Employee empMin = employees.stream().min((e1,e2) -> e1.getSalary() - e2.getSalary()).get();
		
				
				
				System.out.println("Total Salary: " + total);
				System.out.println("Average salary: " + avg);
				System.out.println("Maximun salary: " + max);
				System.out.println("Count: " + count);
				System.out.println("Employee got max salary" + empMax);
				System.out.println("Employee got min salary" + empMin);
				
				//custom reduction(use redce method
				
				int total_2 = employees.stream()
									.map(emp -> emp.getSalary())
									.reduce(0, (s1,s2) -> s1+s2);
				int min_sal = employees.stream()
									.mapToInt(emp -> emp.getSalary())
									.reduce(Integer::min)
									.getAsInt();
				empMax = employees.stream()  
								.reduce((e1, e2) -> e1.getSalary() < e2.getSalary() ? e2 : e1)
								.get();
				System.out.println("Total salary: " + total_2);
				System.out.println("Min Salary: "+ min_sal);
				System.out.println("Employee got max salary: " + empMax);
				
	}
}
