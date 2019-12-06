package com.manthan.flipkart.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manthan.flipkart.dao.Dao;
import com.manthan.flipkart.daoimpl.DaoImpl;
import com.manthan.flipkart.userinfobean.UserInfo;

@WebServlet("/registerservlet")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		UserInfo user=new UserInfo();
		Dao dao=new DaoImpl();
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String name =req.getParameter("username");
		int id=Integer.parseInt(req.getParameter("userid"));
		
		user.setEmail(email);
		user.setUsername(name);
		user.setPassword(password);
		user.setUserid(id);
		
		if(dao.addUser(user)) {
			
			req.setAttribute("msg","User Register Successfully \n Welcome user "+name +"  login to continue" );
			req.getRequestDispatcher("./login").forward(req, resp);
		}
		else {
			req.setAttribute("msg","Failed to register" );
			req.getRequestDispatcher("./register").forward(req, resp);
		}
	
	}
	
	
	
}
