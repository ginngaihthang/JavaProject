package day17;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reading_1 {

	public static void main(String[] args) {
		Path path = Path.of("src/day17/employee.txt");
		
		try(Stream<String> data = Files.lines(path,StandardCharsets.UTF_8)) {
			List<String> names = data
									.filter(str -> str.contains("Aung"))
									.collect(Collectors.toList());
			System.out.println(names);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
