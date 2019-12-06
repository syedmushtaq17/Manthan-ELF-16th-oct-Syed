package com.manthan.exam.servlets;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  
      
    @WebServlet("/downloadservlet")
    public class Download extends HttpServlet {  
      
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
                throws ServletException, IOException {  
      
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    String filename = request.getParameter("filename");  
    String filepath = "D:\\Resumes\\";   
    response.setContentType("APPLICATION/OCTET-STREAM");   
    response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
      
    FileInputStream fileInputStream = new FileInputStream(filepath + filename);  
                
    int i;   
    while ((i=fileInputStream.read()) != -1) {  
    out.write(i);   
    }   
    fileInputStream.close();   
    out.close();   
    }  
      
    }  