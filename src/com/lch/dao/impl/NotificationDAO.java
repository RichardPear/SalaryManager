package com.lch.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lch.dao.INotificationDAO;
import com.lch.entity.NotiUser;
import com.lch.entity.User;
@Repository("NotificationDAO")
public class NotificationDAO implements INotificationDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession(){
		return sessionFactory.openSession();
	}
	@Override
	public List getNotificationsByUserId(int id) {
		// TODO Auto-generated method stub
		User u = new User();
		u.setId(id);
		String hql = "from NotiUser where user=? and notification.status=1";//1Õý³£0É¾³ý2½ûÓÃ
		Session session = this.getSession();
		Query q = session.createQuery(hql);
		q.setParameter(0, u);
		List list = q.list();
		session.close();
		return list;
	}
	@Override
	public List<NotiUser> getMyPubNotis(int userId) {
		// TODO Auto-generated method stub
		User u = new User();
		u.setId(userId);
		String hql = "from Notification where user=?";
		Session session = this.getSession();
		Query q = session.createQuery(hql);
		q.setParameter(0, u);
		List list = q.list();
		session.close();
		return list;
	}

}
