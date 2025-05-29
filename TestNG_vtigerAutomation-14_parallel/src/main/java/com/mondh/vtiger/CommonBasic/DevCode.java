package com.mondh.vtiger.CommonBasic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DevCode {

	
	public static void main(String[] args) {
		//database use this class:
		// diffent types of connations server to data base.
			//		MySql ,Oracle, my sql [microsoft database],mongo db,
		
		//db url =connection String[ Url ,UserName ,Password ]
		
		      try {
				Connection connetionDbServer=DriverManager.getConnection("Mysql@127.0.0.1","root","admin");
				Statement statement=connetionDbServer.createStatement();
				ResultSet resultst=statement.executeQuery("select * from company");
				
					while(	resultst.next()) {
					String cellData=resultst.toString();
					System.out.println(cellData);				
					}				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
}
