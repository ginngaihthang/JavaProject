package Assignment.pkg6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Map_list {

	public static void main(String[] args) {
		Map<Integer,Studentlist> student = new HashMap<>();
		student.put(1,  new Studentlist(1001, "Aung Aung", "Yangon"));
		student.put(2, new Studentlist(1002, "Kyaw Kyaw", "Mandalay"));
		student.put(3, new Studentlist(1003, "Moe Moe", "Pyin Oo Lwin"));
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a new student rno: ");
		int rno = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter a new student name: ");
		String name = sc.nextLine();
		
//		System.out.println(student);
		student.forEach((k, v) -> {
			if(!v.getName().equals(name)) {
				System.out.print("Enter a new student city: ");
				String city = sc.nextLine();
				student.put(4, new Studentlist(rno, name, city));
			}
		});
		

		
	}
}
