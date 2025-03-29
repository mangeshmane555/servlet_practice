package jdbc;
import java.sql.*;
public class InsertDemo {
	public static void main(String[] args) {
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "wolf");
		Statement stmt = con.createStatement();
		stmt.executeUpdate("insert into student007 values(1, 'Rakesh', 49)");
		System.out.println("Record inserted Successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
