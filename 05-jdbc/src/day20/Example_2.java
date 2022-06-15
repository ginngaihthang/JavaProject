package day20;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Example_2 {

	public static void main(String[] args) {
		try(Connection con = MyConnection.createConnection()) {
			String delete = "DELETE FROM employees WHERE city LIKE ?";
			PreparedStatement pstm = con.prepareStatement(delete);
			pstm.setString(1, "%la%");
			int result = pstm.executeUpdate();
			if(result > 0) 
				System.out.println("Success ");
			else
				System.out.println("Fail");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
