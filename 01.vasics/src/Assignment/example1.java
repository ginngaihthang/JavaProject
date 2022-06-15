package Assignment;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Book{
	private int code;
	private String title;
	private LocalDate publishDate;
	private String category;
	private Author author;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
}
class Author{
	private String name;
	private String country;
	public Author() {
		
	}
	public Author(String name, String city) {
		super();
		this.name = name;
		this.country = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
public class example1 {
	
	static List<String> categoryList = new ArrayList<>();
	static List<Author> authorList = new ArrayList<Author>();
	static List<Book> bookList = new ArrayList<Book>();
	
	static void init() {
		initCategory();
		initAuthor();
		initBook();
	}
	static void viewAllCategory() {
		System.out.println("No.\tName");
		System.out.println("-------------------");
		
		for(var i = 0; i < categoryList.size();i++)
			System.out.format("%d\t%s\n", (i + 1),categoryList.get(i));
	}
	static void viewAllAuthor() {
		System.out.println("Name\tCountry");
		System.out.println("--------------------");
		
		authorList.forEach(a->System.out.println(a.getName() + "\t" + a.getCountry()));
	}
	static void viewAllBook() {
		System.out.println("Code \t PublishDate \t Author \t Category \t Title");
		
		bookList.forEach(b->{
			System.out.print(b.getCode() + "\t");
			System.out.print(b.getPublishDate() + "\t");
			System.out.print(b.getAuthor().getName() + "\t");
			System.out.print(b.getCategory() + "\t");
			System.out.print(b.getTitle() + "\n");
		});
	}
	private static void initBook() {
		Book book1 = new Book();
		book1.setCode(1111);
		book1.setPublishDate(LocalDate.now());
		book1.setTitle("Ethics of a Programmer");
		book1.setCategory(categoryList.get(1));
		book1.setAuthor(authorList.get(0));
		
		
		
		Book book2 = new Book();
		book2.setCode(2222);
		book2.setPublishDate(LocalDate.of(1991, 10, 16));
		book2.setTitle("Introduction to MySQL");
		book2.setCategory(categoryList.get(2));
		book2.setAuthor(authorList.get(3));
		
		bookList.add(book1);
		bookList.add(book2);
	}

	private static void initAuthor() {
		authorList.add(new Author("John", "America"));
		authorList.add(new Author("David","India"));
		authorList.add(new Author("Jeon", "Korea"));
		authorList.add(new Author("Htet", "Myanmar"));
		
	}

	private static void initCategory() {
		String[] data = {"Science","Programming","Database","UI/UX"};
		categoryList.addAll(Arrays.asList(data));
		
	}
	
	static Author findAuthor(String name) {
		Author author = null;
		for(Author auth: authorList) {
			if(auth.getName().equalsIgnoreCase(name)) {
				author = auth;
				break;
			}
		}
		return author;
	}
	public static void main(String[] args) {
		
		init();
		
		// add new book
		Book newBook = new Book();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter title:");
		newBook.setTitle(sc.nextLine());
		System.out.print("Enter publishDate(yyyy-MM-dd): ");
		newBook.setPublishDate(LocalDate.parse(sc.nextLine()));
		System.out.print("Enter category:");
		String category = sc.nextLine();
		
		if(!categoryList.contains(category))
			categoryList.add(category);// add new data to category list
		
		newBook.setCategory(category);
		
		System.out.print("Enter Author:");
		String authorName = sc.nextLine();
		Author auth = findAuthor(authorName);
		if(auth == null) {// new author
			auth = new Author();
			System.out.print("""
					This is new author.
					Please enter author's country: 
					""");
			String country = sc.nextLine();
			 
			auth.setCountry(country);
			auth.setName(authorName);
			
			authorList.add(auth);// add new data to author list
		}
		newBook.setAuthor(auth);
		newBook.setCode(5555);
		bookList.add(newBook);
		
		System.out.println("--------- After adding new Book-------------");
		viewAllBook();
		viewAllCategory();
		viewAllAuthor();
		
		//display books by category
		System.out.print("Enter category name: ");
		String s_category = sc.nextLine();
		if(categoryList.contains(s_category)) {
			long count = bookList.stream().filter(
							b->b.getCategory().equalsIgnoreCase(s_category))
						.count();
			if(count == 0) {
				System.out.println("There is no book in this category");
			}
			else {
				System.out.println("Books under category - " + s_category);
				bookList.forEach(b->{
					if(b.getCategory().equalsIgnoreCase(s_category))
					{
						System.out.print(b.getCode() + "\t");
						System.out.print(b.getAuthor().getName() + "\t");
						System.out.print(b.getPublishDate() + "\t");
						System.out.print(b.getTitle() + "\n");
					}
					
				});
			}
			
		}else
			System.err.println("This category does not exist!");
			
		// display book by author
		System.out.print("Enter author name: ");
		String s_author = sc.nextLine();
		Author resultAuth = findAuthor(s_author);
		if(resultAuth == null)
			System.err.println("This author does not exist!");
		else {
			long count = bookList
							.stream()
								.filter(b->b.getAuthor().getName().equalsIgnoreCase(s_author))
								.count();
			if(count == 0)
				System.out.println("There is no book data entry for this book");
			else {
				System.out.println(s_author + "'s book list-");
				bookList.forEach(b->
				{
					if(b.getAuthor().getName().equalsIgnoreCase(s_author))
						System.out.println(b.getTitle());
				});
			}
		}
		sc.close();
	}
}

