package day11.abstraction;

public abstract class DatabaseUtil {
	private String db_name = "shopdb";
	
	//concreate metnod
	public void connectDatabase() {
		System.out.println("Connecting to " + db_name);
	}
	//abstract
	public abstract void insert();
	public abstract void update();
	public abstract boolean delete(int id);
	public abstract Object findById(int id);
}
