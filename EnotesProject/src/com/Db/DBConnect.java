package com.Db;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.*;
public class DBConnect {
private static Connection connection;
	
	public static Connection getConn() {
		
		
		
		try {
			
			if(connection==null) {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes","root","Mysql@1234");
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return connection;
	}

}
