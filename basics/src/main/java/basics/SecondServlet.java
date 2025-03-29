package basics;

//import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
public class SecondServlet extends GenericServlet 
{
	private static final long serialVersionUID = 1L;       
    public SecondServlet() 
    {
    	super();
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		PrintWriter pw = response.getWriter();
		pw.println("<html> <body bgcolor=white> <h1>Second Servlet Program... </h1></body></html>");
	}

}
