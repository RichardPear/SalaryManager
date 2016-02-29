package com.lch.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.lch.dao.IUserDAO;
import com.lch.entity.User;
import com.lch.service.IUserService;

@Transactional
@Component("UserService")
public class UserService implements IUserService {
	@Resource(name="UserDAO")
	private IUserDAO userDAO;
	@Override
	public User getUserBuId(Integer id) {
		return userDAO.findById(id);
	}

	@Override
	public User getUserByUsername(String username) {
		List<User> list = userDAO.findByUsername(username);
		if(list.size() == 0){
			return null;
		}else{
			return (User)list.get(0);
		}
	}

	@Override
	public void addUser(User u) {
		userDAO.save(u);
	}

}
