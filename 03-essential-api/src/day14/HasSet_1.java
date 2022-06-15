package day14;

import java.util.HashSet;
import java.util.Set;

public class HasSet_1 {

	public static void main(String[] args) {
		HashSet<String> set1 = new HashSet<>();
		set1.add("Orange");
		set1.add("Apple");
		set1.add(null);
		set1.add("Mango");
		set1.add("Strawbeery");
		
		
		System.out.println(set1);
		set1.remove("Apple");
		System.out.println(set1);
		
		Set<String> set2 = Set.of("Potato","Pineapple");
		set1.addAll(set2);
		System.out.println(set1);
		
	}
}
