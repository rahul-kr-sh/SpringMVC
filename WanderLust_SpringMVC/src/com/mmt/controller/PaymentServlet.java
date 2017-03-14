package com.mmt.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mmt.model.bean.Flight;
import com.mmt.model.bean.User;
import com.mmt.model.bl.FlightBookingBlMMT;
import com.mmt.model.bl.FlightPaymentBl;
import com.mmt.model.bl.PromotionBlMMT;
import com.mmt.model.bl.WalletBlMMT;

public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String promoPickedID = request.getParameter("promoflight");
		double flightTicketPrice = (double) session.getAttribute("flightTicketPrice");
		String flightIDPicked = (String) session.getAttribute("flightId");
		User user = (User) session.getAttribute("user");
		String userId = user.getUserId();
		int noOfSeats = (int) session.getAttribute("seats");
		FlightBookingBlMMT flightBookingBlMMT = new FlightBookingBlMMT();
		FlightPaymentBl flightPaymentBl = new FlightPaymentBl();
		double cartValue = 0;
		cartValue = flightPaymentBl.cartValue(flightTicketPrice, noOfSeats);

		PromotionBlMMT promotionBlMMT = new PromotionBlMMT();
		double valueAfterPromotion = 0;
		//System.out.println("PromoPickedISD:: " + promoPickedID);
		if (promoPickedID.equals("-")) {
			valueAfterPromotion = cartValue;
		} else {
			try {
				valueAfterPromotion = promotionBlMMT.applyPromotion(promotionBlMMT.searchPromotion(promoPickedID),
						userId, cartValue);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			if (flightPaymentBl.checkFunds(userId, valueAfterPromotion)) {

				// THere is sufficient funds in account------------------
				// Redirect to Confirm Payment JSP Page

				session.setAttribute("finalValuetobepaid", valueAfterPromotion);
				RequestDispatcher dispatch = request.getRequestDispatcher("ConfirmFlightBooking.jsp");
				dispatch.forward(request, response);
			} else {
				// Insufficient Funds
				// Redirect to Add money to wallet and then redirect to confirm
				// payment JSP Page
				session.setAttribute("finalValuetobepaid", valueAfterPromotion);
				WalletBlMMT walletBl = new WalletBlMMT();
				double moneyToBeAdded = valueAfterPromotion - (walletBl.walletBalance(userId));
				String message = "Add atleast " + moneyToBeAdded + " to Wallet to book flight seat";
				session.setAttribute("moneyToBeAdded", moneyToBeAdded);
				session.setAttribute("messageFlight", message);
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
