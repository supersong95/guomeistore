package com.guomei.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import com.guomei.conventer.MyConventer;
import com.guomei.entity.User;
import com.guomei.service.UserService;
import com.guomei.service.impl.UserServiceImpl;
import com.guomei.utils.MD5Utils;
import com.guomei.utils.UUIDUtils;



public class UserServlet extends BaseServlet {
	//跳转到注册界面
	public String registerUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/jsp/register.jsp";
	}
	//跳转到注册成功页
	public String register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, IllegalAccessException, InvocationTargetException {
		//1.封装用户类
		User user = new User();
		
		//注册自定义转化器
		ConvertUtils.register(new MyConventer(), Date.class);
		BeanUtils.populate(user, request.getParameterMap());
		
		//1.1 设置用户id
		user.setUid(UUIDUtils.getId());
		
		//1.2 设置激活码
		user.setCode(UUIDUtils.getCode());
		//md5加密用户密码
		user.setPassword(MD5Utils.md5(user.getPassword()));
		UserService service = new UserServiceImpl();
		service.add(user);
		return "/jsp/msg.jsp";
	}

}
