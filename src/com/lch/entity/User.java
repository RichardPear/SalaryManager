package com.lch.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private Department department;
	private String username;
	private String password;
	private String realname;
	private String telephone;
	private String email;
	private Integer sex;
	private Set notifications = new HashSet(0);
	private Set notiUsers = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, String password, Integer sex) {
		this.username = username;
		this.password = password;
		this.sex = sex;
	}

	/** full constructor */
	public User(Department department, String username, String password,
			String realname, String telephone, String email, Integer sex,
			Set notifications, Set notiUsers) {
		this.department = department;
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.telephone = telephone;
		this.email = email;
		this.sex = sex;
		this.notifications = notifications;
		this.notiUsers = notiUsers;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Set getNotifications() {
		return this.notifications;
	}

	public void setNotifications(Set notifications) {
		this.notifications = notifications;
	}

	public Set getNotiUsers() {
		return this.notiUsers;
	}

	public void setNotiUsers(Set notiUsers) {
		this.notiUsers = notiUsers;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", department=" + department + ", username="
				+ username + ", password=" + password + ", realname="
				+ realname + ", telephone=" + telephone + ", email=" + email
				+ ", sex=" + sex + ", notifications=" + notifications
				+ ", notiUsers=" + notiUsers + "]";
	}

}