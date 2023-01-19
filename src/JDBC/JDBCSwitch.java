package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCSwitch  {
	static Scanner sc=new Scanner(System.in);

	
	static void createable(Statement stmt) {
		try {
			Boolean rss3 = stmt.execute("Create table Course (Courseid INT,CourseName TEXT,Coursefee INT);");
			if(rss3) {
				System.out.println("Course Table Not Created");
			}else {
				System.out.println("Course Table created");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	static void Insertintotable(Connection con,Statement smat) {
		try {
			

			PreparedStatement rssq = con.prepareStatement("insert into Course values(?,?,?);");
			System.out.println("Enter Course details...");
			System.out.println("enter Course id");
			int cno = sc.nextInt();
			rssq.setInt(1, cno);
			System.out.println("enter Course name");
			sc.nextLine();
			String ename = sc.nextLine();
			rssq.setString(2, ename);
			System.out.println("enter Course Fee");
			int ejob = sc.nextInt();
			rssq.setInt(3, ejob);
			int result = rssq.executeUpdate();
			if(result!=0) {
				System.out.println("Inserted");
				ResultSet rss2 = smat.executeQuery("Select * from Course");
				while(rss2.next()) {
					System.out.println(rss2.getInt("Courseid") + "\t" +rss2.getString("Coursename") + "\t" + rss2.getInt("Coursefee"));
				}
				
			}else {
				System.out.println("Not inserted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("1 or 2");
		Scanner sc2=new Scanner(System.in);
		int ch=sc2.nextInt();
		Class.forName("org.postgresql.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:postgresql://localhost:5432/CGHISSHAM", "postgres", "Hissham");
		
		Statement stmt =conn.createStatement();
		switch (ch) {
		case 1:
			createable(stmt);
			break;
		case 2:
			Insertintotable(conn,stmt);
			break;
		default:
			break;
		}
		
	}
	
}
