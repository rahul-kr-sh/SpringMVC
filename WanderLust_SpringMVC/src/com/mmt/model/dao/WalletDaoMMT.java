package com.mmt.model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mmt.model.bean.Wallet;

public interface WalletDaoMMT {
	int insertWallet(Wallet w) throws SQLException, ClassNotFoundException, IOException;
	Wallet displayWallet(String userId)throws SQLException, ClassNotFoundException, IOException ;
	int updateWallet(String userId,Wallet newWallet)throws SQLException, ClassNotFoundException, IOException;
	ArrayList<Wallet> displayWalletAll() throws SQLException, ClassNotFoundException, IOException;
	int deleteWallet(Wallet w) throws SQLException, ClassNotFoundException, IOException;
}
