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

import com.mmt.model.bean.Hotel;
import com.mmt.model.bean.HotelRoom;
import com.mmt.model.bl.HotelBlMMT;

public class ChooseRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//Test Code
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String hotelId = (String) session.getAttribute("hotelId");
		session.setAttribute("hID", hotelId);
		HotelBlMMT hotelBl = new HotelBlMMT();
		ArrayList<HotelRoom> arrayListHotelRoom = null;

		try {
			arrayListHotelRoom = hotelBl.displayAvailHotelRoom(hotelId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (arrayListHotelRoom.isEmpty()) {
			String message = "No Hotel Rooms Available";
			session.setAttribute("message", message);
			response.sendRedirect("NoHotelRoomAvailable.jsp");
		} else {

			session.setAttribute("arrayListHotelRoom", arrayListHotelRoom);
			if(session.getAttribute("user")!=null){
				RequestDispatcher dispatch = request.getRequestDispatcher("LoggedInChooseRoom.jsp");
				dispatch.forward(request, response);

			}
			else{
				RequestDispatcher dispatch = request.getRequestDispatcher("ChooseRoom.jsp");
				dispatch.forward(request, response);
			}
			

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
