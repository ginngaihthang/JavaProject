package day10Ingeritance;

public class Demo {
	public static void main(String[] args) {
		Person p1 =new Person("James");
		p1.showInfo();
		
		Teacher t1 = new Teacher("jeon", "Tutar");
		t1.showInfo();
//		
		Person p2 = new Teacher("David ", "Lecture");
		p2.showInfo();
//		int a = 100;
//		long b = a;
//		int c = (int) b;
//		Person p3 = t1;
		Teacher t2 = (Teacher) p2;
	}
	
}
