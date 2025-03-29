package basics;
import java.sql.*;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con;
    public RegServlet() {
        super();
    }
    //
	public void init(ServletConfig config) throws ServletException 
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "wolf");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			PrintWriter pw = response.getWriter();
			//Getting values from reg.html file
			String s1 = request.getParameter("fname");
			String s2 = request.getParameter("lname");
			String s3 = request.getParameter("uname");
			String s4 = request.getParameter("pword");
			//
			pw.println("<html><body><h2></h2>");
			pw.println("<h2> fname : "+s1+"</h2>");
			pw.println("<h2> lname : "+s2+"</h2>");
			pw.println("<h2> uname : "+s3+"</h2>");
			pw.println("<h2> password : "+s4+"</h><br>"); 
			//
			if (this.con == null) {
				pw.println("<h2> Connection Failed !</h2>");
			} else {
				pw.println("<h2> Connected Successfully !</h2>");
			}
			//
			PreparedStatement pstmt = con.prepareStatement("insert into uinfo values(?,?,?,?)");
			pstmt.setString(1,s1);
			pstmt.setString(2,s2);
			pstmt.setString(3,s3);
			pstmt.setString(4,s4);
			//
			int x = pstmt.executeUpdate();
			if(x==1)
			{
				pw.println("<h2> Data Inserted successfully !</h2>");
			}
			else {
				pw.println("<h2> Data Failed to insert!</h2>");
			}
			//
//			pw.println("<h2> Data inserted successfully !</h2>");
			pw.println("<a href=login.html> Go to Login </a>");
			pw.println("</body></html>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
