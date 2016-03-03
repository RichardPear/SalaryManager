package com.lch.dao;

import java.util.List;

import com.lch.entity.NotiUser;

public interface INotificationDAO {
	public List getNotificationsByUserId(int id);

	public List<NotiUser> getMyPubNotis(int userId);
}
