package com.guomei.service;

import java.sql.SQLException;

import com.guomei.entity.User;

public interface UserService {

	public void add(User user) throws SQLException;
}
