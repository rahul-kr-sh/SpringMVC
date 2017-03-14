package com.mmt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mmt.model.bean.User;
import com.mmt.model.bl.WalletBlMMT;

public class MoneyAdddedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		double moneyToAdd = Double.parseDouble(request.getParameter("amount"));
		WalletBlMMT walletBl = new WalletBlMMT();
		User user = (User) session.getAttribute("user");
		boolean value = false;
		String msg = "";
		double balance = 0;
		String preciseBalance = null;
		try {
			value = walletBl.addWalletMoney(user.getUserId(), moneyToAdd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (value == true) {
			msg = "Successfully Added";
			try {
				balance = walletBl.walletBalance(user.getUserId());
				DecimalFormat df2 = new DecimalFormat(".##");
				preciseBalance = df2.format(balance);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("balance", preciseBalance);
			session.setAttribute("msg", msg);
			RequestDispatcher dispatch = request.getRequestDispatcher("Wallet.jsp");
			dispatch.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
