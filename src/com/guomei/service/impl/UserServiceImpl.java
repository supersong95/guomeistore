package com.guomei.service.impl;

import java.sql.SQLException;

import com.guomei.dao.UserDao;
import com.guomei.dao.impl.UserDaoImpl;
import com.guomei.entity.User;
import com.guomei.service.UserService;

public class UserServiceImpl implements UserService{
	UserDao dao = new UserDaoImpl();

	@Override
	public void add(User user) throws SQLException {
		dao.add(user);
	}

}
