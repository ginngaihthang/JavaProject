package day15;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Filtteringg {

	public static void main(String[] args) {
		Stream<Integer> numbers = Stream.iterate(1, i -> i +1)
										.limit(15);
		
		Predicate<Integer> evens = x -> x%2 == 0;
		
		numbers
				.filter(a -> a >= 4 && a <= 10)
				.filter(evens)
				.forEach(System.out::println);
			
	}
}
