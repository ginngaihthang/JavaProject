package day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayList_2 {
	
	public static void main(String[] args) {
		String[] data= {"Aung Aung", "Jeon", "Yuki","Maung Maung"};
		
		var list = new ArrayList<>(Arrays.asList(data));
		
		list.add("Jeon");
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println("After sort: " + list);
		
		Collections.reverse(list);
		System.out.println("After sort: " + list);
		
		int result = Collections.binarySearch(list, "Jeon");
		//System.out.println((result < 0) ? "Not found" : "Found");
		System.out.println(result);
		
		result = Collections.binarySearch(list, "abc");
		System.out.println((result < 0) ? "Not found" : "found");
		
		if(list.contains("Yuki"))
			System.out.println("Yuki is found");
		
		list.remove("Jeon");
		System.out.println("After remove: " + list);
		
		list.removeIf((str) -> str.endsWith("ung") && str.length() > 9);
		System.out.println("After reomove: " + list);
		
	}
}
