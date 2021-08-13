package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IASOfficer")
public class IASOfficer {
	
	@Id
	@Column(name = "EMPID")
	private int ID;
	
	@Column(name = "EMP_NAME")
	private String Name;
	
	@Column(name = "EMP_DESIGNATION")
	private String designation;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	

}
