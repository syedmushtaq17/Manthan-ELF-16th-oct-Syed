package com.manthan.flipkart.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.flipkart.dao.Dao;
import com.manthan.flipkart.daoimpl.DaoImpl;

@WebServlet("/buyservlet")
public class Buy extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		Dao dao=new DaoImpl();
		if(session!=null) {
		int  productid=(int) session.getAttribute("id");
		int userid= (int) session.getAttribute("userid");
		Double price = dao.price(productid);
		
	     if(dao.addOrder(productid, userid, price)) {
	    	 req.setAttribute("msg", " Product Added Successfully ");
	    	 req.getRequestDispatcher("./search").forward(req, resp);
	     }
		
		
		
		}
		else {
			req.setAttribute("msg", " Login First");
			  req.getRequestDispatcher("./login").forward(req, resp);
		}
	
	}
	
}
