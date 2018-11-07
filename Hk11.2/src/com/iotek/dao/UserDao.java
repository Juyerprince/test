package com.iotek.dao;

import com.iotek.entity.User;

public interface UserDao {
	public User queryUserByName2Pwd(String userName, String pwd);

	public User queryUserByName(String userName);

	public void saveUser(String userName, String pwd);
}
