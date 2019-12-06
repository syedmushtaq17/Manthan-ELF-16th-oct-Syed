package com.manthan.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.manthan.dao.Dao;
import com.manthan.hotelinfobean.HotelInfoBean;

public class DaoImpl implements Dao {
	 double  totalsum=0;

	double usersum=0;
	ArrayList<HotelInfoBean> al = new ArrayList<HotelInfoBean>();

	@Override
	public int add(int id) {
		HotelInfoBean hotelInfoBean = new HotelInfoBean();
		Dao dao= new DaoImpl();
		Connection con=dao.getConnection();
		
		PreparedStatement pstmt =null;
	ResultSet rs=null;
		String url="select * from Hotel_Bill where Item_Code=?;";
		try {
			
		pstmt=con.prepareStatement(url);
		pstmt.setInt(1, id);
		
	 rs=pstmt.executeQuery();
	 System.out.println(rs);
	 
	while(rs.next()) {
		double price=rs.getDouble("Price");
		
		hotelInfoBean.setItemcode(rs.getInt("Item_Code"));
		hotelInfoBean.setFoodname(rs.getString("Food_Name"));
		hotelInfoBean.setPrice(price);
		al.add(hotelInfoBean);
		
	}
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
		
		return 0;
	}

	@Override
	public int remove(int id) {

		Dao dao= new DaoImpl();
		Connection con=dao.getConnection();
		
		PreparedStatement pstmt =null;
int rs=0;
		String url="delete from   Hotel_Bill where Item_Code=?;";
		try {
			
		pstmt=con.prepareStatement(url);
		pstmt.setInt(1, id);
		
		
	 rs=pstmt.executeUpdate();
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
	public int modify(int id, String name, double price) {
		Dao dao= new DaoImpl();
		Connection con=dao.getConnection();
		
		PreparedStatement pstmt =null;
int rs=0;
		String url="update Hotel_Bill set   Price =? , Food_Name =? where Item_Code=?;";
		try {
			
		pstmt=con.prepareStatement(url);
		pstmt.setInt(3, id);
		pstmt.setString(2, name);
		pstmt.setDouble(1, price);
		
	 rs=pstmt.executeUpdate();
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
	public void showAll() {
		Dao dao= new DaoImpl();
		Connection con=dao.getConnection();
		
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		String url=" select * from Hotel_Bill";
		try {
			
		pstmt=con.prepareStatement(url);
		
		
	 rs=pstmt.executeQuery();
	 System.out.println("Item code \t Food Name \t Price");
	 while(rs.next()) {
		 System.out.println(rs.getInt("Item_Code")+"      \t"+rs.getString("Food_Name")+"     \t"+rs.getDouble("Price"));
		
		 
	 }
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
		
		
	}

	@Override
	public double dispBill() {
		Dao dao= new DaoImpl();
		Connection con=dao.getConnection();
		
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		String url="select sum(total) as sum from Bill";
		try {
			
		pstmt=con.prepareStatement(url);
		
		
	 rs=pstmt.executeQuery();
	 while(rs.next()) {
		 System.out.println("Total Bill of Today is "+rs.getDouble("sum"));
		
		 
	 }
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
		
		return 0;
	}
	public Connection getConnection() {
		Connection con=null;
		String dburl="jdbc:mysql://localhost:3306/Hotel_DB";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(dburl,"root","root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
		
		return con;
	}

	@Override
	public double userbill() {
		Dao dao= new DaoImpl();
		System.out.println("Item code \t Food Name \t Price");
		for(HotelInfoBean i :al) {
			
			usersum=usersum+i.getPrice();
			System.out.println(i.getItemcode() +" \t \t"+i.getFoodname()+" \t \t"+i.getPrice());
			
		}
		
		totalsum=totalsum+usersum;
		System.out.println("total bill of user need to pay is " + usersum);
	dao.addbill(usersum);
		System.out.println(totalsum);
		return usersum;
	}

	@Override
	public int addFood(int id, String name, double price) {
		Dao dao= new DaoImpl();
		Connection con=dao.getConnection();
		
		PreparedStatement pstmt =null;
int rs=0;
		String url="insert into  Hotel_Bill values(?,?,?);";
		try {
			
		pstmt=con.prepareStatement(url);
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setDouble(3, price);
		
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
	public double totbill() {
		
		
		return 0;
	}

	@Override
	public double addbill(double sum) {
		Dao dao= new DaoImpl();
		Connection con=dao.getConnection();
		
		PreparedStatement pstmt =null;
double rs=0;
		String url="insert into Bill values(?);";
		try {
			
		pstmt=con.prepareStatement(url);
		pstmt.setDouble(1, sum);
	
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
	
	

}
