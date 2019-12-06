package com.manthan.flipkart.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.manthan.flipkart.dao.Dao;
import com.manthan.flipkart.orderinfo.OrderInfo;
import com.manthan.flipkart.productinfobean.ProductInfo;
import com.manthan.flipkart.userinfobean.UserInfo;

public class DaoImpl implements Dao{

	@Override
	public boolean addUser(UserInfo userinfo) {
		
		UserInfo user=new UserInfo();
		boolean at=false;
		Connection con=null;
		PreparedStatement pstmt =null;
		int rs=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String db="jdbc:mysql://localhost:3306/Flipkart";
			con=DriverManager.getConnection(db,"root","root");
			String url=" insert into user_info values(?,?,?,?)";
			pstmt=con.prepareStatement(url);
			String name=user.getUsername();
			String pass=user.getPassword();
			 int userid = user.getUserid();
			String email = user.getEmail();
			System.out.println(email);
			
			pstmt.setString(3,email );
			pstmt.setInt(1, userid);
			pstmt.setString(4, pass);
			pstmt.setString(2, name);
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
		
		return at;
	}

	@Override
	public UserInfo login(String email, String Password) {
		
		boolean at=false;
		Connection con=null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		UserInfo user = new UserInfo();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String db="jdbc:mysql://localhost:3306/Flipkart";
			con=DriverManager.getConnection(db,"root","root");
			String url="select * from user_info where Email=? and Password =?";
			pstmt=con.prepareStatement(url);
			
					pstmt.setString(1, email);
		pstmt.setString(2, Password);
		 rs=pstmt.executeQuery();
		 
			
			if(rs.next()) {
				
				System.out.println("is not null ");
				
				user.setUserid(rs.getInt("UserId"));
				user.setUsername(rs.getString("UserName"));
				user.setEmail(rs.getString("Email"));
				user.setPassword(rs.getString("Password"));
				
				at=true;
			
			}
			
			
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
		if(at)
		return user;
		
		return null;
		
		
	}

	
	@Override
	public ArrayList<ProductInfo> search() {
		ArrayList<ProductInfo> al = new ArrayList<ProductInfo>();
		Connection con=null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		ProductInfo productInfo = new ProductInfo();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String db="jdbc:mysql://localhost:3306/Flipkart";
			con=DriverManager.getConnection(db,"root","root");
			String url="select * from product_info";
			pstmt=con.prepareStatement(url);
			
				
		 rs=pstmt.executeQuery();
		 
			
			while(rs.next()) {
				
				System.out.println("is not null ");
				productInfo.setProductname(rs.getString("ProductName"));
				productInfo.setProductid(rs.getInt("ProductID"));
				productInfo.setProductcost(rs.getDouble("ProductCost"));
				productInfo.setProductcolor(rs.getString("ProductColor"));
				productInfo.setNop(rs.getInt("NumberOfProducts"));
				productInfo.setDescription(rs.getString("Description"));
				
				al.add(productInfo);
			
			}
			
			
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
		return al;
	}

	@Override
	public Double price(int productid) {
		
		Connection con=null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		ProductInfo productInfo = new ProductInfo();
		Double price=0.0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String db="jdbc:mysql://localhost:3306/Flipkart";
			con=DriverManager.getConnection(db,"root","root");
			String url="select * from Order_info";
			pstmt=con.prepareStatement(url);
			
				
		 rs=pstmt.executeQuery();
		 
			
		 	if(rs.next()) {
				 price=rs.getDouble("Price");
			
			}
			
			
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
		return price;
	}

	@Override
	public boolean addOrder(int productid,int userid,double price) {

		Connection con=null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		ProductInfo productInfo = new ProductInfo();
		boolean at=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String db="jdbc:mysql://localhost:3306/Flipkart";
			con=DriverManager.getConnection(db,"root","root");
			String url="insert into Order_info(ProductId,UserId,Price) values (?,?,?)";
			pstmt=con.prepareStatement(url);
			
				pstmt.setInt(1, productid);
				pstmt.setInt(2, userid);
				pstmt.setDouble(3, price);
		 rs=pstmt.executeQuery();
		 
			
		 	if(rs.next()) {
				 
			
			}
			
			
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
		
		
		return at;
	}

	@Override
	public ArrayList<ProductInfo> searchProduct(int id) {
		ArrayList<ProductInfo> al = new ArrayList<ProductInfo>();
		Connection con=null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		ProductInfo productInfo = new ProductInfo();
		boolean at=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String db="jdbc:mysql://localhost:3306/Flipkart";
			con=DriverManager.getConnection(db,"root","root");
			String url="select * from product_info where ProductId=?";
			pstmt=con.prepareStatement(url);
			
				pstmt.setInt(1,id);
				
		 rs=pstmt.executeQuery();
		 
			
		 	if(rs.next()) {
		 		productInfo.setProductname(rs.getString("ProductName"));
				productInfo.setProductid(rs.getInt("ProductID"));
				productInfo.setProductcost(rs.getDouble("ProductCost"));
				productInfo.setProductcolor(rs.getString("ProductColor"));
				productInfo.setNop(rs.getInt("NumberOfProducts"));
				productInfo.setDescription(rs.getString("Description"));
				al.add(productInfo);
			
			}
			
			
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
		
		
		return al;
	}

	@Override
	public ArrayList<OrderInfo> searchOrder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
