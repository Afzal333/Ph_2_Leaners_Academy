package dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Teachers;


public class Teachers_db {
	private String jdbcURL = "jdbc:mysql://localhost:3306/ph2_la?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_TEACHERS_SQL = "INSERT INTO teachers" + "  (name, email, experience) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_TEACHERS_BY_ID = "select id,name,email,experience from teachers where id =?";
	private static final String SELECT_ALL_TEACHERS = "select * from teachers";
	private static final String DELETE_TEACHERS_SQL = "delete from teachers where id = ?;";
	private static final String UPDATE_TEACHERS_SQL = "update teachers set name = ?,email= ?, experience =? where id = ?;";

	public Teachers_db() {
	}
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertTeacher(Teachers teacher) throws SQLException {
		System.out.println(INSERT_TEACHERS_SQL);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TEACHERS_SQL)) {
			preparedStatement.setString(1, teacher.getName());
			preparedStatement.setString(2, teacher.getEmail());
			preparedStatement.setString(3, teacher.getExperience());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Teachers selectTeacher(int id) {
		Teachers teacher = null;
				try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TEACHERS_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
		    ResultSet rs = preparedStatement.executeQuery();

						while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String exp = rs.getString("experience");
				teacher = new Teachers(id, name, email, exp);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return teacher;
	}

	public List<Teachers> selectAllTeachers() {

		List<Teachers> users = new ArrayList<>();
	
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TEACHERS);) {
			System.out.println(preparedStatement);
		
			ResultSet rs = preparedStatement.executeQuery();

		
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String exp = rs.getString("experience");
				users.add(new Teachers(id, name, email, exp));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteTeacher(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_TEACHERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateTeacher(Teachers teacher) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_TEACHERS_SQL);) {
			System.out.println("updated Teachers list:"+statement);
			statement.setString(1, teacher.getName());
			statement.setString(2, teacher.getEmail());
			statement.setString(3, teacher.getExperience());
			statement.setInt(4, teacher.getId());

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
