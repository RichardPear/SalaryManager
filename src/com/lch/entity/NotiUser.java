package com.lch.entity;

/**
 * NotiUser entity. @author MyEclipse Persistence Tools
 */

public class NotiUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Notification notification;
	private Integer status;

	// Constructors

	/** default constructor */
	public NotiUser() {
	}

	/** full constructor */
	public NotiUser(User user, Notification notification, Integer status) {
		this.user = user;
		this.notification = notification;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Notification getNotification() {
		return this.notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "NotiUser [id=" + id + ", user=" + user + ", notification="
				+ notification + ", status=" + status + "]";
	}

}