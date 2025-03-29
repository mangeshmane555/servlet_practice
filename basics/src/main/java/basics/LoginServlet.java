package basics;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	Connection con;
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	public void init(ServletConfig config) throws ServletException 
	{
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "wolf");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	//
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			PrintWriter pw = response.getWriter();
			String s1 = request.getParameter("uname");
			String s2 = request.getParameter("pword");
			//
			pw.println("<html><body>");
			if (this.con == null) {
				pw.println("<h2> Connection is not initialized !</h2>");
			} else {
				pw.println("<h2> Connection is initialized Ok !</h2>");
			}
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM uinfo WHERE uname= ? AND pword= ?");
			pstmt.setString(1, s1);
			pstmt.setString(2, s2);
			ResultSet rs = pstmt.executeQuery();
			//
			if(rs.next())
			{
				pw.println("<h1>Logged in Successfully <br>");
				pw.println("Welcome "+s1);
			}
			else {
				pw.println("Invalid Username/Paswword");
			}
			pw.println("</h1></html>");
			} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public void destroy()
	{
		try {
			con.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
