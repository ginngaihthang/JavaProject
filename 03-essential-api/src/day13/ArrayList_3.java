package day13;

import java.util.ArrayList;

public class ArrayList_3 {
	
	public static void main(String[] args) {
		var list = new ArrayList<Phone>();
		
		Phone p = new Phone("Samsung", 1500000);
		list.add(p);
		list.add(new Phone("iphone", 2000000));
		list.add(new Phone("vivo", 1200000));
		
		System.out.println(list);
		System.out.println("----- for each -----");
		list.forEach(ph -> System.out.println("Brand: " + ph.brand + ",Price: " +ph.price));
		
		System.out.println("------- Price > 13000000 ------");
		list.forEach(ph -> {
			if(ph.price > 1300000);
				System.out.println(ph);
		});
		
		var phone = list.get(0);
		System.out.println("[0]: " + phone);
	}

	

	
}

class Phone {
	String brand;
	int price;
	 
	Phone(String brand, int price) {
		this.brand = brand;
		this.price =price;
	}

	@Override
	public String toString() {
		return "{brand=" + brand + ", price=" + price + "}";
	}
}