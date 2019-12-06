package com.manthan.exam.dao;

import java.sql.Connection;

import com.manthan.exam.resumeinfobean.ResumeInfoBean;

public interface Dao {

	public String fetchMail(String filename,String file);
	
	public String fetchNumber(String filename,String file);
	
	public	int fetchExperience(String filename,String file);
	
	public boolean delFile(String filename);
	public	String fetchName(String email,String file);
	
	public ResumeInfoBean searchAll(String filename,String value);
	public ResumeInfoBean searchAllWithSpace(String filename,String value);
	
	public boolean isEmail(String keyword);
	public boolean isNumber(String keyword);
	public int isExperience(String keyword);
	public	Connection getConnection();
	public int addAll(String name,String filename,String email,String mobile,int experience);
	
}
