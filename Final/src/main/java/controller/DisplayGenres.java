package controller;

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

import model.Book;


@WebServlet("/DisplayGenres")
public class DisplayGenres extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DisplayGenres() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Book> books = new ArrayList<Book>();

		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu52?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu52";
			String password = "AKwBs2xHu9Kf";
			c = DriverManager.getConnection(url, username, password);
			
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from books order by votes desc");

			while (rs.next()) {
				
				Book book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				books.add(book);
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
		
		request.setAttribute("books", books);
		request.getRequestDispatcher("DisplayGenres.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
