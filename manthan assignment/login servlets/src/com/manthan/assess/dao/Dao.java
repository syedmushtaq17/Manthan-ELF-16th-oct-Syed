package com.manthan.assess.dao;

import java.sql.ResultSet;

import com.manthan.assess.beans.userinfo;

public interface Dao {

	public boolean  authenticate(String name,String password);
	
	public int updatepass(String name,String password);
	
	public userinfo add(userinfo user);
	
 
	
	
}
