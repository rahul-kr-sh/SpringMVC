package com.mmt.model.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mmt.model.bean.Wallet;
import com.mmt.model.dao.WalletDaoImplMMT;
import com.mmt.model.dao.WalletDaoMMT;

public class WalletBlMMT {
	private WalletDaoMMT walletDao = new WalletDaoImplMMT();

	public double walletBalance(String userId) throws SQLException, ClassNotFoundException, IOException {
		Wallet w;

		w = walletDao.displayWallet(userId);
		// System.out.println(w.getWalletBalance());
		if (w == null) {
			return 0;
		} else {
			return (double) w.getWalletBalance();
		}

	}

	public ArrayList<Wallet> displayAll() throws SQLException, ClassNotFoundException, IOException {
		return walletDao.displayWalletAll();
	}

	// comment
	public boolean addWalletMoney(String userId, Double value)
			throws SQLException, ClassNotFoundException, IOException {
		Wallet w;
		w = walletDao.displayWallet(userId);

		w.setWalletBalance(w.getWalletBalance() + value);
		walletDao.updateWallet(userId, w);
		return true;
	}

	public boolean subtractWalletMoney(String userId, Double value)
			throws SQLException, ClassNotFoundException, IOException {
		Wallet w = null;
		w = walletDao.displayWallet(userId);

		double temp = w.getWalletBalance() - value;
		if (temp < 0) {
			// Exception //Insufficient Funds Add money to wallet
			return false;
		} else {
			w.setWalletBalance(temp);
			walletDao.updateWallet(userId, w);
			return true;
		}

	}
}
