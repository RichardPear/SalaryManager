package com.lch.entity;

/**
 * Position entity. @author MyEclipse Persistence Tools
 */

public class Position implements java.io.Serializable {

	// Fields

	private Integer id;
	private Department department;
	private String name;

	// Constructors

	/** default constructor */
	public Position() {
	}

	/** minimal constructor */
	public Position(String name) {
		this.name = name;
	}

	/** full constructor */
	public Position(Department department, String name) {
		this.department = department;
		this.name = name;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", department=" + department + ", name="
				+ name + "]";
	}

}