package com.lch.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * Notification entity. @author MyEclipse Persistence Tools
 */

public class Notification implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String title;
	private String content;
	private Integer status;
	private Timestamp createTime;
	private Set notiUsers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Notification() {
	}

	/** minimal constructor */
	public Notification(User user, String title, String content,
			Integer status, Timestamp createTime) {
		this.user = user;
		this.title = title;
		this.content = content;
		this.status = status;
		this.createTime = createTime;
	}

	/** full constructor */
	public Notification(User user, String title, String content,
			Integer status, Timestamp createTime, Set notiUsers) {
		this.user = user;
		this.title = title;
		this.content = content;
		this.status = status;
		this.createTime = createTime;
		this.notiUsers = notiUsers;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public Timestamp getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Set getNotiUsers() {
		return this.notiUsers;
	}

	public void setNotiUsers(Set notiUsers) {
		this.notiUsers = notiUsers;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", user=" + user + ", title=" + title
				+ ", content=" + content + ", status=" + status
				+ ", createTime=" + createTime + ", notiUsers=" + notiUsers
				+ "]";
	}

}