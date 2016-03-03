package com.lch.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lch.dao.INotificationDAO;
import com.lch.dao.impl.DepartmentDAO;
import com.lch.entity.NotiUser;
import com.lch.service.INotificationService;

@Transactional
@Component("NotificationService")
public class NotificationService implements INotificationService {
	@Resource(name="NotificationDAO")
	private INotificationDAO notificationDAO;
	@Override
	public List getNotificationsByUserId(int id) {
		// TODO Auto-generated method stub
		return notificationDAO.getNotificationsByUserId(id);
	}
	@Override
	public List<NotiUser> getMyPubNotis(int userId) {
		// TODO Auto-generated method stub
		return notificationDAO.getMyPubNotis(userId);
	}

}
