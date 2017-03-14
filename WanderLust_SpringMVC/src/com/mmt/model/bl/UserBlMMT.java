package com.mmt.model.bl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mmt.model.bean.FlightBooking;
import com.mmt.model.bean.HotelBooking;
import com.mmt.model.bean.User;
import com.mmt.model.bean.Wallet;
import com.mmt.model.dao.FlightBookingImpMMT;
import com.mmt.model.dao.HotelBookingDaoImplMMT;
import com.mmt.model.dao.UserDaoImplMMT;
import com.mmt.model.dao.WalletDaoImplMMT;

public class UserBlMMT {
	private HotelBookingDaoImplMMT hotelBookingDao = new HotelBookingDaoImplMMT();
	private FlightBookingImpMMT flightBookingDao = new FlightBookingImpMMT();
	private UserDaoImplMMT userDao = new UserDaoImplMMT();

	public User checkLogin(String username, String password) throws SQLException, ClassNotFoundException, IOException {

		User user = (User) userDao.search(username);
		if (user == null) {
			return null;
		} else if (user != null && (user.getUserId().equals(username) && user.getUserPassword().equals(password))) {
			return user;
		}

		return null;
	}

	public boolean register(User user) throws SQLException, ClassNotFoundException, IOException {

		if (userDao.search(user.getUserId()) == null) {

			userDao.insert(user);
			WalletDaoImplMMT walletDao = new WalletDaoImplMMT();
			Wallet wallet = new Wallet();
			wallet.setUserId(user.getUserId());
			wallet.setWalletBalance(0);

			walletDao.insertWallet(wallet);
			return true;
		} else {
			System.out.println("User Name already taken.Please select another user name.");
			return false;
		}

	}
	
	public User displayUserProfile(String userId) throws ClassNotFoundException, SQLException, IOException{
		User user=userDao.search(userId);
		
		return user;
	}
	
	public Double userWalletBalance(String userId) throws ClassNotFoundException, SQLException, IOException{
		WalletDaoImplMMT walletDao=new WalletDaoImplMMT();
		Wallet wallet;
		wallet=walletDao.displayWallet(userId);
		return wallet.getWalletBalance();
	}
	public ArrayList<FlightBooking> pastFbooking(String userId)
			throws ClassNotFoundException, SQLException, IOException {

		return flightBookingDao.searchFlightBooking(userId);
	}

	public ArrayList<HotelBooking> pastHbooking(String userId)
			throws ClassNotFoundException, IOException, SQLException {

		return hotelBookingDao.searchHotelBooking(userId);
	}

	public User searchUser(String uid) throws SQLException, ClassNotFoundException, IOException {
		return new UserDaoImplMMT().search(uid);
	}

}
