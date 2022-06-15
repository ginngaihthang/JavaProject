package Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayList_Assignment {
	
	public static void main(String[] args) {
		String[] data = {"Mg Mg", "Aung Aung", "Tun Tun", "Kyaw Kyaw"};
		ArrayList<String> list1 = new ArrayList<>(Arrays.asList(data));
		//Show all the student names
		list1.forEach((Str) -> System.out.println("Name: " + Str));
		
		//Sort the list
		Collections.sort(list1);
		
		//Show the soted list
		System.out.println(list1);
		
		//Scarch the specified student and show his position in the list
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter student name to search: ");
		String name = sc.nextLine();
		int result = Collections.binarySearch(list1, name);
		System.out.println((result < 0) ? "Not Found " : "Found\n The student name found in Index-> " + result);
		
		//Insert the new Student name if it is not already included in the list
		System.out.print("\nInsert the new Student name: ");
		String name1 = sc.nextLine();
		if(!list1.contains(name1)) {
			list1.add(name1);
			System.out.println(list1);
		}
		else {
			System.out.println("Insert Student name already exist");
		}
		
		//Show the students whose name starts with 'K' or 'k'
		list1.forEach((Name) ->{
			
			if( Name.startsWith("K") || Name.startsWith("k")  ) {
				System.out.println("Name that is Satrt with K or k-> " +Name);
			}
		});
	
		//Remove the students whose name ends with 'G' or 'g' show the list
		System.out.println("\nPlease Student whose name ends with 'G' or 'g': ");
		System.out.println("Enter 'G' or 'g': ");
		String name3 = sc.next();
		boolean Name3 = list1.removeIf((Name1) ->  Name1.endsWith(name3));
		if(Name3) {
			System.out.println("The student whose name end with G or g-> " + list1);
		}
		else {
			System.out.println("The student whose name end with G or g is not exist!");
		}
		
		//Clear the list
		list1.clear();
		System.out.println("After clear all the students-> "+list1);
		
			
	}
}
