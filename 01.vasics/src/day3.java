import java.util.Scanner;

public class day3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter food name : ");
		String name = sc.nextLine();
		String category;
//		switch(name) {
//		case "burger","pizza","sandwich" :
//		category = "Fast Food";
//		break;
//		
//		case "yogurt","milk tea" :
//		category = "Dessert";
//		break;
//		case "mohinga" :
//		category = "Burmese Food";
//		break;
//		case "sushi" :
//		category = "Japanese Food";
//		break;
//		default :
//		category = "unknown";
//		}
		category = switch(name) {
		case "burger", "pizza", "sandwich" ->{
			if(name.equals("pizza"))
				System.out.println(name + "is italian food");
			yield "fast food";
			
		}
		case "yogurt","milk tea" -> {
			yield "Dessert";
		}
		case "mohinga" -> "Burmese Food";
		case "sushi" -> "Japanese Food";
		default -> "unknown";
		};
		System.out.println(name + " is " + category);
		sc.close();
	}
}
