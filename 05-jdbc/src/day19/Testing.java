package day19;

import java.sql.Connection;
import java.sql.DriverManager;

public class Testing {

	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/betch_2","root","")) {
			
			System.out.println("Get Connection");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
