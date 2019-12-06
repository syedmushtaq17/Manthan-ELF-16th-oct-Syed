package com.manthan.flipkart.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.flipkart.dao.Dao;
import com.manthan.flipkart.daoimpl.DaoImpl;
import com.manthan.flipkart.productinfobean.ProductInfo;
import com.manthan.flipkart.userinfobean.UserInfo;

@WebServlet("/logins")
public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ArrayList<ProductInfo> al = new ArrayList<ProductInfo>();
		HttpSession session=req.getSession(true);
		
	
		
		UserInfo user=new UserInfo();
		Dao dao=new DaoImpl();
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
	user=dao.login(email, password);
	  if(user!=null){
		  al=dao.search();
		  
		  System.out.println("INnn");
		  session.setAttribute("userid", user.getUserid());
		  req.setAttribute("msg", "Welcome "+user.getEmail());
		  req.setAttribute("al", al);
		  req.getRequestDispatcher("./homepage").forward(req, resp);
	  }
	  else
	  {
		  
		  req.setAttribute("msg", "Invaliddddd Login Credentials");
		  req.getRequestDispatcher("./login").forward(req, resp);
	  }
		
	
	
	}

}
