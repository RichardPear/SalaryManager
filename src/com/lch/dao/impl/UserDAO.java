package com.lch.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lch.dao.IUserDAO;
import com.lch.entity.User;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.lch.entity.User
 * @author MyEclipse Persistence Tools
 */
@Repository("UserDAO")
public class UserDAO implements IUserDAO{// extends HibernateDaoSupport 
	private static final Log log = LogFactory.getLog(UserDAO.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";

	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession(){
		return sessionFactory.openSession();
	}
	public void save(User u) {
		log.debug("saving User instance");
		try {
			Session session = this.getSession();
			session.save(u);
			session.close();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		String hql = "from User";
		Session session = this.getSession();
		List list = session.createQuery(hql).list();
		session.close();
		if(list.size() == 0)
			return null;
		return (User)list.get(0);
	}

	@Override
	public List findByUsername(Object username) {
		// TODO Auto-generated method stub
		String hql = "from User where username=?";
		Session session = this.getSession();
		List list = session.createQuery(hql).setString(0, username.toString()).list();
		session.close();
		return list;
	}
}