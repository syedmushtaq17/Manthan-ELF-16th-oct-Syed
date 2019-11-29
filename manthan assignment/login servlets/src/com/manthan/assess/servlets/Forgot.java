package com.manthan.assess.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.assess.beans.userinfo;
import com.manthan.assess.dao.Dao;
import com.manthan.assess.daoimpl.Daoimpl;

@WebServlet("/forgottestservlet")
public class Forgot extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		HttpSession session=req.getSession(false);
		PrintWriter out=resp.getWriter();
		userinfo user=new userinfo();
		Dao dao=new Daoimpl();
		String name=req.getParameter("username");
		String pass=req.getParameter("password");
		String cpass=req.getParameter("cpassword");
		
		out.print("<html>");
		out.print("<body>");
		if(session!=null) {
		if(pass.equals(cpass)) {
			if(dao.updatepass(name, pass)>=1) {
			req.setAttribute("msg", "Password Updated Successfully");
			out.print("<h2>Password Updated Successfully</h2>");
			}
			else {
				req.setAttribute("msg", "Invalid Username");
				req.getRequestDispatcher("./forgot").forward(req, resp);
			
			}
			}
			
		
		else {
			req.setAttribute("msg", "Password Does Not Match");
			req.getRequestDispatcher("./forgot").forward(req, resp);
		
			 
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
