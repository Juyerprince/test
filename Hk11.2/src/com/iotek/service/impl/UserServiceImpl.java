package com.iotek.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.dao.UserDao;
import com.iotek.entity.User;
import com.iotek.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User queryUserByName2Pwd(String userName, String pwd) {

		return userDao.queryUserByName2Pwd(userName, pwd);
	}

	@Override
	public boolean regist(String userName, String pwd) {
		User user = userDao.queryUserByName(userName);
		if (user == null) {
			userDao.saveUser(userName, pwd);
			return true;
		}
		return false;
	}

}
