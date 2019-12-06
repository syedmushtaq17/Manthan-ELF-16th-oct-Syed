package com.manthan.hotelbill;

import java.util.Scanner;

import com.manthan.dao.Dao;
import com.manthan.daoimpl.DaoImpl;

public class HotelBill {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Dao dao = new DaoImpl();
		int press;
		String operate;
		int order = 0;
		int item;
		String  fname;
		double price;
		double totalsum=0;
		boolean ordered =false;
		System.out.println("Press 1 to show all food items");
		System.out.println("Press 2 to take orders from customers");
		System.out.println("Press 3 to operate on food items");
		System.out.println("Press 4 to total bill of the day");
		press=scan.nextInt();
		switch (press) {
		case 1:
			dao.showAll();
			break;
          case 2:
			
  			break;
         case 3:
        	 	
	       break;
         case 4:
     	   dao.dispBill();
  	       break;
		default:
			System.out.println("Invalid number pressed ");
			break;
		}
		
		
		if(press==3) {
			System.out.println("Press A to add food item ");
			System.out.println("Press B to remove food item");
			System.out.println("Press C to modify food item");
			operate=scan.next();
			
    	 	switch (operate) {
			case "A":
				System.out.println("Enter the item code to add");
				item=scan.nextInt();
				scan.nextLine();
				System.out.println("Enter the item Name");
				fname=scan.nextLine();
				System.out.println("Enter the price");
				price=scan.nextDouble();
				
				if(dao.addFood(item, fname, price)>0) {
					System.out.println("Item Added Successfully");
				}
				else {
					System.out.println("Unable to add item");
				}
				break;
              case "B":
            	  System.out.println("Enter the item code to Remove");
  				item=scan.nextInt();
  				if(dao.remove(item)>0) {
  					System.out.println("Item deleted successfully");
  				}
  				else {
  					System.out.println("Unable to find The Item");
  				}
				break;
              case "C":
            	  System.out.println("Enter the item code to Modify");
  				item=scan.nextInt();
  				System.out.println(item);
  				scan.nextLine();
  				System.out.println("Enter the item Name");
  				fname=scan.nextLine();
  				System.out.println(fname);
  				System.out.println("Enter the price");
  				price=scan.nextDouble();
  				System.out.println(price);
  				
  				if(dao.modify(item, fname, price)>0) {
  					System.out.println("Item Updated SuccessFully");
  				}
  				else {
  					System.out.println("UNable to modify the item ");
  					System.out.println("Check the Item Code Once");
  				}
  				
	              break;
			default:
				System.out.println("Invalid number pressed ");
				break;
			}
		}
		else if(press==2) {
			System.out.println("Enter the item code");
			order=scan.nextInt();
			while(order!=0) {
				dao.add(order);
			
				ordered=true;
				System.out.println("Enter the item code");
				order=scan.nextInt();
				
				
			}
			if(ordered) {
				totalsum=totalsum+dao.userbill();
				
			}
			
			
		}
		
	}

}
