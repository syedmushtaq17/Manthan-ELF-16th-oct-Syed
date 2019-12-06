package com.manthan.exam.servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.manthan.exam.dao.Dao;
import com.manthan.exam.daoimpl.DaoImpl;
import com.manthan.exam.resumeinfobean.ResumeInfoBean;

@WebServlet("/searchservlet")
public class Search extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Dao dao =new DaoImpl();
		File files[] = new File("D:\\Resumes").listFiles();
		ResumeInfoBean resumeInfoBean =new ResumeInfoBean();
		String contents=req.getParameter("search");

		//is blank works from java11.
		if(contents.isBlank()) {
			req.setAttribute("msg", "Please Enter  Keywords to Search");
			req.getRequestDispatcher("./search").forward(req, resp);
			}
		else {
		String c[] =contents.split(",");
		boolean present =false;
		int conlength=c.length;
		
		ArrayList<ResumeInfoBean> al = new ArrayList<ResumeInfoBean>();
		
	  for(File file : files ) {
		  if(file.isFile()) {
			  int presentlength=0;
			  // file is absolute file path
			 String fname=file.getName();           //   "file name only"
			 for(String i:c) {
				 
					String con=i.trim();
					String cont=con.replace("-", "");
					if(cont.contains(" ")) {
						try {
							resumeInfoBean = dao.searchAllWithSpace(fname, cont);
						} catch (Exception e) {
							file.delete();
							e.printStackTrace();
						}
						if(resumeInfoBean!=null) {
							presentlength++;
							present =true;
						}
						 if(resumeInfoBean!=null && conlength==presentlength) {
							 al.add(resumeInfoBean);
							 presentlength=0;
						 }
					}
					else {
					try {
						resumeInfoBean = dao.searchAll(fname, cont);
					} catch (Exception e) {
						file.delete();
						e.printStackTrace();
						
					}
					if(resumeInfoBean!=null) {
						
						presentlength++;
						present =true;
					}
					 if(resumeInfoBean!=null && conlength==presentlength) {
						 al.add(resumeInfoBean);
						 presentlength=0;
					 }
					}
					 //here else ends
				}
			
		  }
	  }
	  if(present) {
	  req.setAttribute("al", al);
		req.getRequestDispatcher("./search").forward(req, resp);
	  }
	  else {
		  req.setAttribute("msg", "Sorry!  Unable to Find. Please try again with different keywords");
		  try {
			req.getRequestDispatcher("./search").forward(req, resp);
		} catch (Exception e) {
		}
	  }
	}
	}
}
