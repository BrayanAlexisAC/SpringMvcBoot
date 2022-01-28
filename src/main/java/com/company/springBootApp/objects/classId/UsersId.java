package com.company.springBootApp.objects.classId;

import java.io.Serializable;

import javax.persistence.Column;

public class UsersId implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(name="USER_ID")
	private Integer id = 0;
	@Column(name="USER_NAME")
	private String name;
	
	public UsersId() {}

	public UsersId(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
}
