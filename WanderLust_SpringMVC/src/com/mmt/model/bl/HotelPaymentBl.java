package com.mmt.model.bl;

import java.io.IOException;
import java.sql.SQLException;

public class HotelPaymentBl {
	WalletBlMMT walletBL=new WalletBlMMT();
	
	public double cartValue(double roomPrice, int days){
		return roomPrice*days;
	}
	
	public boolean checkFunds(String userId, double valueAfterPromotion ) throws ClassNotFoundException, SQLException, IOException{
		double amountShort=0;
		amountShort = (double) ( walletBL.walletBalance(userId)-valueAfterPromotion);
		if(amountShort<0){
			return false;
		}
		return true;
	}
}
