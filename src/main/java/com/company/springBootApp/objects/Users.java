package com.company.springBootApp.objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.company.springBootApp.objects.classId.UsersId;

@Entity(name="SEC_USERS")
@IdClass(UsersId.class)
@Table(name = "SEC_USERS")
public class Users {
	@Id
	@Column(name="USER_ID")
	private Integer id = 0;
	@Id
	@Column(name="USER_NAME")
	private String name = "";
	@Column(name="USER_PASS")
	private String pass = "";
	@Column(name="USER_DATELASTLOGIN")
	private Integer lastDatelogin = 0;
	@Column(name="STATUS")
	private Integer status = 1;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public Integer getLastDatelogin() {
		return lastDatelogin;
	}
	
	public void setLastDatelogin(Integer lastDatelogin) {
		this.lastDatelogin = lastDatelogin;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
