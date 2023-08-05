package login_logout;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<!DOCTYPE html><html>");
		out.print("<head><meta charset='UTF-8'><title>Login</title></head>");
		out.print("<body>");
		out.print("<form action='Login' method='post'>");
		
		String user = (String) request.getSession().getAttribute("user");
		if (user == null) {
			out.print("<p>Username: <input type='text' name='username' /></p>");
			out.print("<p>Password: <input type='password' name='password' /></p>");
		}
		
		else {
			out.print("<p>Username: <input type='text' name='username' value='" + user + "'</p>");
			out.print("<p>Password: <input type='password' name='password' /></p>");
		}
		
		out.print("<p><input type='submit' value='Login' /></p>");
		out.print("</form></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		
		if (userName.equals("cguo") && passWord.equals("123456")) {
			user = request.getParameter("username").trim();
			session.setAttribute("user", user);
			response.sendRedirect("Members");
		}
		
		else {
			response.sendRedirect("Login");
		}
	}

}
