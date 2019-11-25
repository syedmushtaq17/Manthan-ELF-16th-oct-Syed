package com.manthan.assess.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.assess.beans.userinfo;
import com.manthan.assess.dao.Dao;
import com.manthan.assess.daoimpl.Daoimpl;

@WebServlet("/logintestservlet")
public class logintestservlet extends HttpServlet{

	
	int count=0;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession(true);
		PrintWriter out=resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		
		if(session!=null) {
			
			
		
		userinfo user=new userinfo();
		Dao dao=new Daoimpl();
		String name=req.getParameter("username");
		String pass=req.getParameter("password");
		
	
	  if(dao.authenticate(name, pass)){
		  
		  System.out.println("in authenticate");
		  req.setAttribute("msg", "Welcome "+name);
		  
		  req.getRequestDispatcher("./logintest2").forward(req, resp);
	  }
	  else
	  {
		  System.out.println(++count);
		
		  if(count>=4) {
			  System.out.println(count);
			  req.setAttribute("msg", "You are blocked try later");
		  }
		  else {
		  req.setAttribute("msg", "Invaliddddd Login Credentials");
		  }
		  
		  req.getRequestDispatcher("./logintest").forward(req, resp);
	  }
	
	}
		else {
			req.setAttribute("msg", " Login First");
			  req.getRequestDispatcher("./logintest").forward(req, resp);
		}
		
		out.print("</body>");
		out.print("</html>");
	}
	
	
}
