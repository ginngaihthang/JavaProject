package day15;

import java.util.List;
import java.util.stream.Collectors;

class 	User{
	private String name;
	private String role;
	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	boolean IsStaff() {
		return this.role.equalsIgnoreCase("Staff");
	}
}
public class Filktering {

	public static void main(String[] args) {
		var users = List.of(
				new User("Aung Aung","Staff"),
				new User("Maung Maung","Staff"),
				new User("Yuri","Customer"),
				new User("Jeon","Customer")
				);
		List<String> names = users.stream()
								.filter(u -> u.getName().contains("aung") && u.getRole().equalsIgnoreCase("Staff"))
								.map(u -> u.getName())
								.collect(Collectors.toList());
		System.out.println(names);
//		users.stream()
//			//.filter(u -> u.getRole().equals("Staff"))
//			.filter(User::IsStaff)
//			.forEach(u -> System.out.println(u.getName() + "(" + u.getRole() + ")"));
	}
}
