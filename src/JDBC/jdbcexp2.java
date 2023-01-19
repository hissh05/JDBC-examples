package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcexp2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try {
		Class.forName("org.postgresql.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:postgresql://localhost:5432/CGHISSHAM", "postgres", "Hissham");
		
		Statement stmt =conn.createStatement();
//		Boolean rss3 = stmt.execute("Create table Product (pid INT,pname TEXT,pprice INT);");
//		if(rss3) {
//			System.out.println("not created");
//		}else {
//			System.out.println("created");
//		}
		for(int i=0;i<4;i++) {
		System.out.println("AFTER Instertion.....");
		System.out.println("pid \t pname \t pprice");
		int rssq=stmt.executeUpdate("Insert into Product values(02,'WATERMELLON',200);");
		
		if(rssq!=0) {
			ResultSet rss2 = stmt.executeQuery("Select * from Product");
			while(rss2.next()) {
				System.out.println(rss2.getInt("pid") + "\t" +rss2.getString("pname") + "\t" + rss2.getInt("pprice"));
			}
		}else {
			System.out.println("Not inserted");
		}
		}
		ResultSet rss = stmt.executeQuery("Select * from Product");
		
		

		System.out.println("Product Data.....");
		System.out.println("WHOLE TABLE.....");
		while(rss.next()) {
			System.out.println(rss.getInt("pid") + "\t" +rss.getString("pname") + "\t" + rss.getInt("pprice"));
		}
		
		ResultSet rs = stmt.executeQuery("Select * from Product where pprice>45");
		System.out.println("AFTER FILTER.....");
		System.out.println("pid \t pname \t pprice");
		while(rs.next()) {
			System.out.println(rs.getInt("pid") + "\t" +rs.getString("pname") + "\t" + rs.getInt("pprice"));
		}
		
		System.out.println("AFTER Instertion.....");
		System.out.println("pid \t pname \t pprice");
		int rssq=stmt.executeUpdate("Insert into Product values(02,'WATERMELLON',200);");
		
		if(rssq!=0) {
			ResultSet rss2 = stmt.executeQuery("Select * from Product");
			while(rss2.next()) {
				System.out.println(rss2.getInt("pid") + "\t" +rss2.getString("pname") + "\t" + rss2.getInt("pprice"));
			}
		}else {
			System.out.println("Not inserted");
		}
		int rssq2=stmt.executeUpdate("UPDATE Product SET pid = 2, pname = 'MANGO',pprice=21 WHERE pname='APPLE';");
		if(rssq2!=0) {
			System.out.println("UPDATED");
		}else {
			System.out.println("NOT UPDATED");
		}
		
		Boolean qwe1=stmt.execute("ALTER TABLE Product ADD STOCK INT;");
		if(qwe1) {
			System.out.println("Not ALtered");
		}else {
			System.out.println("Altered");
		}
//		Boolean qwe=stmt.execute("DROP table Product;");
//		if(qwe) {
//			System.out.println("NOT Dropped");
//		}else {
//			System.out.println("Dropped");
//		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
