package day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreatinList {

	public static void main(String[] args) {
		
		List<Integer> list1 = List.of();
		List<Integer> list2 = List.of(100, 200, 300);
		Integer[] data = {1, 2, 3, 4};
		List<Integer> list3 = Arrays.asList(data);
		
		//modified list
		List<String> list4  = new ArrayList<>();
		list4.add("Aung Aung");
		list4.add("Kyaw Kyaw");
		
		List<Integer> list5 = new ArrayList<>(Arrays.asList(data));
		list5.add(100);
		
		var list6 = new ArrayList<String>();
		list6.add("Su Su");
		list6.add("Mg Mg");
		
		System.out.println("list1: " + list1);
		System.out.println("list2: " + list2);
		System.out.println("list3: " + list3);
		System.out.println("list4: "+ list4);
		System.out.println("list5: " + list5);
	}
}
