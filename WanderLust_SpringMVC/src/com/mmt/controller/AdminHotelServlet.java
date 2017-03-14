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
import com.mmt.model.bl.AdminBlMMT;
import com.mmt.model.bl.HotelBlMMT;


public class AdminHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String option=(String)request.getParameter("option");
		Hotel newHotel=(Hotel)session.getAttribute("newHotel");
		
		String oldHotelId=(String) session.getAttribute("oldhotelId");
		
		Hotel hotelSearched=null;
		ArrayList<Hotel> arrayListHotel=null;
		AdminBlMMT adminHotel=new AdminBlMMT();
		HotelBlMMT hotelBl=new HotelBlMMT();
		int row=0;
		String msgHotel=null;
		if(option.equalsIgnoreCase("insert"))
			{
			System.out.println("Inside insert of hotel");
			Hotel hotel=new Hotel();
			hotel.setHotelId(request.getParameter("hotelId"));
			hotel.setHotelLocation(request.getParameter("hotelLocation"));
			hotel.setHotelName(request.getParameter("hotelName"));
			hotel.setHotelInfo(request.getParameter("hotelInfo"));
			
			try {
				row=adminHotel.insertHotel(hotel);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(row>0){
				msgHotel="Hotel Successfully Added";
				session.setAttribute("msgHotel",msgHotel);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulHotelInsertion.jsp");
				dispatch.forward(request, response);
				
			}
			else{
				
				msgHotel="Failed Hotel Addition";
				session.setAttribute("msgHotel",msgHotel);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulHotelInsertion.jsp");
				dispatch.forward(request, response);
				
			}
		}
		else if(option.equals("delete"))
		{
			String hotelId=request.getParameter("hotelId");
			try {
				row=adminHotel.deleteHotel(hotelId);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(row>0){
				msgHotel="hotel Successfully Deleted";
				session.setAttribute("msgHotel",msgHotel);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulHotelInsertion.jsp");
				dispatch.forward(request, response);
			}
			else{
				
				msgHotel="Hotel Deletion Failed";
				session.setAttribute("msgHotel",msgHotel);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulHotelInsertion.jsp");
				dispatch.forward(request, response);
			}
		}
		else if(option.equals("update"))
		{
			try {
				row=adminHotel.modifyHotel(oldHotelId, newHotel);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(row>0){
				msgHotel="hotel Successfully Updated";
				session.setAttribute("msgHotel",msgHotel);
			}
			else{
				
				msgHotel="flight Successfully Updated";
				session.setAttribute("msgHotel",msgHotel);
			}
		}
		else if(option.equals("search"))
		{
			String searchHotelId=request.getParameter("hotelId");
			try {
				hotelSearched=hotelBl.searchHotel(searchHotelId);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(hotelSearched==null){
				msgHotel="Hotel doesn't Exist with ID = "+searchHotelId;
				session.setAttribute("msgHotel",msgHotel);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulHotelInsertion.jsp");
				dispatch.forward(request, response);
			}
			else{	
				session.setAttribute("hotelSearched",hotelSearched);
				RequestDispatcher dispatch = request.getRequestDispatcher("AdminSearchedHotel.jsp");
				dispatch.forward(request, response);
			}
		}
		else if(option.equalsIgnoreCase("display"))
		{
			try {
				arrayListHotel=hotelBl.displayHotel();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(arrayListHotel.isEmpty()){
				msgHotel="No hotels Exist ";
				session.setAttribute("msgHotel",msgHotel);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulHotelInsertion.jsp");
				dispatch.forward(request, response);
			}
			else{
				session.setAttribute("arrayListHotel",arrayListHotel);
				RequestDispatcher dispatch = request.getRequestDispatcher("AdminDisplayAllHotels.jsp");
				dispatch.forward(request, response);
			}
		}
		
	}
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
