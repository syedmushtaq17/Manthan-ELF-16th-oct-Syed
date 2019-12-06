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
import com.manthan.flipkart.orderinfo.OrderInfo;

@WebServlet("/ordeshistoryservlet")
public class OrderHistory extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		ArrayList<OrderInfo> al = new ArrayList<OrderInfo>();
		Dao dao=new DaoImpl();
		if(session!=null) {	
		OrderInfo order = new OrderInfo();
			int userid=(int) session.getAttribute("userid");
			
	al=	dao.searchOrder(userid);
	req.setAttribute("al", al);
	req.getRequestDispatcher("./order").forward(req, resp);
	
	
	}
		else {
			req.setAttribute("msg", " Login First");
			  req.getRequestDispatcher("./login").forward(req, resp);
		}
}
}
