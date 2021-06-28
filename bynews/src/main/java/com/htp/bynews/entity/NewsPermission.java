package com.htp.bynews.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="news_permissions")
public class NewsPermission implements Serializable {

	private static final long serialVersionUID = 3538349374286519263L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable = false, updatable = false)
	private int id;
	
	@Column(name="name")
	private String permissionName;
	
	@ManyToMany
	@JoinTable(name = "roles_newsperm", 
			   joinColumns = @JoinColumn (name = "news_permissions_id"),
			   inverseJoinColumns = @JoinColumn (name = "roles_id"))
	private List<Role> role;

	public NewsPermission() {}

	public NewsPermission(int id, String permName) {
		super();
		this.id = id;
		permissionName = permName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((permissionName == null) ? 0 : permissionName.hashCode());
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
		NewsPermission other = (NewsPermission) obj;
		if (id != other.id)
			return false;
		if (permissionName == null) {
			if (other.permissionName != null)
				return false;
		} else if (!permissionName.equals(other.permissionName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "News Permission: id=" + id + "\n" +
			   "permissionName: " + permissionName + "\n";
	}
	
}