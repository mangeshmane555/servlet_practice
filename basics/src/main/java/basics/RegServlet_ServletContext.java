package basics;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//
@WebServlet("/RegServlet_ServletContext")
public class RegServlet_ServletContext extends HttpServlet {
	Connection con;
	private static final long serialVersionUID = 1L;
	public RegServlet_ServletContext() {
		super();
	}
	//
	public void init(ServletConfig config) throws ServletException {
		try {
			ServletContext sc = config.getServletContext();
			String driver = sc.getInitParameter("driver");
			String url = sc.getInitParameter("url");
			String username = sc.getInitParameter("username");
			String password = sc.getInitParameter("password");
			//
			Class.forName(driver);
			DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	//
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
//		PrintWriter pw = response.getWriter();
//		pw.println("<html><body>");
//		//
//		String fname = request.getParameter("fname");
//		String lname = request.getParameter("lname");
//		String uname = request.getParameter("uname");
//		String pword = request.getParameter("pword");
//		//
//		pw.println("<h1>"+fname+"</h1>");
//		pw.println("<h1>"+lname+"</h1>");
//		pw.println("<h1>"+uname+"</h1>");
//		pw.println("<h1>"+pword+"</h1>");
//		//
//		if(this.con == null) {
//			pw.println("<h1>Connection Failed !</h1>");
//		}
//		else {
//			pw.println("<h1>Connected Successfully !</h1>");
//			//
//			
//		}
			
	}
	public void destroy() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
