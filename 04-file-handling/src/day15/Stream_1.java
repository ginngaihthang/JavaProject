package day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Stream_1 {

	public static void main(String[] args) {
		int[] prices = {1700, 100,3000, 4000, 1600, 1200,400,7900};
		
		//create stream
		IntStream streams = Arrays.stream(prices);
		
		streams.filter(p -> p > 1500)
				.sorted()
				.forEach(p -> System.out.println(p));
		
		System.out.println("----- Withor Stream API ------");
		
		var new_datas = new ArrayList<Integer>();
		
		//filter
		for(var p : prices ) {
			if(p > 1500) 
				new_datas.add(p);
		}
		//sort
		Collections.sort(new_datas);
		for(var p : new_datas) {
			System.out.println(p);
		}
		
	}
}
