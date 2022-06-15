package day13;

import java.util.List;

public class CollectionWithLamda {
	public static void main(String[] args) {
		List<String> list = List.of("Html","Css","Javaxcript","Php","Java");
		
		System.out.println("----- with lamda expression ------");
		list.forEach((str) -> System.out.println(str));
		
		
		list.forEach((str) -> {
			if(str.contains("Java"))
				System.out.println(str);
		});
	}
}
