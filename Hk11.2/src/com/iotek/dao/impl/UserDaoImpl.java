package com.iotek.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iotek.dao.UserDao;
import com.iotek.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	// 获取和当前线程绑定的Seesion
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public User queryUserByName2Pwd(String userName, String pwd) {
		String hql = "from User where userName =? and pwd = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, userName);
		query.setParameter(1, pwd);
		User user = (User) query.uniqueResult();
		return user;
	}

	@Override
	public void saveUser(String userName, String pwd) {
		Session session = getSession();
		User user = new User();
		user.setUserName(userName);
		user.setPwd(pwd);
		session.save(user);

	}

	@Override
	public User queryUserByName(String userName) {
		String hql = "from User where userName =?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, userName);
		User user = (User) query.uniqueResult();
		return user;
	}

}
