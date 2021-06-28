package com.htp.bynews.entity;

import java.io.Serializable;
import java.util.List;

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

@Entity
@Table(name="roles")
public class Role implements Serializable {

	private static final long serialVersionUID = 7880251090236902000L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable = false, updatable = false)
	private int id;
	
	@Column(name="name")
	private String roleName;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "roles_newsperm", 
			   joinColumns = @JoinColumn (name = "roles_id"),
			   inverseJoinColumns = @JoinColumn (name = "news_permissions_id"))
	private List<NewsPermission> newsPermission;

	public Role() {}

	public Role(int id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<NewsPermission> getNewsPermission() {
		return newsPermission;
	}

	public void setNewsPermission(List<NewsPermission> newsPermission) {
		this.newsPermission = newsPermission;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
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
		Role other = (Role) obj;
		if (id != other.id)
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role: id = " + id + "\n" +
				"roleName: " + roleName + "\n" +
				"newsPermission: < " + newsPermission + " >\n";
	}
 
}