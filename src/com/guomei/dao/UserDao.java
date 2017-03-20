package com.guomei.dao;

import java.sql.SQLException;

import com.guomei.entity.User;

public interface UserDao {
	public void add(User user) throws SQLException;

}
