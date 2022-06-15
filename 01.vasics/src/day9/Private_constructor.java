package day9;

public class Private_constructor {
	public static void main(String[] args) {
		DatabaseConfig obj1 = DatabaseConfig.getInstane();
		System.out.println("db name of obj1: " + obj1.db_name);
		DatabaseConfig obj2 = DatabaseConfig.getInstane();
		System.out.println("db name of obj2 : " + obj2.db_name);
		
		obj2.db_name = "bank_db";
		System.out.println("db name of obj1: " + obj2.db_name);
	}
}
class DatabaseConfig {
	String db_name = "employee_db";
	private static DatabaseConfig config = null;
	private DatabaseConfig() {
		
	}
	static  DatabaseConfig getInstane() {
		if(config == null) 
			config = new DatabaseConfig();
		return config;
		
	}
	
}
