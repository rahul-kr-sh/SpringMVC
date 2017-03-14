package com.mmt.controller;

import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mmt.model.bean.User;
import com.mmt.model.bl.HotelBlMMT;
import com.mmt.model.bl.HotelPaymentBl;
import com.mmt.model.bl.PromotionBlMMT;
import com.mmt.model.bl.WalletBlMMT;

public class PaymentHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String promoPickedID = request.getParameter("promohotel");
		String hotelIDPicked = (String) session.getAttribute("hotelId");
		User user = (User) session.getAttribute("user");
		String userId = user.getUserId();
		int noOfRooms=(int) session.getAttribute("noOfRooms");
		double roomPrice = (double) session.getAttribute("RoomPrice");
		String dcheckIn = (String) session.getAttribute("from");
		String dcheckOut = (String) session.getAttribute("to");
		int duration = (int) session.getAttribute("duration");
		session.setAttribute("hotelID", hotelIDPicked);
		HotelBlMMT hotelBlMMT = new HotelBlMMT();
		HotelPaymentBl hotelPaymentBl = new HotelPaymentBl();
		double cartValue = 0;
		cartValue = hotelPaymentBl.cartValue(roomPrice, duration)*noOfRooms;
		PromotionBlMMT promotionBlMMT = new PromotionBlMMT();
		double valueAfterPromotion = 0;

		if(promoPickedID.equals("-")){
			valueAfterPromotion=cartValue;
		}
		else{
			try {
				valueAfterPromotion = promotionBlMMT.applyPromotion(promotionBlMMT.searchPromotion(promoPickedID), userId,
						cartValue);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		try {
			if (hotelPaymentBl.checkFunds(userId, valueAfterPromotion)) {

				// THere is sufficient funds in account------------------
				// Redirect to Confirm Payment JSP Page

				session.setAttribute("finalValuetobepaid", valueAfterPromotion);

				RequestDispatcher dispatch = request.getRequestDispatcher("ConfirmHotelBooking.jsp");
				dispatch.forward(request, response);
			} else {
				// Insufficient Funds
				// Redirect to Add money to wallet and then redirect to confirm
				// payment JSP Page
				session.setAttribute("finalValuetobepaid", valueAfterPromotion);
				WalletBlMMT walletBl = new WalletBlMMT();
				double moneyToBeAdded = valueAfterPromotion - (walletBl.walletBalance(userId));
				String message = "Add atleast " + moneyToBeAdded + " to Wallet to book hotel room";
				session.setAttribute("moneyToBeAdded", moneyToBeAdded);
				session.setAttribute("messageHotel", message);
				RequestDispatcher dispatch = request.getRequestDispatcher("AddMoney.jsp");
				dispatch.forward(request, response);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
