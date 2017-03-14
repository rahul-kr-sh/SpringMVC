package com.mmt.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import com.mmt.model.dao.DbConnection.*;
import com.mmt.model.bean.HotelRoom;
import com.mmt.model.bean.Promotion;

public class PromotionDaoImplMMT implements PromotionDaoMMT {

	Connection con = null;
	//insert function to add the promo details
	@Override
	public int insertPromotion(Promotion p) throws SQLException, ClassNotFoundException, IOException {
		int row;
		con = DbConnection.dbConnection();

		con = DbConnection.dbConnection();
		PreparedStatement pst = con.prepareStatement("insert into promotion values(?,?,?,?,?,?)");

		pst.setString(1, p.getPromotionId());
		pst.setString(2, p.getPromotionName());
		pst.setDouble(3, p.getPromotionDiscount());
		pst.setString(4, p.getPromotionExpiryDate());
		pst.setDouble(5, p.getPromotionMinRequiredAmount());
		pst.setString(6, p.getPromotionType());
		row = pst.executeUpdate();
		return row;

	}
	//delet function to delete the promo
	@Override
	public int deletePromotion(String promotionId) throws SQLException, ClassNotFoundException, IOException {
		con = DbConnection.dbConnection();
		// Statement stmt = con.createStatement();
		// int rows = stmt.executeUpdate("delete from PROMOTION where
		// PROMOTIONID =" + promotionId);
		int row = 0;
		PreparedStatement pst = con.prepareStatement("delete from promotion where promotionId=?");
		pst.setString(1, promotionId);
		row = pst.executeUpdate();

		con.close();
		return row;
	}
		//update function to update the promo details
	@Override
	public int updatePromotion(String promotionId, Promotion newp)
			throws SQLException, ClassNotFoundException, IOException {
		con = DbConnection.dbConnection();
		int row = 0;
		PreparedStatement pst = con.prepareStatement(
				"update promotion set promotionId=?,  promotionName=?, promotionDiscount=?, promotionExpiryDate=?,promotionMinRequiredAmount=?,promotionType=? where promotionId=?");
		pst.setString(1, newp.getPromotionId());
		pst.setString(2, newp.getPromotionName());
		pst.setDouble(3, newp.getPromotionDiscount());
		pst.setString(4, newp.getPromotionExpiryDate());
		pst.setDouble(5, newp.getPromotionMinRequiredAmount());
		pst.setString(6, newp.getPromotionType());
		pst.setString(7, promotionId);
		
		row=pst.executeUpdate();
		con.close();

		return row;
	}

	@Override
	public ArrayList<Promotion> displayPromotion() throws SQLException, ClassNotFoundException, IOException {
		Promotion pro = null;
		con = DbConnection.dbConnection();

		ArrayList<Promotion> proList = new ArrayList<Promotion>();

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Promotion ");
		while (rs.next()) {
			 pro = new Promotion();
			pro.setPromotionId(rs.getString(1));
			pro.setPromotionName(rs.getString(2));
			pro.setPromotionDiscount(rs.getFloat(3));
			pro.setPromotionExpiryDate(rs.getString(4));
			pro.setPromotionMinRequiredAmount(rs.getFloat(5));
			pro.setPromotionType(rs.getString(6));
			proList.add(pro);
		}
		con.close();
		return proList;
	}

	@Override
	public Promotion searchPromotion(String promotionId) throws SQLException, ClassNotFoundException, IOException {
		con = DbConnection.dbConnection();
		Promotion pro;
		PreparedStatement pst = con.prepareStatement("select * from promotion where promotionId=?");
		pst.setString(1, promotionId);
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			pro = new Promotion();
			pro.setPromotionId(rs.getString(1));
			pro.setPromotionName(rs.getString(2));
			pro.setPromotionDiscount(rs.getFloat(3));
			pro.setPromotionExpiryDate(rs.getString(4));
			pro.setPromotionMinRequiredAmount(rs.getFloat(5));
			pro.setPromotionType(rs.getString(6));
			con.close();
			return pro;
		}
		return null;
	}

	@Override
	public ArrayList<Promotion> displayPromotion(String promotionType)
			throws SQLException, ClassNotFoundException, IOException {
		con = DbConnection.dbConnection();
		Promotion pro = null;
		ArrayList<Promotion> proList = new ArrayList<Promotion>();
		PreparedStatement pst;
		pst = con.prepareStatement("select * from  Promotion where promotionType=?");
		pst.setString(1, promotionType);
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			pro = new Promotion();
			pro.setPromotionId(rs.getString(1));
			pro.setPromotionName(rs.getString(2));
			pro.setPromotionDiscount(rs.getFloat(3));
			pro.setPromotionExpiryDate(rs.getString(4));
			pro.setPromotionMinRequiredAmount(rs.getFloat(5));
			pro.setPromotionType(rs.getString(6));
			proList.add(pro);
		}
		con.close();
		return proList;
	}

}
