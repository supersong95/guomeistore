package com.guomei.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通用的srvlet
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Class clazz = this.getClass();
		String methodName = request.getParameter("method");
		if(methodName == null){
			methodName = "index";
		}
		
		 try {
			Method method = clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			
			String path =  (String) method.invoke(this,request,response);
		   if(path!=null){
			   request.getRequestDispatcher(path).forward(request, response);
		   }
		 } catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
}
