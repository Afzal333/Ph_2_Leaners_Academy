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

import dao.Teachers_db;
//import model.Courses;
import model.Teachers;


@WebServlet("/list-teacher")
public class TeacherListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Teachers_db teacherDb;

	public void init() {
		teacherDb = new Teachers_db();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/newteacher":
				showNewForm(request, response);
				break;
			case "/insertTeacher":
				insertUser(request, response);
				break;
			case "/deleteteacher":
				deleteUser(request, response);
				break;
			case "/editteacher":
				showEditForm(request, response);
				break;
			case "/updateteacher":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
    private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

	    		List<Teachers> listUser = teacherDb.selectAllTeachers();
	    		request.setAttribute("listTeacher", listUser);
	    		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-list.jsp");
	    		dispatcher.forward(request, response);
		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Teachers existingUser = teacherDb.selectTeacher(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		request.setAttribute("student", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String exp = request.getParameter("experience");
		Teachers newTeacher = new Teachers(name, email, exp);
		teacherDb.insertTeacher(newTeacher);
		response.sendRedirect("list-teacher");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String exp = request.getParameter("experience");

		Teachers t = new Teachers(id, name, email, exp);
		teacherDb.updateTeacher(t);
		response.sendRedirect("list-teacher");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		teacherDb.deleteTeacher(id);
		response.sendRedirect("list-teacher");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
