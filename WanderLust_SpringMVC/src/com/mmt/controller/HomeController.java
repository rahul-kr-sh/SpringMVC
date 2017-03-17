package com.mmt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mmt.model.bean.Admin;
import com.mmt.model.bean.Flight;
import com.mmt.model.bean.User;
import com.mmt.model.bl.AdminBlMMT;
import com.mmt.model.bl.FlightBookingBlMMT;
import com.mmt.model.bl.HotelBlMMT;
import com.mmt.model.bl.UserBlMMT;

@Controller
@SessionAttributes({"flightSeat","user","admin"})
public class HomeController {

	private FlightBookingBlMMT flightBookingBlMMT = new FlightBookingBlMMT();
	private HotelBlMMT hotelBlMMT = new HotelBlMMT();

	private UserBlMMT userBl = new UserBlMMT();
	private AdminBlMMT adminBl=new AdminBlMMT();

	//Application start
	
	@RequestMapping("/")
	public String startApplication() {

		return "HomeHeader";
	}
	
	//Flight Section start
	@RequestMapping("/searchFlight")
	public String searchFlight(ModelMap model) {
		Flight flight=new Flight();
		model.addAttribute("flight", flight);
		return "FlightForm";
	}
	
	@RequestMapping("/selectFlight")
	public ModelAndView selectFlight(@ModelAttribute("flight") Flight flight, @RequestParam("seats")int flightSeat, ModelMap model) {
		List<Flight> flightList=new ArrayList<Flight>();
		model.addAttribute(flightSeat);
		
		
		try {
			flightList=flightBookingBlMMT.searchFlight(flight.getFlightSource(), flight.getFlightDestination());
		} catch (ClassNotFoundException | SQLException | IOException e) {
			
			e.printStackTrace();
		}
		ModelAndView mv=new ModelAndView("SearchFlightList", "arrayListFlight", flightList);
		return mv;
	}
	
	@RequestMapping("/bookFlight")
	public ModelAndView bookFlight(ModelMap model){
		
		
		System.out.println("========="+model.get("flightSeat"));
		return null;
		
	}
	
	@RequestMapping("/choosePromoFlight")
	public ModelAndView choosePromoFlight(){
		ModelAndView mv=new ModelAndView();
		return null;
		
	}

	@ModelAttribute("flightSourceList")
	public Set<String> flightSourceList() {

		Set<String> flightSourceList = new HashSet<String>();
		try {

			flightSourceList = flightBookingBlMMT.getSourceList();

		} catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		return flightSourceList;
	}

	@ModelAttribute("flightDestList")
	public Set<String> flightDestList() {

		Set<String> flightDestList = new HashSet<String>();
		try {

			flightDestList = flightBookingBlMMT.getDestinationList();

		} catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return flightDestList;
	}
	
	
	@ModelAttribute("hotelList")
	public Set<String> hotelList() {

		Set<String> hotelList = new HashSet<String>();
		try {

			hotelList = hotelBlMMT.getHotelLocationList();

		} catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return hotelList;
	}
	
	//Flight Section end
	
	
	//Login section for either admin or user
	
	@RequestMapping("/login")
	public String login(){
		
		
		return "Login";
		
	}
	
	
	@RequestMapping("/loginCheck")
	public ModelAndView loginCheck(HttpServletRequest request, ModelMap model){
		
		ModelAndView modelAndView=new ModelAndView();
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		
		Admin admin = null;
		try {
			admin = adminBl.checkAdminLogin(userId, password);
		} catch (ClassNotFoundException | SQLException | IOException e1) {
			
			e1.printStackTrace();
		}
		User user = null;
		try {
			user = userBl.checkLogin(userId, password);
		} catch (ClassNotFoundException | SQLException | IOException e1) {
			
			e1.printStackTrace();
		}
		if (admin != null) {

			model.addAttribute("admin", admin);
			modelAndView.setViewName("AdminLoginHeader");

		} else if (user != null) {

			model.addAttribute("user", user);
			modelAndView.setViewName("UserLoginHeader");
		} else {
			modelAndView.addObject("loginErrMessage",  " Invalid User id or password");
			modelAndView.setViewName("Login");
		}
		
		
		
		return modelAndView;
		
	}
}
