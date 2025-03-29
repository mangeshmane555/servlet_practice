package jdbc;
import java.sql.*;
public class CreateDemo {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","wolf");
			Statement stmt = con.createStatement();
			stmt.execute("create table student007(rollno number(3), name varchar2(10), marks number(3))");
			System.out.println("New table created");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
