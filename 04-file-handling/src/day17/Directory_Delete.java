package day17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Directory_Delete {

	public static void main(String[] args) throws IOException {
		Path path = Path.of("./test");
		System.out.println(Files.deleteIfExists(path) ? "Deleted" : "Fail");
	}
}
