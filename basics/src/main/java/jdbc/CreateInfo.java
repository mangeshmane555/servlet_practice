package jdbc;
import java.sql.*;
public class CreateInfo {
	public static void main(String[] args){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","wolf");
			Statement stmt = con.createStatement();
			stmt.execute("create table uinfo(fname varchar2(15), lname varchar2(15), uname varchar2(15), pword varchar2(15))");
			System.out.println("New Table Created");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
}
