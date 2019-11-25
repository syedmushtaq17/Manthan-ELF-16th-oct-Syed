package com.manthan.assesment;
import java.util.Scanner;

public class MusicPlayer {

	public static void main(String[] args) {

	MusicDB db=new MusicDB();
		Scanner scan =new Scanner(System.in);
   SongInfoBean songInfoBean = new SongInfoBean();
		System.out.println(" 1. Press '1' to 'Play a Song '");
		System.out.println(" 2. Press '2' to 'Search a Song '");
		System.out.println(" 3. Press '3' to 'Show all Songs '");
		System.out.println(" 4. Press '4' to 'Operate On Songs Database '");

		int input= scan.nextInt();
		
		switch ( input) {

		case 1: 
			System.out.println(" 1. Press 'A' to 'Play all Song '");
			System.out.println(" 2. Press 'B' to 'Play Songs Randomly'");
			System.out.println(" 3. Press 'C' to 'Play a Particular Song '");
		
			break;

		case 2: 
			scan.nextLine();
			System.out.println("Enter the song to search ");
			String searchsong = scan.nextLine();
		 db.search(searchsong);
			
			break;

		case 3: 

		db.displayAll();
			
			break;

		case 4: 

			System.out.println(" 1. Press 'A' to 'Add Song ' to Repository ");
			System.out.println(" 2. Press 'B' to 'Edit an exesting song '");
			System.out.println(" 3. Press 'C' to 'Delete a Particular Song '");
			
			break;

		default:
			
			break;
		}//end of switch
		
		char c;
		
		if(input==1) {
			String s=scan.next();
			c=s.charAt(0);
			if(c=='A') {
				db.playAll();
			}
			
			else if(c=='B') {
				db.playRandomly();
			}
			else if(c=='C') {
				System.out.println("Enter the song name to play  ");
				scan.nextLine();
				String sname=scan.nextLine();
				db.playParticular(sname);
			}
			
		}
		
		if(input==4) {
			
			String s=scan.next();
			c=s.charAt(0);
			if(c=='A') {
				
				
				scan.nextLine();
				
				
				if(db.addSong(songInfoBean)>=1) {
					System.out.println("Song added successfully");
				}
				else {
					System.out.println("Failed to add song ");
				}
			}
			
			else if(c=='B') {
				scan.nextLine();
				System.out.println("Enter the song name to edit ");
				String sname=scan.nextLine();
				if(db.search(sname)>=1) {
				if(db.editSong(sname)>=1) {
					System.out.println("Song edited successfully");
				}
				else {
					System.out.println("Song couldn't be edited ");
				}
				}
			}
			else if(c=='C') {
				scan.nextLine();
				System.out.println("Enter the song name to delete ");
				String sname=scan.nextLine();
				if(db.deleteParticular(sname)>=1){
					System.out.println("Song deleted successfully");
				}
				else {
					System.out.println("Failed to delete song ");
				}
			}
			
			
			
		}

	}// end of main

	

}// end of class
