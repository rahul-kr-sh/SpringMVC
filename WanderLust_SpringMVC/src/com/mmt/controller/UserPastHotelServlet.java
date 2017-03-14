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

import com.mmt.model.bean.HotelBooking;
import com.mmt.model.bean.User;
import com.mmt.model.bl.UserBlMMT;

public class UserPastHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserBlMMT blMMT = new UserBlMMT();
		User user = (User) session.getAttribute("user");
		try {
			ArrayList<HotelBooking> bookedHotelList = blMMT.pastHbooking(user.getUserId());
			session.setAttribute("bookedHotelList", bookedHotelList);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("UserPastHotel.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
