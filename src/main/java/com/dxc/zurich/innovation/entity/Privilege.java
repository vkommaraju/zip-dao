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
@Table(name = "privileges")
@SequenceGenerator(name = "privilege_sequence", sequenceName = "privilege_id_seq")
public class Privilege extends AbstractEntity {
	
	private static final long serialVersionUID = 7422574264557894633L;
	private Integer id;
	private String privilegeID;
	private String privilege;
	private String URL;
	private List<Role> roles;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "privilege_sequence")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPrivilegeID() {
		return privilegeID;
	}
	public void setPrivilegeID(String privilegeID) {
		this.privilegeID = privilegeID;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	
	@ManyToMany(mappedBy = "privileges") 
	public List<Role> getRoles() {
		return roles;
	}
	
	public void addRole(Role role) {
	    if (!getRoles().contains(role)) {
	        getRoles().add(role);
	    }
	    if (!role.getPrivileges().contains(this)) {
	    	role.getPrivileges().add(this);
	    }
	}
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}