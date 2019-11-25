package com.manthan.assesment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MusicDB {

	public int addSong(SongInfoBean songInfoBean) {
		
		Scanner scan =new Scanner(System.in);
		
		Connection con=null;
		PreparedStatement pstmt =null;
				ResultSet rs=null;
		Statement smt =null;
		int rstmt=0;
		String url="jdbc:mysql://localhost:3306/MusicPlayer";
		String query ="insert into MUsicFiles values(?,?,?,?,?,?)";
				
				try {
				Class.forName("com.mysql.jdbc.Driver");
				
				con=DriverManager.getConnection(url,"root","root");
				
				pstmt=con.prepareStatement(query);
				System.out.println("Enter song song id");
				int songid=scan.nextInt();
				songInfoBean.setSong_id(songid);
				scan.nextLine();
				System.out.println("Enter song Song title");
				String songtitle=scan.nextLine();
				songInfoBean.setSong_title(songtitle);
				
				System.out.println("Enter song Artist name");
				String artistname=scan.nextLine();
				songInfoBean.setArtist_name(artistname);
				System.out.println("Enter song album name");
				String albumname=scan.nextLine();
				songInfoBean.setAlbum_name(albumname);
				
				System.out.println("Enter song Location");
				String loc=scan.nextLine();
				songInfoBean.setSong_location(loc);
				
				System.out.println("Enter song Description");
				String desc=scan.nextLine();
				songInfoBean.setDescription(desc);
				
				pstmt.setInt(1,songid );
				pstmt.setString(2, songtitle);
				pstmt.setString(3, artistname);
				pstmt.setString(4,albumname);
				pstmt.setString(5, loc);
				pstmt.setString(6,desc);
				
				rstmt=pstmt.executeUpdate();
				
				
				}
				catch (Exception e) {
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
				return rstmt;
	}

	public int deleteParticular(String sname) {

Scanner scan =new Scanner(System.in);
		
SongInfoBean songInfoBean = new SongInfoBean();
		Connection con=null;
		PreparedStatement pstmt =null;
				ResultSet rs=null;
		Statement smt =null;
		int rstmt=0;
		String url="jdbc:mysql://localhost:3306/MusicPlayer";
		String query ="delete from MUsicFiles where Song_Title=?";
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection(url,"root","root");
			
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1,sname );
			
			
			rstmt=pstmt.executeUpdate();
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
		
		return rstmt;
		
	}

	public int editSong(String sname) {
Scanner scan =new Scanner(System.in);
SongInfoBean songInfoBean = new SongInfoBean();
		Connection con=null;
		PreparedStatement pstmt =null;
				ResultSet rs=null;
		Statement smt =null;
		int rstmt=0;
		String url="jdbc:mysql://localhost:3306/MusicPlayer";
		String query ="update   MUsicFiles set  Song_ID=?, Song_Title =?, Artist_Name =?, Album_Name =?, Song_Location =?, Description =?  where Song_Title=?";
		
		
		
		
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection(url,"root","root");
			
			pstmt=con.prepareStatement(query);
			
			System.out.println("Enter song song id");
			int songid=scan.nextInt();
			songInfoBean.setSong_id(songid);
			scan.nextLine();
			System.out.println("Enter song Song title");
			String songtitle=scan.nextLine();
			songInfoBean.setSong_title(songtitle);
			
			System.out.println("Enter song Artist name");
			String artistname=scan.nextLine();
			songInfoBean.setArtist_name(artistname);
			System.out.println("Enter song album name");
			String albumname=scan.nextLine();
			songInfoBean.setAlbum_name(albumname);
			
			System.out.println("Enter song Location");
			String loc=scan.nextLine();
			songInfoBean.setSong_location(loc);
			
			System.out.println("Enter song Description");
			String desc=scan.nextLine();
			songInfoBean.setDescription(desc);
			
			pstmt.setInt(1,songid );
			pstmt.setString(2, songtitle);
			pstmt.setString(3, artistname);
			pstmt.setString(4,albumname);
			pstmt.setString(5, loc);
			pstmt.setString(6,desc);
			pstmt.setString(7, sname);
			rstmt=pstmt.executeUpdate();
			
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
		
		return rstmt;
		
	}

	public int playParticular(String sname) {


Scanner scan =new Scanner(System.in);
		
SongInfoBean songInfoBean = new SongInfoBean();
		Connection con=null;
		PreparedStatement pstmt =null;
				ResultSet rs=null;
		Statement smt =null;
		
		int rstmt=0;
		String url="jdbc:mysql://localhost:3306/MusicPlayer";
		String query ="select * from MUsicFiles where Song_Title=?";
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection(url,"root","root");
			
			pstmt=con.prepareStatement(query);
			
			
			pstmt.setString(1,sname );
			
			
			if((rs=pstmt.executeQuery())!=null) {
				rstmt=1;
				if(rs.next()) {
				System.out.println("Playing Song ....");
				String s=rs.getString("Song_Title");
			System.out.println(rs.getString("Song_Title"));
			
				}
				else {
					System.out.println(" Song "+sname+" not found");
				}
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
		
		return rstmt;
		
		
	}
	SongInfoBean songInfoBean = new SongInfoBean();
	public int playAll() {

		Scanner scan =new Scanner(System.in);
		
		
				Connection con=null;
				PreparedStatement pstmt =null;
						ResultSet rs=null;
				Statement smt =null;
				
				int rstmt=0;
				String url="jdbc:mysql://localhost:3306/musicplayer";
				String query ="select Song_Title from MUsicFiles ";
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					
					con=DriverManager.getConnection(url,"root","root");
					
					smt=con.createStatement();
					
					
					
					
					
					if((rs=smt.executeQuery(query))!=null) {
						rstmt=1;
						
						System.out.println("Playing songs");
						System.out.println();
						while(rs.next()) {
							
							System.out.println(rs.getString("Song_Title"));
							
							Thread.sleep(5000);
						}
						
						
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
				
				return rstmt;
				
		
		
	}

	public int playRandomly() {
		
		
		Scanner scan =new Scanner(System.in);
		
		
		Connection con=null;
		PreparedStatement pstmt =null;
				ResultSet rs=null;
		Statement smt =null;
		
		int rstmt=0;
		String url="jdbc:mysql://localhost:3306/MusicPlayer";
		String query ="select * from MUsicFiles ";
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection(url,"root","root");
			
			smt=con.createStatement();
			
			rs=smt.executeQuery(query);
			
			
			
			if((rs=smt.executeQuery(query))!=null) {
				rstmt=1;
				
				ArrayList<String> ls = new ArrayList<String>();
		
				System.out.println("Playing songs Randomly..... ");
				System.out.println();
				int i=0;
				while(rs.next()) {
					
					String so=rs.getString("Song_Title");
				
					ls.add(so);
					
					
					
					i++;
				}
			int si=ls.size();
				
				for(int j=1;j<si*3;j++) {
					Random rand =new Random();
					int r=(int) Math.ceil(rand.nextInt(si));
							if(r>0) {
								Thread.sleep(5000);
					System.out.println(ls.get(r));
							}
				}
				
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
		
		return rstmt;
		
	}

	public int  search(String searchsong) {


Scanner scan =new Scanner(System.in);
		
SongInfoBean songInfoBean = new SongInfoBean();
		Connection con=null;
		PreparedStatement pstmt =null;
				ResultSet rs=null;
		Statement smt =null;
		
		int rstmt=0;
		String url="jdbc:mysql://localhost:3306/MusicPlayer";
		String query ="select * from MUsicFiles where Song_Title=?";
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection(url,"root","root");
			
			pstmt=con.prepareStatement(query);
			
			
			pstmt.setString(1,searchsong );
			
			
			if((rs=pstmt.executeQuery())!=null) {
				
				if(rs.next()) {
				System.out.println("Song " + searchsong +" Found");
				rstmt=1;
				}
				else
				{
					System.out.println("Song " + searchsong +" NOT  Found");
				}
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
		
		return rstmt;
		
		
		
	}

	public void displayAll() {

		
		Scanner scan =new Scanner(System.in);
		
		
		Connection con=null;
		PreparedStatement pstmt =null;
				ResultSet rs=null;
		Statement smt =null;
		
		int rstmt=0;
		String url="jdbc:mysql://localhost:3306/musicplayer";
		String query ="select * from MUsicFiles ";
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection(url,"root","root");
			
			smt=con.createStatement();
			
			
			
			
			
			if((rs=smt.executeQuery(query))!=null) {
				rstmt=1;
				
				System.out.println("Showing  all songs.....");
				System.out.println();

				System.out.println("Song id \t \t  Song title \t \t \t Artist name  \t \t \t Album name  \t \t \t Song locottion \t \t \t \t Description ");
				System.out.println();
				while(rs.next()) {
					System.out.print(rs.getInt( "Song_ID")+"\t \t");
					System.out.print(rs.getString("Song_Title")+"\t \t \t");
					System.out.print(rs.getString("Artist_Name")+"\t  \t");
					System.out.print(rs.getString("Album_Name")+"\t \t");
					System.out.print(rs.getString("Song_Location")+"\t \t");
					System.out.print(rs.getString("Description")+"\t \t");
					System.out.println();
					
					
				}
				
				
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
	
	
	

	
}
