package servlet;

import java.io.IOException;


import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Classes_db;
import model.Classes;
//import model.Students;

/**
 * Servlet implementation class ListClasses
 */
@WebServlet("/list-class")
public class ListClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Classes_db classesdb;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListClasses() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	classesdb = new Classes_db();
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

				listUser(request, response);

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	
		
		
	}
	  private void listUser(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {

	    		List<Classes> listUser = classesdb.selectAllSubjects();
				request.setAttribute("listClasses", listUser);
				RequestDispatcher dispatcher = request.getRequestDispatcher("class-list.jsp");
				dispatcher.forward(request, response);

		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
