package Assignment.pkg6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Set_list {

//	public static Comparator<Studentlist> sortbyname = new Comparato<Studentlist>() {
//		public int compare(Studentlist s1,Studentlist s2) {
//			String studName1 = s1.getName().toUpperCase();
//			String studName2 = s2.getName().toLowerCase();
//			
//			return studName1 = s1.getName().compareTo(studName2);
//		}
//	};
	public static void main(String[] args) {
		HashSet<Studentlist> studentSet = new HashSet<>();
		Studentlist student1 = new Studentlist(1001, "Aung Aung", "Yangon");
		Studentlist student2 = new Studentlist(1002, "Kyaw Kyaw", "Mandalay");
		Studentlist student3 = new Studentlist(1003, "Moe Moe", "Pyin Oo Lwin");
		studentSet.add(student1);
		studentSet.add(student2);
		studentSet.add(student3);
		List<Studentlist> stu = new ArrayList<>();
		stu.add(student1);
		stu.add(student2);
		stu.add(student3);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a new student rno: ");
		int rno = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter a new student name: ");
		String name = sc.nextLine();
		
		int result = -1;
		for(var na : studentSet) {
			if(na.getName().equals(name)) {
				result = 1;
				System.out.println("Student name is already exist!");
				break;
			}
		}
		if(result == -1) {
			System.out.print("Enter a new student city: ");
			String city = sc.nextLine();
			studentSet.add(new Studentlist(rno, name, city));
		}
		
//		stu.sort((s1, s2) -> {
//			return s2.getRno() - s1.getRno();
//		});
		
//		stu.sort(Comparator.comparingInt(Studentlist::getRno));
		
		Collections.sort(stu, Comparator.comparing(Studentlist::getName));
		System.out.println(stu);
		
		System.out.println("Sort name");
		List<String> sortname = studentSet.stream()
										.map(s -> s.getName())
										.sorted()
										.toList();
		System.out.println(sortname);
	
		// Display all
		System.out.println("\nRoll\t Name\t City");
		studentSet.forEach(str -> {
			System.out.print(str.getRno() + "\t");
			System.out.print(str.getName() + "\t");
			System.out.print(str.getCity() + "\n");
		});
		
		
		//update student
		System.out.print("\nEnter student rno to update: ");
		int updateid = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter sutdent name to update: ");
		String updatename = sc.nextLine();
		System.out.print("Enter student city to update: ");
		String updatecity = sc.nextLine();
		if(updateid != student3.getRno()) {
			student3.setRno(updateid);
		}
		if(!updatename.equals(student3.getName())) {
			student3.setName(updatename);
		}
		if(!updatecity.equals(student3.getCity())) {
			student3.setCity(updatecity);
		}
		System.out.println("Roll\t Name\t City");
		studentSet.forEach(str -> {
			System.out.print(str.getRno() + "\t");
			System.out.print(str.getName() + "\t");
			System.out.print(str.getCity() + "\n");
		});
		
		List<Studentlist> obj = new ArrayList<Studentlist>(studentSet);
		// search student with roll no
		System.out.println("Enter student roll number ro search: ");
		int roll = sc.nextInt();
		int result1 = -1;
		for(int i =0; i < obj.size();i++) {
			if(obj.get(i).getRno() == roll) {
				System.out.println("Student roll -> " + roll);
				System.out.println("Student name -> " + obj.get(i).getName());
				System.out.println("Student city -> " + obj.get(i).getCity());
			}
			else {
				result1 = 1;
				break;
			}
		}
		if(result1 == 1) {
			System.out.println("Student roll does not exist!");
		}
		
		//remove student according to roll
		System.out.println("Enter student roll number to delete: ");
		int rolno = sc.nextInt();
		boolean num = obj.removeIf((str) -> (str.getRno() ==  rolno));
		if(num) {
			System.out.println("Roll\t Name\t City");
			obj.forEach(str -> {
				System.out.print(str.getRno() + "\t");
				System.out.print(str.getName() + "\t");
				System.out.print(str.getCity() + "\n");
			});
		}
		else {
			System.out.println("Student roll does not exist!");
		}
	}
}
