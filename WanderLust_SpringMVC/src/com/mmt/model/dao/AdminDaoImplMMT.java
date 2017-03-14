package com.mmt.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mmt.model.bean.Admin;


public class AdminDaoImplMMT implements AdminDao{
	
	//insert function for the admin board
	
	@Override
	public int insert(Admin admin) throws SQLException, ClassNotFoundException, IOException {
		int row;
		Connection con=DbConnection.dbConnection();
		PreparedStatement pst=con.prepareStatement("insert into admin values(?,?,?,?,?,?)");
		pst.setString(1, admin.getAdminId());
		pst.setString(2,admin.getAdminName());
		pst.setLong(3,admin.getAdminPhoneNo());
		pst.setString(4,admin.getAdminEmailId());
		pst.setString(5,admin.getAdminAddress());
		pst.setString(6,admin.getAdminPassword());
		
		
		row=pst.executeUpdate();
		con.close();
		return row;
	}

		// search function for admin
	@Override
	public Admin search(String uid) throws SQLException, ClassNotFoundException, IOException {
		Admin admin=new Admin();
		ResultSet rs;
		Connection con=DbConnection.dbConnection();;
		PreparedStatement pst=con.prepareStatement("select * from admin where ADMINID=?");
		pst.setString(1, uid);
		rs=pst.executeQuery();
		
		if(rs.next()){
		
			admin.setAdminId((rs.getString("ADMINID")));
			admin.setAdminName((rs.getString("ADMINNAME")));
			admin.setAdminPhoneNo(rs.getLong("ADMINPHONENO"));
			admin.setAdminEmailId(rs.getString("ADMINEMAILID"));
			admin.setAdminAddress(rs.getString("ADMINADDRESS"));
			admin.setAdminPassword(rs.getString("ADMINPASSWORD"));	
			return admin;
		}

		con.close();
		return null;
	}

	//delete function to delete Admin
	@Override
	public int delete(String uid) throws SQLException, ClassNotFoundException, IOException {
		
		int row;
		Connection con=DbConnection.dbConnection();
		PreparedStatement pst=con.prepareStatement("delete from admin where ADMINID=?");
		pst.setString(1, uid);
		row=pst.executeUpdate();
		con.close();
		return row;
	}

	//update function to update the admin details
		
	@Override
	public int update(String uid, Admin admin) throws SQLException, ClassNotFoundException, IOException {
		int row;
		Connection con=DbConnection.dbConnection();
		PreparedStatement pst=con.prepareStatement("update admin set ADMINNAME=?,  ADMINPHONENO=?, 	ADMINEMAILID=?, ADMINADDRESS=?,ADMINPASSWORD=? where ADMINID	=?");
		pst.setString(1, admin.getAdminName());
		pst.setLong(2, admin.getAdminPhoneNo());
		pst.setString(3, admin.getAdminEmailId());
		pst.setString(4, admin.getAdminAddress());
		pst.setString(5, admin.getAdminPassword());
		pst.setString(6, uid);
		row=pst.executeUpdate();
		return row;
		
	}

	
}
