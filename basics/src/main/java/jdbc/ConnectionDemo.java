package jdbc;
import java.sql.*;
public class ConnectionDemo {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "wolf");
			System.out.println("Connected Successfully");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
