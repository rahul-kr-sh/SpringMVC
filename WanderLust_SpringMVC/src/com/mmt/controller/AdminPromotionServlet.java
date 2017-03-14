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
import com.mmt.model.bl.AdminBlMMT;

import com.mmt.model.bl.PromotionBlMMT;


public class AdminPromotionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String option=(String)request.getParameter("option");
		Promotion promotionSearched=null;
		ArrayList<Promotion> arrayListPromotion=null;
		PromotionBlMMT promotionBl=new PromotionBlMMT();
		int row=0;
		String msg=null;
		if(option.equalsIgnoreCase("insert"))
		{
			Promotion promotion=new Promotion();
			
			promotion.setPromotionId(request.getParameter("promotionId"));
			promotion.setPromotionName(request.getParameter("promotionName"));
			promotion.setPromotionDiscount(Double.parseDouble(request.getParameter("promotionDiscount")));
			promotion.setPromotionExpiryDate(request.getParameter("promotionExpiryDate"));
			promotion.setPromotionMinRequiredAmount(Double.parseDouble(request.getParameter("promotionMinRequiredAmount")));
			promotion.setPromotionType(request.getParameter("promotionType"));
			try {
				row=promotionBl.insertPromotion(promotion);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(row>0){
				
				msg="Promotion Successfully Added";
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
				
			}
			else{
				msg="Promotion Insertion Failed";
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
				
			}
		}
		else if(option.equalsIgnoreCase("delete"))
		{
			System.out.println("Inside delete of flight");
			String promotionId=request.getParameter("promotionId");
			try {
				row=promotionBl.deletePromotion(promotionId);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(row>0){
				msg="Promotion Successfully Deleted";
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
			}
			else{
				
				msg="Promotion deletion Failed";
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
			}
		}
		else if(option.equalsIgnoreCase("update"))
		{
			System.out.println("Inside update of flight");
			
			
			Promotion promotion=new Promotion();
			String oldpromotionId=request.getParameter("oldpromotionId");
			promotion.setPromotionId(request.getParameter("promotionId"));
			promotion.setPromotionName(request.getParameter("promotionName"));
			promotion.setPromotionDiscount(Double.parseDouble(request.getParameter("promotionDiscount")));
			promotion.setPromotionExpiryDate(request.getParameter("promotionExpiryDate"));
			promotion.setPromotionMinRequiredAmount(Double.parseDouble(request.getParameter("promotionMinRequiredAmount")));
			promotion.setPromotionType(request.getParameter("promotionType"));
			try {
				row=promotionBl.updatePromotion(oldpromotionId, promotion);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(row>0){
				msg="Promotion Successfully Updated";
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
			}
			else{
				
				msg="Promotion Updation Failed";
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
			}
		}
		else if(option.equalsIgnoreCase("search"))
		{
			String searchPromotionId=request.getParameter("promotionId");
			try {
				promotionSearched=promotionBl.searchPromotion(searchPromotionId);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(promotionSearched==null){
				msg="Promotion doesn't Exist with ID = "+searchPromotionId;
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
			}
			else{	
				session.setAttribute("promotionSearched",promotionSearched);
				RequestDispatcher dispatch = request.getRequestDispatcher("AdminSearchedPromotion.jsp");
				dispatch.forward(request, response);
			}
		}
		else if(option.equalsIgnoreCase("display"))
		{
			try {
				arrayListPromotion=promotionBl.displayPromotion();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(arrayListPromotion.isEmpty()){
				msg="No Promomotions Exist ";
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
			}
			else{
				session.setAttribute("arrayListPromotion",arrayListPromotion);
				RequestDispatcher dispatch = request.getRequestDispatcher("AdminDisplayAllPromotions.jsp");
				dispatch.forward(request, response);
			}
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
