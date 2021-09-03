package model;

public class Classes {
	protected int id;
	protected String name;
	protected String teacher;
	protected String duration;
	protected String courses;

	public Classes(int id, String name, String teacher, String duration, String courses) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.duration = duration;
		this.courses = courses;
		
	}
	public Classes(String name, String teacher, String duration, String courses) {
		// TODO Auto-generated constructor stub
		super();
		this.name = name;
		this.teacher = teacher;
		this.duration = duration;
		this.courses = courses;
		
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getCourses() {
		return courses;
	}
	public void setCourses(String courses) {
		this.courses = courses;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

}
