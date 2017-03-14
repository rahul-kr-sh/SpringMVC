package com.mmt.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
	public static Connection dbConnection() throws IOException, ClassNotFoundException, SQLException {
//		FileInputStream fis = new FileInputStream("MyproFile.properties");
//
//		Properties p = new Properties();
//
//		p.load(fis);
//
//		String driver = p.getProperty("dn");
//		String url = p.getProperty("url");
//		String user = p.getProperty("user");
//		String pwd = p.getProperty("pwd");

		Connection con = null;
	//	Class.forName(driver);
		// Connect to databases
		//con = DriverManager.getConnection(url, user, pwd);

		//return con;

		 try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
//		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521",
//		 "system", "sapient@123");
		 
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521",
					"system", "sapient@123");
		 
		 } catch (ClassNotFoundException | SQLException e) {
		
		 e.printStackTrace();
		
		 }

		 return con;
	}
}
