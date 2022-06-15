package day12;

import java.time.LocalDate;

public class Has_A_Relationship_2 {
	
	public static void main(String[] args) {
		SaleRecord[] records = new SaleRecord[3];
		
		Product prod1 = new Product("Coffee", 1500);
		Product prod2 = new Product("Energy Drink" , 1000);
		
		records[0] = new SaleRecord(1001, prod1, 2);
		records[1] = new SaleRecord(1002, prod2, 3);
		records[2] = new SaleRecord(1003, prod1, 1);
		
		System.out.println("Code\t SaleQty\t Product Name\t Price\t SaleDate\t SubTotal");
		for(SaleRecord sale : records) {
			sale.showData();
		}
			
	}
}
class Product {
	String name;
	int price;
	
	Product (String name, int price) {
		this.name = name;
		this.price = price;
	}
}
class SaleRecord {
	int id;
	int saleQty;
	LocalDate sale_date;
	Product product;
	
	SaleRecord(int id, Product product, int qty) {
		this.id = id;
		this.sale_date = LocalDate.now();
		this.product = product;
		this.saleQty = qty;
	}
	void showData() {
		System.out.println(id + "\t" + saleQty + "\t" + product.name + "\t" + product.price +  "\t" +sale_date+ "\t" + saleQty*product.price);
	}
}