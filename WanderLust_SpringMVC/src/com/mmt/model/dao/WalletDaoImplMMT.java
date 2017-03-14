package com.mmt.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mmt.model.bean.Promotion;
import com.mmt.model.bean.Wallet;

public class WalletDaoImplMMT implements WalletDaoMMT {
	Connection con = null;
	// Wallet wl = null;

	@Override
	public Wallet displayWallet(String userId) throws SQLException, ClassNotFoundException, IOException {
		con = DbConnection.dbConnection();
		Wallet newWallet = new Wallet();

		ResultSet rs;
		PreparedStatement pst = con.prepareStatement("select * from wallet where UserId=?");
		pst.setString(1, userId);
		rs = pst.executeQuery();
		if (rs.next()) {
			newWallet.setUserId(rs.getString(1));
			newWallet.setWalletBalance(rs.getDouble(2));
			con.close();
			return newWallet;
		}
		con.close();
		return null;
	}

	@Override
	public int updateWallet(String userId, Wallet newWallet) throws SQLException, ClassNotFoundException, IOException {
		con = DbConnection.dbConnection();
		int row = 0;
		PreparedStatement pst = con.prepareStatement("update wallet SET walletBalance=? where userId=?");

		pst.setDouble(1, newWallet.getWalletBalance());
		pst.setString(2, userId);
		row = pst.executeUpdate();

		con.close();
		return row;
	}

	@Override
	public ArrayList<Wallet> displayWalletAll() throws SQLException, ClassNotFoundException, IOException {
		Wallet pro = new Wallet();
		con = DbConnection.dbConnection();

		ArrayList<Wallet> proList = new ArrayList<Wallet>();

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Wallet ");
		while (rs.next()) {
			pro.setUserId(rs.getString(1));
			pro.setWalletBalance(rs.getDouble(2));
			proList.add(pro);
		}
		con.close();
		return proList;
	}

	@Override
	public int insertWallet(Wallet wallet) throws SQLException, ClassNotFoundException, IOException {
		con = DbConnection.dbConnection();
		int row = 0;

		PreparedStatement pst = con.prepareStatement("insert into wallet values(?,?)");
		pst.setString(1, wallet.getUserId());
		pst.setDouble(2, wallet.getWalletBalance());
		row = pst.executeUpdate();
		return row;
	}

	@Override
	public int deleteWallet(Wallet w) throws SQLException, ClassNotFoundException, IOException {
		con = DbConnection.dbConnection();
		String uId = w.getUserId();
		double userBalance = w.getWalletBalance();
		Statement stmt = con.createStatement();
		int rows = stmt.executeUpdate("delete from Wallet where USERID=+" + uId);
		if (rows > 0) {
			con.close();
			return rows;
		} else {
			con.close();
			return 0;
		}

	}
}
