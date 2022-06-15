package day14;

import java.util.LinkedHashMap;

public class LinkHashMap_1 {

	public static void main(String[] args) {
		var students = new LinkedHashMap<Integer, String>();
		
		students.put(1, "Aung Aung");
		students.put(11, "Kyaw Kyaw");
		students.put(5, "May");
		students.putIfAbsent(10, "Cherry");
		
		students.forEach((k, v) -> {
			System.out.println("Rno: " + k);
			System.out.println("Name: " + v);
			
		});
		
		
		students.replace(5, "May Oo Nay");
		System.out.println("[5]: " + students.get(5));
		
		students.remove(1);
		System.out.println(students);
	}
}
