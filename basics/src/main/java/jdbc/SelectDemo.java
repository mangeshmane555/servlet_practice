package jdbc;

import java.sql.DriverManager;
import java.sql.*;
public class SelectDemo {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","wolf");
			Statement st = con.createStatement();
			ResultSet rs =  st.executeQuery("select * from student007");
			ResultSetMetaData rm = rs.getMetaData();
			int n = rm.getColumnCount();
			for(int i=1; i<=n; i++)
			{
				System.out.println(rm.getColumnName(i));
			}
			while(rs.next()) {
				System.out.println(rs.getInt("rollno"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("marks"));
				//OR
//				System.out.println(rs.getInt(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getInt(3));
			}
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
