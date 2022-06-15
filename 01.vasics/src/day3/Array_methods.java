package day3;

import java.util.Arrays;

public class Array_methods {

	public static void main(String[] args) {
		int[] arr1 = {
				100, 20, 200, 40,90
		};
		System.out.println("------all elements --------");
		for(var a : arr1)
			System.out.println(a + " ");
		int[] copyArr1 = Arrays.copyOf(arr1, arr1.length);
		
		System.out.println("/After copy, " + Arrays.toString(copyArr1));
		
		
		int[] copyArr2 = Arrays.copyOfRange(arr1, 1,3);
		System.out.println("After copy, " + Arrays.toString(copyArr2));
		
		System.out.println("arr1 == copyArr1 : " + Arrays.equals(arr1,copyArr1));
		System.out.println("arr1 == copyArr2 : " + Arrays.equals(arr1,copyArr2));
		
		Arrays.sort(arr1);
		
		System.out.println("After sorting, " + Arrays.toString(arr1));
		System.out.println("Is 90 in array: " + Arrays.binarySearch(arr1,90));
		System.out.println("Is 900 in array: " + Arrays.binarySearch(arr1,900));
		
		//Arrays.fill(arr1,7);
		//System.out.println("Tottal: "+ total);
		
		int total = Arrays.stream(arr1).sum();
		System.out.println("Total: " + total);
	}
}
