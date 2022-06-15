package day11;

public class Method_Overriding {
	public static void main(String[] args) {
		Developer developer = new Developer();
		developer.work();
		
		developer = new FrontEndDeveloper();
		developer.work();// child's work method
		
		developer = new BackendDeveloper();
		developer.work();// child's work method
	}
}
class Developer {
	void work() {
		System.out.println("Some work");
	}
}
class FrontEndDeveloper extends Developer {
	void work() {
		System.out.println("doing forntend technology");
	}
}
class BackendDeveloper extends Developer {
	void work() {
		System.out.println("doing backend technology");
	}
}