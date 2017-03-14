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

import com.mmt.model.bean.Flight;
import com.mmt.model.bean.User;
import com.mmt.model.bl.UserBlMMT;


public class AdminUserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String option=(String)request.getParameter("option");
		ArrayList<User> arrayListUser=null;
		UserBlMMT userBl=new UserBlMMT();
		User userSearched=null;
		String msg=null;
		String searchUserId=null;
		 if(option.equalsIgnoreCase("search"))
		{
			String searchFlightId=request.getParameter("flightId");
			try {
				searchUserId=request.getParameter("userId");
				userSearched=userBl.searchUser(searchUserId);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(userSearched==null){
				msg="User doesn't Exist with ID = "+searchUserId;
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
			}
			else{	
				session.setAttribute("userSearched",userSearched);
				RequestDispatcher dispatch = request.getRequestDispatcher("AdminSearchedUser.jsp");
				dispatch.forward(request, response);
			}
		}
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
