package com.manthan.assess.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.manthan.assess.beans.userinfo;
import com.manthan.assess.dao.Dao;

public class Daoimpl implements Dao{

	@Override
	public boolean authenticate(String name, String password) {
   
		
		boolean at=false;
		Connection con=null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String db="jdbc:mysql://localhost:3306/login";
			con=DriverManager.getConnection(db,"root","root");
			String url="select * from userinfo where username=? and password =?";
			pstmt=con.prepareStatement(url);
			
					pstmt.setString(1, name);
		pstmt.setString(2, password);
		 rs=pstmt.executeQuery();
		 
			
			if(rs.next())
				at=true;
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			
			
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
		
		System.out.println(at);
		return at;
	}

	@Override
	public int updatepass(String name, String password) {

		boolean up=false;
		int rs=0;
		Connection con=null;
		PreparedStatement pstmt =null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String db="jdbc:mysql://localhost:3306/login";
			con=DriverManager.getConnection(db,"root","root");
			String url="update userinfo set password=? where username=?";
			pstmt=con.prepareStatement(url);
			
			pstmt.setString(1, password);
			pstmt.setString(2, name);
			 rs=pstmt.executeUpdate();
			if(rs>=1)
				up=true;
			
			System.out.println(rs);
			
			
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
	public userinfo add(userinfo user) {

		userinfo user1=new userinfo();
		boolean at=false;
		Connection con=null;
		PreparedStatement pstmt =null;
		int rs=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String db="jdbc:mysql://localhost:3306/login";
			con=DriverManager.getConnection(db,"root","root");
			String url=" insert into userinfo values(?,?,?,?)";
			pstmt=con.prepareStatement(url);
			String name=user.getUsername();
			String pass=user.getPassword();
			 int age=user.getAge();
			String gender=user.getGender();

			pstmt.setString(4, gender);
			pstmt.setInt(3, age);
			pstmt.setString(2, pass);
			pstmt.setString(1, name);
		 rs=pstmt.executeUpdate();
			
			if(rs>=1)
				at=true;
			
			
			
			
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
		
		
		return user1;
		
		
	}
	

}
