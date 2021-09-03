package model;

public class Students {
	protected int id;
	protected String name;
	protected String email;
	protected String country;
	protected String course;

	public Students(int id, String name, String email, String country, String course) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
		this.course =course;
	}
	public Students(String name, String email, String country,String course) {
		// TODO Auto-generated constructor stub
		super();
		this.name = name;
		this.email = email;
		this.country = country;
		this.course =course;

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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	

}
