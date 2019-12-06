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

@WebServlet("/searchservlet")
public class Search extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession(false);
		Dao dao=new DaoImpl();
		if(session!=null) {
			ArrayList<ProductInfo> al = new ArrayList<ProductInfo>();
			int id=Integer.parseInt(req.getParameter("search"));
			
			
			al=dao.searchProduct(id);
			session.setAttribute("id", id);
			
			req.setAttribute("al", al);
			req.getRequestDispatcher("./search").forward(req, resp);
			
		}else {
			req.setAttribute("msg", " Login First");
			  req.getRequestDispatcher("./login").forward(req, resp);
		}
		
	
	
	}
}
