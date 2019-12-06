package com.manthan.exam.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manthan.exam.dao.Dao;
import com.manthan.exam.daoimpl.DaoImpl;
import com.oreilly.servlet.MultipartRequest;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;

@WebServlet("/uploadservlet")
public class Upload extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MultipartRequest m = null;
		try {
					m=new MultipartRequest(req, "D:\\Resumes");
					
		}
		catch (IOException e) {
			req.setAttribute("msg", " Upload file Less than 1mb only  ");
			 req.getRequestDispatcher("./upload").forward(req, resp);
		}
		
		Dao dao =new DaoImpl();
		 String mobile="";
		String filename=m.getOriginalFileName("fname");
		BodyContentHandler handler = new BodyContentHandler();
	      Metadata metadata = new Metadata();
	      File f = new File("D:\\Resumes\\"+filename);
	      System.out.println(f);
	      FileInputStream inputstream = new FileInputStream(f);
	      AutoDetectParser parser = new AutoDetectParser();
	      ParseContext parsecontext = new ParseContext();
	      String email=null,fullname=null;
	      try {
			parser.parse(inputstream, handler, metadata,parsecontext);
		} 
	      catch (Exception e) {
	    	 
	    	  dao.delFile(filename);
		}
	    
	      String file = handler.toString().replaceAll(",", " ");

	      
	   email =dao.fetchMail(filename,file);
	      if(email!=null) {
	    	   fullname =dao.fetchName(email, file);
	    	   mobile=dao.fetchNumber(filename, file);
		 	      int experience =dao.fetchExperience(filename, file);
		 	      if(fullname!=null && mobile!=null)
		 	      dao.addAll(fullname, filename,email, mobile, experience);
		 	      
	    	   req.setAttribute("msg", " Your Resume Uploaded Successfully  ");
	    	  
	    	   
    }else {
    	 dao.delFile(filename);
	    	  		 req.setAttribute("msg", "invalid Resume format");
	      }
	      
	      
	      req.getRequestDispatcher("./upload").forward(req, resp);
     
     
	
	}
}
