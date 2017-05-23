package com.dxc.zurich.innovation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
@SequenceGenerator(name = "user_role_sequence", sequenceName = "user_role_id_seq")
public class UserRole extends AbstractEntity {
	
	private static final long serialVersionUID = 7422574264557894633L;
	private Integer id;
	private Role role;
	private User user;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "user_role_sequence")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@JoinColumn(name = "role", referencedColumnName = "id")
	@ManyToOne
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@JoinColumn(name = "user", referencedColumnName = "id")
	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}