package day20;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Example_3 {

	public static void main(String[] args) {
		try(Connection con = MyConnection.createConnection()) {
			
			String query1 = "SELECT * FROM employees WHERE salary BETWEEN ? AND ?";
			PreparedStatement pstm = con.prepareStatement(query1);
			pstm.setDouble(1, 500000);
			pstm.setDouble(2, 1000000);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("empNO") + "\t");
				System.out.print(rs.getString("password") + "\t");
				System.out.print(rs.getString("email")+ "\t");
				System.out.print(rs.getDouble("salary") + "\t");
				System.out.print(rs.getDate("birthday")+"\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
