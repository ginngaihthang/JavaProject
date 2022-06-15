package day11.abstraction;

public class Button implements Interface{
	
	private String name;
	public Button(String name) {
		this.name = name;
	}
	public void display() {
		System.out.println("font size: " + FONT_SIZE);
		System.out.println("font type: " + FONT_FAMILY);
	}
	public void onClick() {
		System.out.println(name + "click event");
	}
	public void onDoubleClick() {
		System.out.println(name + "double event");
		
 	}
}
