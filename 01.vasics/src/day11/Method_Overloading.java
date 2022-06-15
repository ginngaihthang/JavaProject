package day11;

import java.util.Arrays;

public class Method_Overloading {
	public static void main(String[] args) {
		System.out.println("100 + 200" +  Addition.add(100,200));
		System.out.println("2.3 = 5.4 = " + Addition.add(2.3f, 5.4f));
	}
}
class Addition {
	static int add(int a, int b) {
		return (a + b);
	}
	static float add(float a, float b ) {
		return (a + b);
	}
	static String add(String a, String b) {
		return (a + b);
	}
	static int add(int[] input) {
		return Arrays.stream(input).sum();
	}
}