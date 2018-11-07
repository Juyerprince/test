package com.iotek.service;

import com.iotek.entity.User;

public interface UserService {
	public User queryUserByName2Pwd(String userName, String pwd);

	public boolean regist(String userName, String pwd);
}
