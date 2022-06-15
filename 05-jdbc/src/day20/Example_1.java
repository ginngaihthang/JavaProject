package day20;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Example_1 {
	
	public static void main(String[] args) {
		try(Connection con = MyConnection.createConnection()) {
			String update = """
					UPDATE employees SET salary = salary +(salary * 0.2) WHERE city = ?
					""";
			PreparedStatement pstm = con.prepareStatement(update);
			pstm.setString(1, "Mandalay");
			int result = pstm.executeUpdate();
			System.out.println("no of roe updated: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
