package com.manthan.assess.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.assess.beans.userinfo;
import com.manthan.assess.dao.Dao;
import com.manthan.assess.daoimpl.Daoimpl;

@WebServlet("/resetser")
public class Register extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     Dao dao =new Daoimpl();
    userinfo user =new userinfo();
    HttpSession session=req.getSession(false);
	PrintWriter out=resp.getWriter();
    user.setUsername(req.getParameter("username"));
    user.setPassword(req.getParameter("password"));
    user.setAge(Integer.parseInt(req.getParameter("age")));
    user.setGender(req.getParameter("gender"));
    String pass=req.getParameter("password");
    out.print("<html>");
	out.print("<body>");
	Pattern pat =Pattern.compile("[^a-zA-Z0-9]");
	Matcher match =pat.matcher(pass);
	if(match.find()) {
		if(dao.add(user)!=null) {
			System.out.println("inside add");
			out.print("<h2>User Registered Successfully</h2>");
			
			
		}
		else {
			out.print("<h2>Failed to Register</h2>");
		}
	}
	else {
		out.print("<h2>Password Must Contain Special Caharacter</h2>");
		req.setAttribute("msg","Password Must Contain Special Caharacter" );
		req.getRequestDispatcher("./reset").forward(req, resp);
	}
	}
	

	}
	
	

