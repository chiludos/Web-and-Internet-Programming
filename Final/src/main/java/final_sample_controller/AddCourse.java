package final_sample_controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import final_sample_model.CourseMapping;
import final_sample_model.QCourse;
import final_sample_model.SCourse;


@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("AddCourse.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// (1) get user-input data: course name and type
		// (2) insert a new course record: q_courses table or s_courses based on user
		// (3) redirect to DisplayMapping
		
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu52?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu52";
			String password = "AKwBs2xHu9Kf";
			c = DriverManager.getConnection(url, username, password);
			
			String sql = "";
			if (type.equals("Quarter")) {
				sql = "insert into q_courses (name) values (?);";
			}
			
			else {
				sql = "insert into s_courses (name) valuse (?);";
			}
			
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("DisplayMapping");
	}

}
