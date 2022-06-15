package Assignment.pkg5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale.Category;
import java.util.Scanner;

public class Main {

	static String[] categ = {"Poems","Drama", "Boigraphy","Movel"};
	static List<String> categoryList = new ArrayList<>(Arrays.asList(categ));
	static List<Author> authorList = new ArrayList<Author>();
	static List<Book> bookList = new ArrayList<Book>();
	
	public static void main(String[] args) {
		LocalDate now1 = LocalDate.of(2002, 11, 24);
		LocalDate now2 = LocalDate.of(1999, 1, 14);
		LocalDate now3 = LocalDate.of(1889, 4, 19);
		
		//Category
		
		//About Author
		Author author1 = new Author("John Milton","England");
		Author author2 = new Author("Daniel Dofoe", "Austria");
		Author author3 = new Author("Jane Austen" ,"USA");
		authorList.add(author1);
		authorList.add(author2);
		authorList.add(author3);
	
		
		//About book 
		
		Book book1 = new Book(1001,"A Deepness in the Sky",now1,categoryList.get(0),author1);
		Book book2 = new Book(1002,"Magic Terror", now2, categoryList.get(1), author2);
		Book book3 = new Book(1003, "The Stanger", now3, categoryList.get(2), author3);
		bookList.add(0,book1);
		bookList.add(1,book2);
		bookList.add(2,book3);
	
		String[] menu = {"View all Book inforamation", "View all author imformation", "View all book category information","View book list according to author name"};
		String[] menu1 = {"View All Information","View with Category","View with Author"};
		for(int i = 0; i< menu.length; i++ ) {
			System.out.println(i+1+"." +menu[i]);
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter you want to choose: ");
		int num1 = sc.nextInt();
		if(num1 == 1) {
			for(int j = 0; j < menu1.length;j++) {
				System.out.println(j+1+ "." + menu1[j]);
			}
			System.out.print("Please enter you want to choose: ");
			int num2 = sc.nextInt();
			//view all
			if(num2 == 1) {
				System.out.println("Code\t Title\t Date \tCategory \tName \tCountry");
				bookList.forEach((str) -> {
					System.out.println(str.getCategory() + "\t"+ str.getTitle() + "\t" + str.getPublishDate() + "\t" + str.getCategory()+ "\t" + str.getAuthor().getName() + "\t" + str.getAuthor().getCountry());
				});
			}
			//View with Category
			else if(num2 == 2) {
				System.out.print("Enter category to search: ");
				sc.nextLine();
				String Category = sc.nextLine();
				int result = -1;
				for(int i =0;i < bookList.size();i++) {
					if(bookList.get(i).getCategory().equals(Category)) {
						result = i;
						break;
					}
				}
				if(result == -1) {
					System.out.println(Category + " does not exist!");
				}
				else {
					List<Book> searchList = bookList.stream()
													.filter(b -> b.getCategory().equals(Category))
													.toList();
					if(searchList.isEmpty()) {
						System.out.println("There is no book in this category");
					}
					else {
						//display searchlist
						System.out.println("Code -> " +bookList.get(result).getCode());
						System.out.println("Title -> " + bookList.get(result).getTitle());
						System.out.println("Date -> " + bookList.get(result).getPublishDate());
						System.out.println("Category -> " + bookList.get(result).getTitle());
						System.out.println("Name -> " + bookList.get(result).getAuthor().getName());
						System.out.println("Country -> " + bookList.get(result).getAuthor().getCountry());
					}
					
				}
			}
			//View with author
			else if(num2 == 3) {
				System.out.print("Enter autor name to search: ");
				sc.nextLine();
				String authorName = sc.nextLine();
				int result1 = -1;
				for(int i =0; i < authorList.size(); i++) {
					if(authorList.get(i).getName().equals(authorName)) {
						result1 = i;
						break;
					}
				}
				if(result1 == -1) {
					System.out.println("Author name does not exist!");
				}
				else {
					List<Author> searchAuthor = authorList.stream()
													.filter(n -> n.getName().equals(authorName))
													.toList();
					if(searchAuthor.isEmpty()) {
						System.out.println("There is no book for author!");
					}
					else {
						System.out.println("Code -> " +bookList.get(result1).getCode());
						System.out.println("Title -> " + bookList.get(result1).getTitle());
						System.out.println("Date -> " + bookList.get(result1).getPublishDate());
						System.out.println("Category -> " + bookList.get(result1).getTitle());
						System.out.println("Name -> " + bookList.get(result1).getAuthor().getName());
						System.out.println("Country -> " + bookList.get(result1).getAuthor().getCountry());
					}
				}
			}
			else {
				System.out.println("Does not exist!");
			}
		}
		// View all author information
		else if(num1 == 2) {
			System.out.println("AuthorName\tAuthorCountry");
			bookList.forEach((str) -> {
				System.out.println(str.getAuthor().getName() + "\t" + str.getAuthor().getCountry());
			});
		}
		//View all book category information
		else if(num1 == 3) {
			System.out.println(categoryList);
		}
		//View book list according to author name (user input)
		else if(num1 == 4) {
			System.out.print("Enter Book code: ");
			int code1 = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Book title: ");
			String title = sc.nextLine();
			System.out.print("Enter Book LocalDate 'y,m,d': ");
			String date = sc.nextLine();
			String[] splits1 = date.split("\\,");
			LocalDate  date1 = LocalDate.of(Integer.parseInt(splits1[0]), Integer.parseInt(splits1[1]), Integer.parseInt(splits1[2]));
			System.out.print("Enter Book category: ");
			String category = sc.nextLine();
			if(!categoryList.contains(category)) {
				categoryList.add(category);
			}
			else {
				System.out.println("'"+category+"'" + " is already exist");
			}
			System.out.print("Enter Book Author name: ");
			String name = sc.nextLine();
			Author author = searchAuthor(name);
			if(author == null) {
				System.out.println("This is new author");
				System.out.print("Enter Book Author country: ");
				String country = sc.nextLine();
				author = new Author(name, country);
				authorList.add(author);
			}else {
				System.out.println("'" +name+"'"+ " is already exist");
			}
			
			//data entry
			bookList.add(new Book(code1,title,date1,category,author));
			//show data
			System.out.println("\nCode\t Title\t Date");
			
			displayBook();
			System.out.println("\nAuthor Name\tCountry");
			displayAuthor();
			System.out.println("\nAll Categories");
			displayCategory();
		}
		else {
			System.out.println("Does not exist!");
		}
	}

	private static void displayCategory() {
		categoryList.forEach(str -> System.out.print(str + "\t"));
		
	}

	private static void displayAuthor() {
		authorList.forEach( obj -> {
			System.out.println(obj.getName() + "\t" + obj.getCountry());
			
		});
		
	}
	private static void displayBook() {
		bookList.forEach(str -> {
			System.out.println(str.getCode()+ "\t" + str.getTitle() + "\t" + str.getPublishDate());
		});
	}

	private static Author searchAuthor(String name) {
		Author auth = null;
		for(var obj : authorList) {
			if(obj.getName().equals(name)) {
				auth = new Author(obj.getName(), obj.getCountry());
				break;
			}
		}
		return auth;
	}
}
