package com.mmt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mmt.model.bean.User;
import com.mmt.model.bl.WalletBlMMT;

public class DisplayWalletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		WalletBlMMT walletBl = new WalletBlMMT();
		String preciseBalance = null;
		double balance = 0;
		User user = (User) session.getAttribute("user");
		try {
			balance = walletBl.walletBalance(user.getUserId());
			DecimalFormat df2 = new DecimalFormat(".##");
			preciseBalance = df2.format(balance);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("balance", preciseBalance);

		RequestDispatcher dispatch = request.getRequestDispatcher("Wallet.jsp");
		dispatch.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
