package final_sample_controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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


@WebServlet("/CreateMapping")
public class CreateMapping extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateMapping() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// (1) get data from datatbase: unmapped q_course, unmapped s_course
		// (2) convert each data to Java List
		// (3) save Java List(s) 
		
		List<QCourse> unMappedQCourses = new ArrayList<QCourse>();
		List<SCourse> unMappedSCourses = new ArrayList<SCourse>();
		
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu52?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu52";
			String password = "AKwBs2xHu9Kf";
			c = DriverManager.getConnection(url, username, password);
			
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select *"
					+ "	from q_courses q left join course_mappings cm on q.id = cm.q_course_id"
					+ "	where q_course_id is null;");

			while (rs.next()) {
				
				unMappedQCourses.add(new QCourse(rs.getInt(1), rs.getString(2)));
			}
			
			rs = stmt.executeQuery("select id, name " 
					+ " from s_course s left join course_mappings cm on s.id = cm.s_course_id "
					+ " where s_course_id is null;");
			
			while (rs.next()) {
				
				unMappedSCourses.add(new SCourse(rs.getInt(1), rs.getString(2)));
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
		request.getRequestDispatcher("CreateMapping.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// (1) get user-input data: q_course_id and s_course_id
		// (2) insert a new course_mapping record
		// (3) redirect to DisplayMapping
		
		String qCourseIdStr = request.getParameter("quarter");
		String sCourseIdStr = request.getParameter("semester");
		
		// handle unexpected user-input data
		if(qCourseIdStr == null || qCourseIdStr.equals("") || sCourseIdStr == null || sCourseIdStr.equals("")) {
			response.sendRedirect("CreateMapping"); // doGet()
			return;
		}
		
		int qCourseId = Integer.parseInt(qCourseIdStr);
		int sCourseId = Integer.parseInt(sCourseIdStr);
		
		Connection c = null;
        try
        {            
        	String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
            String username = "cs3220stu01";
            String password = "5qKaT3crp3Gv";
            c = DriverManager.getConnection( url, username, password );

            String sql = "insert into course_mappings values (?, ?);";            
            PreparedStatement pstmt = c.prepareStatement(sql);
            pstmt.setInt(1, qCourseId);
            pstmt.setInt(2, sCourseId);
            pstmt.executeUpdate();       
        }       
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                e.printStackTrace();
            }
        }
        
        response.sendRedirect("DisplayMapping");
		
	}

}
