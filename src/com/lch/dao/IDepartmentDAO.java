package com.lch.dao;

import java.util.List;

import com.lch.entity.Department;
import com.lch.entity.User;

public interface IDepartmentDAO {
	public Department findById(Integer id);
	public void save(Department d);
	public List listDept();
}
