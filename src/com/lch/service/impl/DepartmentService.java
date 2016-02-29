package com.lch.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lch.dao.impl.DepartmentDAO;
import com.lch.entity.Department;
import com.lch.service.IDepartmentService;

@Transactional
@Component("DepartmentService")
public class DepartmentService implements IDepartmentService {
	@Resource(name="DepartmentDAO")
	private DepartmentDAO departmentDAO;
	@Override
	public List<Department> listDepartment() {
		// TODO Auto-generated method stub
		return departmentDAO.listDept();
	}

}
