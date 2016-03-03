package com.lch.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer deptno;
	private String name;
	private Set users = new HashSet(0);
	private Set positions = new HashSet(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(Integer deptno, String name) {
		this.deptno = deptno;
		this.name = name;
	}

	/** full constructor */
	public Department(Integer deptno, String name, Set users, Set positions) {
		this.deptno = deptno;
		this.name = name;
		this.users = users;
		this.positions = positions;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDeptno() {
		return this.deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

	public Set getPositions() {
		return this.positions;
	}

	public void setPositions(Set positions) {
		this.positions = positions;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptno=" + deptno + ", name=" + name
				+ ", users=" + users + ", positions=" + positions + "]";
	}

}