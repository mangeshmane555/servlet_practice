
//Servlet First Program
package first;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends GenericServlet{
    /**
     * @see GenericServlet#GenericServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		pw.println("<html> <body> <h1>First Servlet </h1></body> </html>");
		
	}
	
	

}
