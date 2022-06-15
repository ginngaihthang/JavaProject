package Assignment;

import java.util.Scanner;

public class Assignment3 {


	public static void main(String[] args) {
		
		String[] brand = {"lenovo","hp","samsung","acer","dell","asus"};
		String[] core = {"i3", "i5", "i7", "i9"};
		String[] core1 = {"corei3", "corei5", "corei7", "corei9"};
		float[][] amount = {
				{(float) 230.21, (float) 400.21, (float) 294.2, (float) 693.33, (float) 340.44, (float) 691.99},
				{(float) 529.483, (float) 920.483, (float) 676.66, (float) 1594.659, (float)783.012, (float)1591.577},
				{(float) 552.504, (float) 960.504, (float) 706.08, (float) 1663.992, (float)817.056, (float)1660.776},
				{(float) 690.63, (float) 1200.63, (float) 882.6, (float) 2079.99, (float) 1021.32, (float) 2075.97}
		};
		
		// show product
		for(int i = 0; i < brand.length;i++) {
			System.out.print("\t"+brand[i] + "\t");
		}
	
		for(int j = 0; j < amount.length; j++) {
			System.out.print("\n"+core1[j] + "\t");
			for(int k = 0; k < amount[0].length; k++) {
				System.out.print(amount[j][k] + "\t\t");
			}
		}
		
		// To buy
		boolean bool = true;
		while(bool) {
			boolean result =false;
			Scanner sc = new Scanner(System.in);
			System.out.println("\nYou can choose 'lenovo' 'hp' 'samsung' 'acer' 'dell' 'asus'");
			System.out.print("Choose you want to buy: ");
			String brandName = sc.nextLine();
			for(int j =0;j < brand.length;j++) {
				if(brandName.equals(brand[j])) {					
					result = true;	
				}	
			}
			while(result == false) {
				int i = 0;
				if(!brandName.equals(brand[i])) {
					System.out.println(brandName+" Does not exist");
					i++;
					sc.close();
					return;	
				}
			}	
			boolean result1 =false;
			System.out.println("You can choose 'i3' 'i5' 'i7' 'i9'");
			System.out.print("Enter computer cores: ");
			String coreName = sc.nextLine();
			for(int j =0;j < core.length;j++) {
				if(coreName.equals(core[j])) {
					result1 = true;
				}
			}
			while(result1 == false) {
				int i = 0;
				 if(!coreName.equals(core[i])){
					System.out.println(coreName+ " Does not exist");
					i++;
					sc.close();
					return;
				}
			}
		for(int row = 0; row < amount[0].length; row++) {
			for(int col = 0; col < amount.length;col++) {
				if(brandName.equals(brand[row]) && coreName.equals(core[col]) || coreName.equals(core1[col])) {
					if(brandName.equals(brand[row])){
						System.out.println("Brand\t" + "Core\t" + "price\t" );
						System.out.println(brand[row] + "\t" + core[col] + "\t" + amount[col][row]+"$");
						System.out.print("To change MMK: ");
						float mmk = sc.nextFloat();
						System.out.println("Brand\t" + "Core\t" + "price\t" + "priceMMK" );
						System.out.println(brand[row] + "\t" + core[col] + "\t" + amount[col][row]+"$" + "\t" + amount[col][row] * mmk +"ks");
						break;
						}
					}
				}
			}
			System.out.println("Do you want to continue,press 'y' or quit 'n': ");
			String ch = sc.next();
			if(ch.equals("y")) {
				bool = true;
				result =true;
			}else {
				bool= false;
				sc.close();
			}
		}
	};
}