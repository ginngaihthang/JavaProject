package day8;

import java.time.LocalDate;

class Book {
	String title;
	LocalDate publish_data;
	int price;
	public Book(String title, LocalDate publish_data, int price) {
		super();
		this.title = title;
		this.publish_data = publish_data;
		this.price = price;
		
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", publish_data=" + publish_data + ", price=" + price + "]";
	}
	public Book(Book other) {
		this.title = other.title;
		this.price = other.price;
		this.publish_data = other.publish_data;
	}
}
public class Copy_Constructor {
	public static void main(String[] args) {
		LocalDate publish = LocalDate.of(1961,  10, 16);
		Book book1 = new Book("detdctive U San Shar" , publish, 6000);
		System.out.println(book1);
		
		Book book2 = new Book(book1);
		System.out.println(book2);
	}
}
