package com.dxc.zurich.innovation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@SequenceGenerator(name = "role_sequence", sequenceName = "role_id_seq")
public class Role extends AbstractEntity {
	
	private static final long serialVersionUID = 7422574264557894633L;
	private Integer id;
	private String roleID;
	private String roleName;
	private List<User> users;
	private List<Privilege> privileges;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "role_sequence")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getRoleID() {
		return roleID;
	}
	
	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}
	
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@ManyToMany
	public List<User> getUsers() {
		return users;
	}
	
	public void addUser(User user) {
	      if (!getUsers().contains(user)) {
	          getUsers().add(user);
	      }
	      if (!user.getRoles().contains(this)) {
	          user.getRoles().add(this);
	      }
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	@ManyToMany
	public List<Privilege> getPrivileges() {
		return privileges;
	}
	
	public void addPrivilege(Privilege privilege) {
	      if (!getPrivileges().contains(privilege)) {
	          getPrivileges().add(privilege);
	      }
	      if (!privilege.getRoles().contains(this)) {
	    	  privilege.getRoles().add(this);
	      }
	}
	
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
}