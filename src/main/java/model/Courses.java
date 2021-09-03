package model;

public class Courses {
	protected int id;
	protected String course;
	

	public Courses(int id, String course) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.course = course;
		
	}
	public Courses(String course) {
		// TODO Auto-generated constructor stub
		super();
		this.course = course;
		
		
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	

}
