package com.karsun.fema.gmm.marquess.data;

import java.util.List;

public class ApiDataProvider {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param programme
	 * @param courses
	 */
	public ApiDataProvider(int id, String firstName, String lastName, String email, String programme,
			List<String> courses) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.programme = programme;
		this.courses = courses;
	}
	private String programme;
	private List<String> courses;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProgramme() {
		return programme;
	}
	public void setProgramme(String program) {
		this.programme = program;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	
}




