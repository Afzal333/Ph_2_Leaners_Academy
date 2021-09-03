package model;

public class Teachers {
	protected int id;
	protected String name;
	protected String email;
	protected String experience;

	public Teachers(int id, String name, String email, String experience) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.experience = experience;
	}
	public Teachers(String name, String email, String experience) {
		// TODO Auto-generated constructor stub
		super();
		this.name = name;
		this.email = email;
		this.experience = experience;
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
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}

}
