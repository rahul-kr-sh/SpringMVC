package com.mmt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String searchFlight() {

		return "FlightForm";
	}

	@ModelAttribute("flightSourceList")
	public List<String> flightSourceList() {

		List<String> flightSourceList = new ArrayList<String>();
		try {

			flightSourceList = flightBookingBlMMT.getSourceList();

		} catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		return flightSourceList;
	}

	@ModelAttribute("flightDestList")
	public List<String> flightDestList() {

		List<String> flightDestList = new ArrayList<String>();
		try {

			flightDestList = flightBookingBlMMT.getSourceList();

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
