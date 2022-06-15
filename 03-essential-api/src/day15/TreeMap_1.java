package day15;

import java.util.TreeMap;

public class TreeMap_1 {

	public static void main(String[] args) {
		var file_extensions = new TreeMap<String, String>();
		
		file_extensions.put("java", ".Java");
		file_extensions.put("php", ".php");
		file_extensions.put("c++", ".c++");
		file_extensions.put("html", ".html");
		file_extensions.put("javascript", ".js");
		
		System.out.println(file_extensions);
		file_extensions.remove("c++");
		System.out.println(file_extensions);
	}
}
