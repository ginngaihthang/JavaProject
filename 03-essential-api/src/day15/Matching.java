package day15;

import java.util.List;

public class Matching {

	public static void main(String[] args) {
		var numbers =List.of(2,4,6,8,10,11);
		var all_even = numbers.stream().allMatch(n -> n%2 == 0);
		
		System.out.println("all_enen : " + all_even);
		System.out.println(numbers.stream().anyMatch(n -> n%2 ==0));
		System.out.println( numbers.stream().noneMatch(n -> n%2 == 0));
		
		
		
	}
}
