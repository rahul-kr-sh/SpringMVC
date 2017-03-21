package com.mmt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mmt.model.bean.Admin;
import com.mmt.model.bean.Flight;
import com.mmt.model.bean.Hotel;
import com.mmt.model.bean.Promotion;
import com.mmt.model.bl.AdminBlMMT;
import com.mmt.model.bl.FlightBookingBlMMT;
import com.mmt.model.bl.HotelBlMMT;
import com.mmt.model.bl.PromotionBlMMT;

@SessionAttributes({"admin","arrayListFlight"})
@Controller
public class AdminController {
	FlightBookingBlMMT flightBl=new FlightBookingBlMMT();
	ArrayList<Flight> arrayListFlight=null;
	AdminBlMMT adminFlight=new AdminBlMMT();
	ArrayList<Hotel> arrayListHotel=null;
	AdminBlMMT adminHotel=new AdminBlMMT();
	HotelBlMMT hotelBl=new HotelBlMMT();
	int row=0;
	String msgHotel=null;
	String msg=null;
	@RequestMapping("/AdminProfile")
	public String adminProfile(){
		return "AdminProfile";
		}
	@RequestMapping("/AdminDisplayFlight")
	public ModelAndView displayFlights(){
		ModelAndView mv=null;
		try {
			arrayListFlight=flightBl.displayFlight();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(arrayListFlight.isEmpty()){
			msg="No Flights Exist ";
			
			mv=new ModelAndView("SuccessfulFlightInsertion","msg",msg);
			
		}
		else{
			
			mv=new ModelAndView("AdminDisplayAllFlights","arrayListFlight",arrayListFlight);
			
		}
		return mv;}
	
	@RequestMapping("/AdminUpdateDisplayFlight")
	public ModelAndView viewFlightsUpdate(ModelMap model) throws ClassNotFoundException, SQLException, IOException{
		ModelAndView mv=null;
		arrayListFlight=flightBl.displayFlight();
		model.addAttribute("arrayListFlight", arrayListFlight);
		mv=new ModelAndView("AdminUpdateDisplayFlight","arrayListFlight",arrayListFlight);
		return mv ;}
	@RequestMapping("/AdminUpdateFlight")
	public String flightUpdate(){
		
		return "AdminUpdateFlight" ;}
	@RequestMapping("/AdminFlightactualUpdate")
	public ModelAndView actualUpdate(HttpServletRequest request) throws IOException{
		ModelAndView mv=null;
		System.out.println("Inside update of flight");
		Flight newFlight=new Flight();
		String oldFlightId=request.getParameter("oldflightId");
		newFlight.setFlightId(request.getParameter("newflightId"));
		newFlight.setFlightCompanyName(request.getParameter("flightCompanyName"));
		newFlight.setFlightSource(request.getParameter("flightSource"));
		newFlight.setFlightDestination(request.getParameter("flightDestination"));
		newFlight.setFlightDepartureTime(request.getParameter("flightDepartureTime"));
		newFlight.setFlightArrivalTime(request.getParameter("flightArrivalTime"));
		newFlight.setFlightTicketPrice(Double.parseDouble(request.getParameter("flightTicketPrice")));
		newFlight.setAvailableSeats(Integer.parseInt(request.getParameter("availableSeats")));
		int row=0;
		try {
			row=adminFlight.modifyFlight(oldFlightId, newFlight);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(row>0){
			msg="Flight Successfully Updated";
		//	logger.info("Flight Successfully Updated");
			
			mv=new ModelAndView("SuccessfulFlightInsertion","msg",msg);
			
		}
		else{
			
			msg="Flight Updation Failed";
			
			mv=new ModelAndView("SuccessfulFlightInsertion","msg",msg);
			
		}
		return mv;
	}
	@RequestMapping("/AdminDisplayHotel")
	public ModelAndView displayHotels(){
		ModelAndView mv=null;
		try {
			arrayListHotel=hotelBl.displayHotel();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(arrayListHotel.isEmpty()){
			msgHotel="No hotels Exist ";
			
			mv=new ModelAndView("SuccessfulFlightInsertion","msg",msgHotel);
			
		}
		else{
			
			mv=new ModelAndView("AdminDisplayAllHotels","arrayListHotel",arrayListHotel);
			
		}
		return mv;
		}
	
	@RequestMapping("/adminDisplayPromotion")
	public ModelAndView displayPromotions(){
		ModelAndView mv=null;
		ArrayList<Promotion> arrayListPromotion=null;
		PromotionBlMMT promotionBl=new PromotionBlMMT();
		
		String msg=null;
		try {
			arrayListPromotion=promotionBl.displayPromotion();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(arrayListPromotion.isEmpty()){
			msg="No Promomotions Exist ";
			
			mv=new ModelAndView("SuccessfulFlightInsertion","msg",msg);
			
		}
		else{
			
			mv=new ModelAndView("AdminDisplayAllPromotions","arrayListPromotion",arrayListPromotion);
			
		}
		return mv;}
	
	@RequestMapping("/AdminUpdateAdmin")	
	public String Update(){
		return "AdminUpdateAdmin";
	}
	
	@RequestMapping("/AdminServProfile")	
	public ModelAndView profileUpdate(HttpServletRequest request) throws ClassNotFoundException, SQLException, IOException{
		Admin admin=new Admin();
		String oldadminId=request.getParameter("oldadminId");
		ModelAndView mv=null;
		admin.setAdminId(request.getParameter("adminId"));  
		admin.setAdminName(request.getParameter("adminName"));
		admin.setAdminPhoneNo(Long.parseLong(request.getParameter("adminPhoneNo")));
		admin.setAdminEmailId(request.getParameter("adminEmailId"));
		admin.setAdminAddress(request.getParameter("adminAddress"));
		admin.setAdminPassword(request.getParameter("adminPassword"));
		int row=0;
		AdminBlMMT adminBl=new AdminBlMMT();
		row=adminBl.modifyAdmin(oldadminId, admin);
		if(row>0){
			msg="Admin Successfully Updated";
			
			mv=new ModelAndView("SuccessfulFlightInsertion","msg",msg);
			
		}
		else{
			
			msg="Admin Updation Failed";
			mv=new ModelAndView("SuccessfulFlightInsertion","msg",msg);
		}
		return mv;}
	
}
