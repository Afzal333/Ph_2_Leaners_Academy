package dao;

import java.sql.Connection
;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import model.Classes;


public class Classes_db {
	private String jdbcURL = "jdbc:mysql://localhost:3306/ph2_la?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_STUDENTS_SQL = "INSERT INTO classes" + "  (name, teacher, duration,courses) VALUES "
			+ " (?, ?, ?, ?);";

	private static final String SELECT_STUDENTS_BY_ID = "select id,name,teacher,duration,courses from classes where id =?";
	private static final String SELECT_ALL_STUDENTS = "select * from classes";
	private static final String DELETE_STUDENTS_SQL = "delete from classes where id = ?;";
	private static final String UPDATE_STUDENTS_SQL = "update classes set name = ?,teacher= ?, duration =?,courses=? where id = ?;";

	public Classes_db() {
	}
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertSubject(Classes student) throws SQLException {
		System.out.println(INSERT_STUDENTS_SQL);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENTS_SQL)) {
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getTeacher());
			preparedStatement.setString(3, student.getDuration());
			preparedStatement.setString(4, student.getCourses());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Classes selectSubject(int id) {
		Classes student = null;
				try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENTS_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
		    ResultSet rs = preparedStatement.executeQuery();

						while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("teacher");
				String duration = rs.getString("duration");
				String courses = rs.getString("courses");
				
				
				student = new Classes(id, name, email, duration,courses);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return student;
	}

	public List<Classes> selectAllSubjects() {

		
		List<Classes> users = new ArrayList<>();

		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String teachername = rs.getString("teacher");
				String duration = rs.getString("duration");
				String courses = rs.getString("courses");
				users.add(new Classes(id, name, teachername, duration,courses));
				

			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteClasses(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_STUDENTS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateClasses(Classes student) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENTS_SQL);) {
			System.out.println("updated student list:"+statement);
			statement.setString(1, student.getName());
			statement.setString(2, student.getTeacher());
			statement.setString(3, student.getDuration());
			statement.setString(4, student.getCourses());
			statement.setInt(5, student.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}


}
