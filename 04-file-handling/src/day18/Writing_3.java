package day18;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Writing_3 {

	public static void main(String[] args) {
		Path path = Path.of("src/tester.txt");
		try(BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write("HTML,Javascript,Css");
			writer.write("C++");
			writer.write("\nDatabase");
			writer.newLine();
			writer.write("Python");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
