package Assignment.pkg7;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class SalePeople {
	private String name;
	private String city;
	private float comm;
	public SalePeople(String name, String city, float comm) {
		super();
		this.name = name;
		this.city = city;
		this.comm = comm;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public float getComm() {
		return comm;
	}
	public void setComm(float comm) {
		this.comm = comm;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", city=" + city + ", comm=" + comm + "]";
	}
	
}
public class Strem_Assigment {

	public static void main(String[] args) {
		SalePeople[] people= {
				new SalePeople("Peel", "London" , 0.12f),
				new SalePeople("Serres" , "San Joes" , 0.13f),
				new SalePeople("Motika","London",0.11f),
				new SalePeople("Rifkin", "Barcelona", 0.15f),
				new SalePeople("Axelrod", "New York" , 0.10f)
		};
		List<SalePeople> sale = Arrays.asList(people);
		System.out.println("Names and cities of all salespeople in London with a commission above .10.");
		sale.stream()
			.filter(s -> s.getComm() > 0.10f)
			.filter(c -> c.getCity().contains("London"))
			.forEach(str -> System.out.println(str.getName()+ "\t" +str.getCity()));
		
		System.out.println("\nSalesperson details not having commission .10, .13 or .15.");
		System.out.println("Name\tCity\tComm");
		sale.stream()
			.filter(c -> c.getComm() !=0.10f && c.getComm() != 0.13f && c.getComm() != 0.15f)
			.forEach(str -> System.out.println(str.getName()+ "\t" + str.getCity() +"\t"+ str.getComm()));
		
		System.out.println("\nDifferent city names");
		List<String> name = sale.stream()
								.map(e-> e.getCity())
								.distinct()
								.collect(Collectors.toList());
							
							
		System.out.println(name);
			
		System.out.println("\nThe top of (salespeople 3) records.");
		System.out.println("Name\tCity\tComm");
		sale.stream()
			.limit(3)
			.forEach(str -> System.out.println( str.getName() + "\t" + str.getCity() + "\t" + str.getComm()));
		
		System.out.println("\nDetails of the salespeople who live in ‘Rome’");
		System.out.println("Name\tCity\tComm");
		sale.stream()	
			.filter(s -> s.getCity().equals("Rome") )
			.forEach(str -> System.out.println(str.getName() + "\t" + str.getCity() + "\t" + str.getComm()));
			
		System.out.println("\nThe number of salespeople who stay in London");
		long name1 = sale.stream()
			.filter(s -> s.getCity().equals("London"))
			.count();
		System.out.println(name1);
		
		
		System.out.println("List of salespeople in descending order of commission");
		List<Float> reve = sale.stream()
								.map(c -> c.getComm())
								.sorted(Collections.reverseOrder())
								.collect(Collectors.toList());
								
		System.out.println(reve);

	}
}
