package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Students_db;

import model.Students;

@WebServlet("/list-student")
public class ListStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Students_db studentDb;
	
	
	public ListStudent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void init() {
		studentDb = new Students_db();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

				listUser(request, response);

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		}
		
	 private void listUser(HttpServletRequest request, HttpServletResponse response)
					throws SQLException, IOException, ServletException {

		    		List<Students> listUser = studentDb.selectAllStudents();
					request.setAttribute("listStudent", listUser);
					RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
					dispatcher.forward(request, response);
//		    	}
		    	
			
			}

}
