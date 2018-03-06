package com.mengqi.models;

import java.util.Collection;

public class Developer extends Person{
	
	private int id;
	private String developerKey;
	private Role role;
	private Priviledge priviledge;
	
	private Collection<Website> websites;
	
	public void addWebsite(Website website){
        this.websites.add(website);
    }

    public void removeWebsite(Website website){
        this.websites.remove(website);
    }
	
    public Developer() {
		super();
	}
    

	public Developer(int id, String firstName, String lastName, String username, String password, String email, String developerKey) {
		super(firstName, lastName, username, password, email);
		this.developerKey = developerKey;
		this.id = id;
	}


	public int getId() {
		return id;
	}

	public void setId(int developerId) {
		this.id = developerId;
	}

	public String getDeveloperKey() {
		return developerKey;
	}

	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Priviledge getPriviledge() {
		return priviledge;
	}

	public void setPriviledge(Priviledge priviledge) {
		this.priviledge = priviledge;
	}

	public Collection<Website> getWebsites() {
		return websites;
	}

	public void setWebsites(Collection<Website> websites) {
		this.websites = websites;
	}
    
    

	
	
	
}
