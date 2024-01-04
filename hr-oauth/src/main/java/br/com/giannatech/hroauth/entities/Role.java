package br.com.giannatech.hroauth.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Role implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Role() {}
	
	public Role(Long id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}

	private Long id;
	
	private String roleName;
	
	private Set<Role> roles = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
