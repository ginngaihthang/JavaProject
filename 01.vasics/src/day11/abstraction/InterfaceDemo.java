package day11.abstraction;

public class InterfaceDemo {
	
	public static void main(String[] args) {
		
		Interface listener = new Button("Gegister");
		listener.onClick();
		listener.onDoubleClick();
	}
}
