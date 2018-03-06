package com.mengqi.models;

public class User extends Person{
	private int id;
	private boolean userAgreement;

	public User() {
		super();
	}


	public User(int id, String firstName, String lastName, String username, String password, String email, boolean userAgreement) {
		super(firstName, lastName, username, password, email);
		this.userAgreement = userAgreement;
		this.id = id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public boolean isUserAgreement() {
		return userAgreement;
	}


	public void setUserAgreement(boolean userAgreement) {
		this.userAgreement = userAgreement;
	}
	
}
