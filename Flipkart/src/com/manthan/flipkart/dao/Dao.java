package com.manthan.flipkart.dao;

import java.util.ArrayList;

import com.manthan.flipkart.orderinfo.OrderInfo;
import com.manthan.flipkart.productinfobean.ProductInfo;
import com.manthan.flipkart.userinfobean.UserInfo;

public interface Dao {
	boolean addUser(UserInfo userinfo);
	UserInfo login(String email,String Password);
	boolean  addOrder(int ProductId,int UserId,double Price);
	ArrayList<ProductInfo> search();
  Double price(int productid);
  ArrayList<ProductInfo> searchProduct(int id);
  ArrayList<OrderInfo> searchOrder(int id);
}
