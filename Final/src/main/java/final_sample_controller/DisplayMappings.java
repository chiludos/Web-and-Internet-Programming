package final_sample_controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import final_sample_model.CourseMapping;
import final_sample_model.QCourse;
import final_sample_model.SCourse;


@WebServlet("/DisplayMappings")
public class DisplayMappings extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DisplayMappings() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// (1) get date from database: q_course, s_course, course_mapping
		// (2) convert each data to Java List
		// (3) save Java List(s) to request scope and forward to JSP
		
		List<QCourse> qCourses = new ArrayList<QCourse>();
		List<SCourse> sCourses = new ArrayList<SCourse>();
		List<CourseMapping> courseMappings = new ArrayList<CourseMapping>();
		
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu52?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu52";
			String password = "AKwBs2xHu9Kf";
			c = DriverManager.getConnection(url, username, password);
			
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from q_courses;");

			while (rs.next()) {
				
				qCourses.add(new QCourse(rs.getInt(1), rs.getString(2)));

			}
			
			rs = stmt.executeQuery("select * from s_courses;");
			
			while (rs.next()) {
				
				sCourses.add(new SCourse(rs.getInt(1), rs.getString(2)));

			}
			
			rs = stmt.executeQuery("select q.id, q.name, s.id, s.name"
					+ " from q_courses q inner join course_mappings cm on q.id = cm.q_course_id"
					+ "	inner join s_courses s on s.id = cm.s_course_id;");
			
			while (rs.next()) {
				
				courseMappings.add(new CourseMapping(new QCourse(rs.getInt(1), rs.getString(2)), new SCourse(rs.getInt(3), rs.getString(4))));

			}
			
			
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
		
		request.setAttribute("qCourses", qCourses);
		request.setAttribute("sCourses", sCourses);
		request.setAttribute("courseMappings", courseMappings);
		
		request.getRequestDispatcher("DisplayMappings.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
