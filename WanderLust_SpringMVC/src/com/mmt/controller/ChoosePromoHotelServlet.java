package com.mmt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mmt.model.bean.Promotion;
import com.mmt.model.bean.User;
import com.mmt.model.bl.PromotionBlMMT;

public class ChoosePromoHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			RequestDispatcher dispatch = request.getRequestDispatcher("loginUnregistered.jsp");
			dispatch.forward(request, response);
		}
		PromotionBlMMT promoBl = new PromotionBlMMT();
		ArrayList<Promotion> arrayListPromoHotel = null;
		try {
			arrayListPromoHotel = promoBl.displayPromotion("HOTEL");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		session.setAttribute("arrayListPromoHotel", arrayListPromoHotel);
		RequestDispatcher dispatch = request.getRequestDispatcher("ChoosePromoCodeHotel.jsp");
		dispatch.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
