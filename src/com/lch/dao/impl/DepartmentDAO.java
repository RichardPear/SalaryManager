package com.lch.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lch.dao.IDepartmentDAO;
import com.lch.entity.Department;
import com.lch.entity.User;
@Repository("DepartmentDAO")
public class DepartmentDAO implements IDepartmentDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession(){
		return sessionFactory.openSession();
	}
	@Override
	public Department findById(Integer id) {
		// TODO Auto-generated method stub
		String hql = "from Department";
		Session session = this.getSession();
		List list = session.createQuery(hql).list();
		session.clear();
		if(list.size() == 0)
			return null;
		return (Department)list.get(0);
	}

	@Override
	public void save(Department d) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.save(d);
		session.close();
	}
	@Override
	public List listDept() {
		// TODO Auto-generated method stub
		String hql = "from Department";
		Session session = this.getSession();
		List list = session.createQuery(hql).list();
		session.close();
		return list;
	}

}
