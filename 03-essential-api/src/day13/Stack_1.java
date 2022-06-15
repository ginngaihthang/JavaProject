package day13;

import java.util.Stack;

public class Stack_1 {
	public static void main(String[] args) {
		var cities = new Stack<>();
		
		cities.push("Yangon");
		cities.push("Mandalay");
		cities.push("Pyin Oo Lwin");
		
		System.out.println(cities);
		
		
		cities.pop();
		System.out.println(cities);
		
	}
}
