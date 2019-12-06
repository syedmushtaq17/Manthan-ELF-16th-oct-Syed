package com.manthan.dao;

import java.sql.Connection;

public interface Dao {

	public int add(int id);
	public int remove(int id);
	
	public int modify(int id,String name,double price);
	public void showAll();
	public double dispBill();
	public Connection getConnection();
	public double userbill();
	public int addFood(int id,String name,double price);
	public double totbill();
	
	public double addbill(double sum);
}
