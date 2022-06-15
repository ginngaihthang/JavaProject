package day5;

import java.util.Arrays;

public class String_Test {
	public static void main(String[] args) {
		String s1 = new String(new char[] {'Y','W','K'});
		String s2 = new String("Java Programming");
		System.out.println("s1: " + s1);
		System.out.println("s2: " + s2);
		System.out.println("Length of s2: " + s2.length());
		String substr = s2.substring(0, 4);
		System.out.println("substring1: " + substr);
		System.out.println("substring2: " + s2.substring(5));
		// replacing
		String result = s2.replace("Java", "PHP");
		System.out.println("replace: " + result);
		// concat
		result = s2.concat(" Language");
		System.out.println("concat: " + result);
		// finding
		System.out.println("Contain 'Java': " + s2.contains("Java"));
		System.out.println("Contain 'abc': " + s2.contains("abc"));
		System.out.println("End with 'ing': " + s2.endsWith("ing"));
		System.out.println("Start with 'abc': " + s2.startsWith("abc"));
		
		int index = s2.indexOf("a");
		System.out.println("index of 'a': " + index);
		System.out.println("last index of 'a': " + s2.lastIndexOf("a"));
		System.out.println("index of 'abc': " + s2.indexOf("abc"));
		String[] splits = s2.split(" ");
		System.out.println("Split: " + Arrays.toString(splits));
		char[] array = s2.toCharArray();
		System.out.println("Char Array: " + Arrays.toString(array));
		// converting string from any data type
		String rs = String.valueOf(array);
		System.out.println("From char array: " + rs);
		rs = String.valueOf(1000);
		System.out.println("From int: " + rs);
		rs = String.valueOf(true);
		System.out.println("From boolean: " + rs);

		
	}
}
