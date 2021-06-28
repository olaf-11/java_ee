package com.htp.bynews.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="appusers")
public class AppUser implements Serializable {
	private static final long serialVersionUID = 1759870238289196175L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable = false, updatable = false)
	private int id;

	@Column(name="email", unique = true, nullable = false)
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="name")
	private String name;
	
	@Column(name="status")
	private String status;
	
	@Transient
	private String pwdConfirm;
	
	// Only for test! Delete this!
	@Column(name="pwd_comment")
	private String pwd_comment;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
						   CascadeType.DETACH, CascadeType.REFRESH}, 
						   fetch=FetchType.EAGER)
	@JoinTable(name = "users_roles", 
			   joinColumns = @JoinColumn (name = "appusers_id"),
			   inverseJoinColumns = @JoinColumn (name = "roles_id"))
	private List<Role> role;
	
	public AppUser() {}
	
	public AppUser(String e, String p, String n) {
		email = e;
		password = p;
		name = n;
		status = "active";
	}
	
	public AppUser(String e, String p, String n, String s, String st) {
		email = e;
		password = p;
		name = n;
		status = st;
	}
	
	// Only for test! Delete this!
	public String getPwd_comment() {
		return pwd_comment;
	}

	// Only for test! Delete this!
	public void setPwd_comment(String pwd_comment) {
		this.pwd_comment = pwd_comment;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPwdConfirm() {
		return pwdConfirm;
	}

	public void setPwdConfirm(String pwdConfirm) {
		this.pwdConfirm = pwdConfirm;
	}
	
	public void setRole(List<Role> role) {
		this.role = role;
	}
	
	public List<Role> getRole() {
		return role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppUser other = (AppUser) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User login: " + email + "\n" +
			   "password: " + "**********" + "\n" +
			   "name: " + name + "\n" +
			   "role: " + role + "\n" +
			   "status: " + status + "\n";
	}
}