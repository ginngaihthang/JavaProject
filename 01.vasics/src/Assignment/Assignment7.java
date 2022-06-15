package Assignment;

import java.util.Scanner;

public class Assignment7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Write one sentence: ");
		String sentence = sc.nextLine();
		
		String[] splits = sentence.split(" ");
		
		if(sentence.startsWith("Wh") || sentence.startsWith("Have") || sentence.startsWith("Has") || sentence.endsWith("?") || sentence.startsWith("Does") || sentence.startsWith("Do") || sentence.startsWith("Is") ) {
			System.out.println("This is questen sentence");
			System.out.println("Frist word ->" + splits[0]);
			if(splits[0].equals("Are") || splits[0].equals("Have") || splits[0].equals("Is") || splits[0].equals("Does") || splits[0].equals("Do")) {
				System.out.println("Simple present tense");
			}
			else if(splits[1].equals("are") || splits[1].equals("is") || splits[1].equals("does") || splits[1].equals("do")) {
				System.out.println("Simple present tense");
			}
			else {
				System.out.println("Is not simple present tense");
			}
		}else {
			System.out.println("Is not question!");
		}
		
		
	}
}
