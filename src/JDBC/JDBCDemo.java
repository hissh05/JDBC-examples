package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args)  throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("org.postgresql.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:postgresql://localhost:5432/CGHISSHAM", "postgres", "Hissham");
		
		Statement stmt =conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("Select * from dept");
		
		System.out.println("Department Data.....");
		System.out.println("dptid \t dptname \t loc");
		while(rs.next()) {
			System.out.println(rs.getInt("dptid") + "\t" +rs.getString("dptname") + "\t" + rs.getString("loc"));
		}

	}

}
