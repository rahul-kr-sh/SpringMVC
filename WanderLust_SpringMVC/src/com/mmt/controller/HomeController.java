package com.mmt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mmt.model.bean.Flight;
import com.mmt.model.bl.FlightBookingBlMMT;
import com.mmt.model.bl.HotelBlMMT;
import com.mmt.model.bl.UserBlMMT;

@Controller
public class HomeController {

	private FlightBookingBlMMT flightBookingBlMMT = new FlightBookingBlMMT();
	private HotelBlMMT hotelBlMMT = new HotelBlMMT();

	private UserBlMMT userBl = new UserBlMMT();

	@RequestMapping("/")
	public String startApplication() {

		return "HomeHeader";
	}
	

	@RequestMapping("/searchFlight")
	public String searchFlight(ModelMap model) {
		Flight flight=new Flight();
		model.addAttribute("flight", flight);
		return "FlightForm";
	}
	
	@RequestMapping("/SelectFlight")
	public ModelAndView SelectFlight(@ModelAttribute("flight") Flight flight) {
		List<Flight> flightList=new ArrayList<Flight>();
		try {
			flightList=flightBookingBlMMT.searchFlight(flight.getFlightSource(), flight.getFlightDestination());
		} catch (ClassNotFoundException | SQLException | IOException e) {
			
			e.printStackTrace();
		}
		ModelAndView mv=new ModelAndView("SearchFlightList", "searchFlightList", flightList);
		return mv;
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
}
