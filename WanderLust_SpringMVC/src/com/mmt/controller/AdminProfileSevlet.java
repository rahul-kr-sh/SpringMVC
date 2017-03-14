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

import com.mmt.model.bean.Admin;
import com.mmt.model.bean.Flight;
import com.mmt.model.bl.AdminBlMMT;
import com.mmt.model.bl.FlightBookingBlMMT;


public class AdminProfileSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String option=(String)request.getParameter("option");
		AdminBlMMT adminBl=new AdminBlMMT();
		boolean value=false;
		int row=0;
		String msg=null;
		if(option.equalsIgnoreCase("insert"))
		{
			//Flight flight=new Flight();
			Admin admin=new Admin();
			admin.setAdminId(request.getParameter("adminId"));  
			admin.setAdminName(request.getParameter("adminName"));
			admin.setAdminPhoneNo(Long.parseLong(request.getParameter("adminPhoneNo")));
			admin.setAdminEmailId(request.getParameter("adminEmailId"));
			admin.setAdminAddress(request.getParameter("adminAddress"));
			admin.setAdminPassword(request.getParameter("adminPassword"));
			
			try {
				value=adminBl.addAdmin(admin);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(value){
				
				msg="Admin Successfully Added";
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
				
			}
			else{
				msg="Admin Addition Failed";
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
				
			}
		}
		else if(option.equalsIgnoreCase("delete"))
		{
			
			String adminId=request.getParameter("adminId");
			try {
				row=adminBl.removeAdmin(adminId);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(row>0){
				msg="Admin Successfully Deleted";
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
			}
			else{
				
				msg="Admin deletion Failed";
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
			}
		}
		else if(option.equalsIgnoreCase("update"))
		{
			
			Admin admin=new Admin();
			String oldadminId=request.getParameter("oldadminId");
			
			admin.setAdminId(request.getParameter("adminId"));  
			admin.setAdminName(request.getParameter("adminName"));
			admin.setAdminPhoneNo(Long.parseLong(request.getParameter("adminPhoneNo")));
			admin.setAdminEmailId(request.getParameter("adminEmailId"));
			admin.setAdminAddress(request.getParameter("adminAddress"));
			admin.setAdminPassword(request.getParameter("adminPassword"));
			try {
				row=adminBl.modifyAdmin(oldadminId, admin);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(row>0){
				msg="Admin Successfully Updated";
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
			}
			else{
				
				msg="Admin Updation Failed";
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
			}
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
