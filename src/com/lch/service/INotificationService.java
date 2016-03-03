package com.lch.service;

import java.util.List;

import com.lch.entity.NotiUser;

public interface INotificationService {
	public List getNotificationsByUserId(int id);

	public List<NotiUser> getMyPubNotis(int userId);
}
