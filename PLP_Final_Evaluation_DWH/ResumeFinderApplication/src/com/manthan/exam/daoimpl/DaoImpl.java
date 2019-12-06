package com.manthan.exam.daoimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;

import com.manthan.exam.dao.Dao;
import com.manthan.exam.resumeinfobean.ResumeInfoBean;

public class DaoImpl implements Dao{

	@Override
	public String fetchMail(String filename,String file) {
		

		  StringTokenizer tokenizer = new StringTokenizer(file);
	      	
			while(tokenizer.hasMoreTokens()) {
				String ex=tokenizer.nextToken();
			    if(ex.contains("@") && (ex.contains(".com") || ex.contains(".in")) ){
			    	return ex;
			    } 		
			}
		
	return null;
	}
	
	@Override
	public String fetchNumber(String filename,String file) {
		
		   Pattern p = Pattern.compile("[+]?(91)?[-\\.\\s]?\\d{3}[-\\.\\s]?\\d{3}[-\\.\\s]?\\d{4}"); 

		      Matcher found = p.matcher(file);
		      String mobile;

		      if (found.find( )) {
		          mobile=found.group();
		          return mobile;
		       }
		return "0";
	}

	@Override
	public int fetchExperience(String filename,String file) {
			
		 Pattern p = Pattern.compile("[0-9][\\s]?[+][\\s]?(year|years)",Pattern.CASE_INSENSITIVE); // years may be in different case 

	      Matcher found = p.matcher(file);
	      String no;
	  	String e ="";

	      if (found.find( )) {
	          no=found.group();
	          String ss[]=no.split("");
	  		for(String i:ss) {
	  			try {
	  			
	  			    e=e+Integer.parseInt(i);
	  				
	  			}
	  			catch (Exception ee) {
	  			}
	  		
	  		}
	          return Integer.parseInt(e);
	       }
		
		
		return 0;
	}

	

	@Override
	public ResumeInfoBean searchAll(String filename,String value) {

		
		ResumeInfoBean resumeInfoBean = new ResumeInfoBean();
		Dao dao = new DaoImpl();
		File f= new File("D:\\Resumes\\"+filename);
		BodyContentHandler handler = new BodyContentHandler();
	      Metadata metadata = new Metadata();
	      FileInputStream inputstream = null;
		try {
			inputstream = new FileInputStream(f);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	      AutoDetectParser parser = new AutoDetectParser();
	      ParseContext pcontext = new ParseContext();
	      String email=null;
	      
			try {
				parser.parse(inputstream, handler, metadata,pcontext);
			} catch (Exception e) {
				f.delete();
			}
	
	      String file = handler.toString().replaceAll(",", " ").replaceAll("-", "").replaceAll(":", " ");
	      StringTokenizer tokenizer = new StringTokenizer(file);

	     
	      
		while(tokenizer.hasMoreTokens()) {
			String ex=tokenizer.nextToken();
			if(ex.equalsIgnoreCase(value)) {

				
				 email =dao.fetchMail(filename, file);
			resumeInfoBean.setEmail(email);
			String name=dao.fetchName(email, file);
			resumeInfoBean.setName(name);
				resumeInfoBean.setFilename(filename);
				if(email!=null && name!=null)
					return resumeInfoBean;
			}
	}
		
		return null;
}
	@Override
	public String fetchName(String email, String file) {

		StringTokenizer tokenizer = new StringTokenizer(file);
    	while(tokenizer.hasMoreTokens()) {
    		String ex2=tokenizer.nextToken();
    	
    		if(org.apache.commons.lang3.StringUtils.containsIgnoreCase(email, ex2) && !email.equals(ex2) && ex2.length()>3) {
    					return ex2 +" "+tokenizer.nextToken();
    			
		}
    		
    	}
		
		return null;
	}


	@Override
	public boolean isEmail(String keyword) {
		
		 if(keyword.contains("@") && (keyword.contains(".com") || keyword.contains(".in")) ){
		    	return true;
		    } 	
		
		return false;
	}






	@Override
	public boolean isNumber(String keyword) {
		  Pattern p = Pattern.compile("[+]?(91)?[-\\.\\s]?\\d{3}[-\\.\\s]?\\d{3}[-\\.\\s]?\\d{4}"); 
	      Matcher found = p.matcher(keyword);
	     if( found.matches()) {
	    	 return true;
	     }
		return false;
	}


	@Override
	public int isExperience(String keyword) {
		
		 Pattern p = Pattern.compile("[0-9][0-9]?[\\s]?[+][\\s]?(year|years)?",Pattern.CASE_INSENSITIVE); // years may be in different case 

	      Matcher found = p.matcher(keyword);
	      String no;
	      int n=0;
	  	String e ="";
	      if (found.find( )) {
	          no=found.group();
	          String ss[]=no.split("");
	  		for(String i:ss) {
	  			try {
	  			    e=e+Integer.parseInt(i);
	  			}
	  			catch (Exception ee) {
	  			}
	  		}
	  		n=Integer.parseInt(e);
	          return n;
	       }
		
		return n;
	}


	@Override
	public ResumeInfoBean searchAllWithSpace(String filename, String value) {
		
		 String email=null;
		 FileInputStream inputstream = null;
		ResumeInfoBean resumeInfoBean = new ResumeInfoBean();
		Dao dao = new DaoImpl();
		File f= new File("D:\\Resumes\\"+filename);
		BodyContentHandler handler = new BodyContentHandler();
	      Metadata metadata = new Metadata();
	      String val[]=value.split(" ");
	      	String first=val[0];
	      	String second =val[1];
			try {
				inputstream = new FileInputStream(f);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
	
	      AutoDetectParser parser = new AutoDetectParser();
	      ParseContext pcontext = new ParseContext();
	     
	      
			try {
				parser.parse(inputstream, handler, metadata,pcontext);
			} catch (Exception e) {
				f.delete();
			}
	
	      String file = handler.toString().replaceAll(",", " ").replaceAll("-", "").replaceAll(":", " ");
	      StringTokenizer tokenizer = new StringTokenizer(file);

		while(tokenizer.hasMoreTokens()) {
			String fir=tokenizer.nextToken();
			if(first.equalsIgnoreCase(fir)) {
				String sec=tokenizer.nextToken();
				if((second.length()<=5) && second.equalsIgnoreCase(sec) ) {
					 email =dao.fetchMail(filename, file);
						resumeInfoBean.setEmail(email);
						String name=dao.fetchName(email, file);
						resumeInfoBean.setName(name);
							resumeInfoBean.setFilename(filename);
							if(email!=null && name!=null)
								return resumeInfoBean;
				}else {
					if(Math.abs(second.length()-sec.length())<3) {
	 if(org.apache.commons.lang3.StringUtils.containsIgnoreCase(second, sec.substring(0, sec.length()-3))) {
				 email =dao.fetchMail(filename, file);
			resumeInfoBean.setEmail(email);
			String name=dao.fetchName(email, file);
			resumeInfoBean.setName(name);
				resumeInfoBean.setFilename(filename);
				if(email!=null && name!=null)
					return resumeInfoBean;
			}
				}
				}
	 // here else
			}
	 // here add if 
	}
		
		return null;
		
	}

	@Override
	public Connection getConnection() {
		Connection con=null;
		String dburl="jdbc:mysql://localhost:3306/Resumes";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(dburl,"root","root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
		
		return con;
	}

	@Override
	public int addAll(String name,String filename, String email, String mobile,int experience) {
		Dao dao= new DaoImpl();
		Connection con =dao.getConnection();
		PreparedStatement pstmt =null;
		int rs=0;
		String url=" insert into Resume(Name,Filename,Email,Mobile,Experience) values(?,?,?,?,?)";
		try {
			
		pstmt=con.prepareStatement(url);
		
		pstmt.setInt(5, experience);
		pstmt.setString(4, mobile);
		pstmt.setString(3, email);
		pstmt.setString(2, filename);
		pstmt.setString(1, name);
	 rs=pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
finally {
		
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return rs;
	}

	
	@Override
	public boolean delFile(String filename) {
          File f= new File("D:\\Resumes\\"+filename);
		f.delete();
		
		return false;
	}
}
