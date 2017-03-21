package com.mmt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

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
import com.mmt.model.bean.FlightBooking;
import com.mmt.model.bean.Promotion;
import com.mmt.model.bean.User;
import com.mmt.model.bean.Wallet;
import com.mmt.model.bl.AdminBlMMT;
import com.mmt.model.bl.FlightBookingBlMMT;
import com.mmt.model.bl.HotelBlMMT;
import com.mmt.model.bl.PromotionBlMMT;
import com.mmt.model.bl.UserBlMMT;
import com.mmt.model.bl.WalletBlMMT;


@Controller
@SessionAttributes({"flightSeat","userBeanSession","adminBeanSession","flightTicketPrice","bookedFlightDetails","flightORhotel","requiredAmt"})
public class HomeController {

	private FlightBookingBlMMT flightBookingBlMMT = new FlightBookingBlMMT();
	private HotelBlMMT hotelBlMMT = new HotelBlMMT();
	private PromotionBlMMT promotionBl=new PromotionBlMMT();
	private WalletBlMMT walletBlMMT=new WalletBlMMT();
	
	

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
	public ModelAndView selectFlight(@ModelAttribute("flight") Flight flight, HttpServletRequest request, ModelMap model) {
		List<Flight> flightList=new ArrayList<Flight>();
	  
		int flightSeat=Integer.parseInt(request.getParameter("seats"));
		

		try {
			flightList=flightBookingBlMMT.searchFlight(flight.getFlightSource(), flight.getFlightDestination());
		} catch (ClassNotFoundException | SQLException | IOException e) {
			
			e.printStackTrace();
		}
		ModelAndView mv=new ModelAndView("SearchFlightList", "arrayListFlight", flightList);
		mv.addObject("flightSeat",flightSeat);
		return mv;
	}
	
	@RequestMapping("/bookFlight")
	public ModelAndView bookFlight(ModelMap model,HttpSession session){
		
		ModelAndView modelAndView=new ModelAndView();
		
		if(session.getAttribute("userBeanSession")==null){
			modelAndView.setViewName("Login");
		}
		else {
			model.addAttribute("promotion", new Promotion());
			modelAndView.setViewName("ChoosePromoFlight");
		}
		return modelAndView;
		
	}
	
	@RequestMapping("/applyFlightPromo")
	public ModelAndView choosePromoFlight(@ModelAttribute("promotion") Promotion promotion,ModelMap model,HttpSession session){
		ModelAndView modelAndView=new ModelAndView();
		double finalPrice=0;

		double flightTicketPrice=((Flight)session.getAttribute("selectedFlightBeanSession")).getFlightTicketPrice() * 
									(int)session.getAttribute("flightSeat");

//											
		try {
			finalPrice=promotionBl.applyPromotion(promotionBl.searchPromotion(promotion.getPromotionId()),
					((User)session.getAttribute("userBeanSession")).getUserId(), flightTicketPrice);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			
			e.printStackTrace();
		}
		
		
		
//		promotionBl.searchPromotion(promotion.getPromotionId());
		modelAndView.setViewName("AfterPromoFlightPrice");
		modelAndView.addObject("flightTicketPrice", flightTicketPrice);
		return modelAndView;
		
	}
	
	
	@RequestMapping("/confirmFlightBooking")
	public ModelAndView confirmBooking(HttpSession session){
		//List that maintain a flight booking details for printing purpose
		List<String> bookedFlightDetails=new ArrayList<String>();
		User user1=(User)session.getAttribute("userBeanSession");
		Flight flight1=((Flight)session.getAttribute("selectedFlightBeanSession"));
		FlightBooking flightBooking=new FlightBooking();
		ModelAndView modelAndView=new ModelAndView();
		double flightTicketPrice=(double)session.getAttribute("flightTicketPrice");
	double walletBalance=0;
	try {
		walletBalance = userBl.userWalletBalance(user1.getUserId());
		
		
	} catch (ClassNotFoundException | SQLException | IOException e) {
	
		e.printStackTrace();
	}
		if(walletBalance >= flightTicketPrice){
			try {
				flightBooking= flightBookingBlMMT.bookFlight(user1.getUserId(), flight1.getFlightId(), flight1.getFlightSource(), flight1.getFlightDestination(), (int)session.getAttribute("flightSeat"));
				walletBlMMT.subtractWalletMoney(user1.getUserId(), flightTicketPrice);
				//Adding details to bookedFlightDetails arraylist
				bookedFlightDetails.add(flightBooking.getFlightBookingId());
				bookedFlightDetails.add(flight1.getFlightCompanyName());
				bookedFlightDetails.add(flight1.getFlightArrivalTime());
				bookedFlightDetails.add(flight1.getFlightDepartureTime());
				bookedFlightDetails.add(flight1.getFlightSource());
				bookedFlightDetails.add(flight1.getFlightDestination());
				bookedFlightDetails.add(flightBooking.getFlightBookingDate().toString());
				bookedFlightDetails.add(Double.toString(flightTicketPrice));
				modelAndView.addObject("bookedFlightDetails", bookedFlightDetails);
				
				
				modelAndView.setViewName("PrintFlightTicket");
			} catch (ClassNotFoundException | SQLException | IOException e) {
				
				e.printStackTrace();
			}
			
			
		}
		else{
			double requiredAmt=flightTicketPrice - walletBalance;
			modelAndView.addObject("requiredAmt", requiredAmt);
			modelAndView.addObject("flightORhotel", "flight");
			modelAndView.setViewName("AddBalanceToWallet");
			
		}
		
		return modelAndView;
	}
	
	
	
	 @RequestMapping("/addMoney")
	public ModelAndView addMoney(HttpServletRequest request, HttpSession session){
		
		 String userId=((User)session.getAttribute("userBeanSession")).getUserId();
		ModelAndView modelAndView=new ModelAndView();
		double requiredAmt=0;
		String amt=request.getParameter("amount");
		Double moneyToAdd=0.0;
		if(amt!=null){
		moneyToAdd = Double.parseDouble(amt);
		}
//		if(moneyToAdd!=null){
		if(session.getAttribute("requiredAmt")!=null)
			requiredAmt=(Double)session.getAttribute("requiredAmt");
		
		
		
		if(moneyToAdd >= requiredAmt && ((String)session.getAttribute("flightORhotel")).equals("flight")){
			try {
				walletBlMMT.addWalletMoney(userId, moneyToAdd);
				//walletBlMMT.subtractWalletMoney(userId, flightTicketPrice);
			} catch (ClassNotFoundException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			modelAndView.setViewName("AfterPromoFlightPrice");
		}
		
		else {
			modelAndView.setViewName("AddBalanceToWallet");
			modelAndView.addObject("notRequiredAmount", "Please enter Required amount: "+ requiredAmt);
		}	
//		}
		return modelAndView;
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
	
	
	@ModelAttribute("flightPromoList")
	public List<String> flightPromoList(){
		List<Promotion> promoList=new ArrayList<Promotion>();
		try {
			promoList=promotionBl.displayPromotion("FLIGHT");
		} catch (ClassNotFoundException | SQLException | IOException e) {
		
			e.printStackTrace();
		}
		
		List<String> promoNameList=new ArrayList<String>();
		for(Promotion promo:promoList){
			promoNameList.add(promo.getPromotionId());
		}
		return promoNameList;
	}
	
	
	
	//Flight Section end
	
	
	//Login section for either admin or user
	
	@RequestMapping("/login")
	public String login(){
		
		
		return "Login";
		
	}
	
	
	@RequestMapping("/loginCheck")
	public ModelAndView loginCheck(HttpServletRequest request, ModelMap model, HttpSession session){
		
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
			modelAndView.addObject("adminBeanSession",admin);
//			model.addAttribute("admin", admin);
			modelAndView.setViewName("AdminLoginHeader");

		} else if (user != null) {
			if(session.getAttribute("selectedFlightBeanSession")!=null){
				modelAndView.addObject("userBeanSession",user);
				modelAndView.setViewName("ChoosePromoFlight");
			}
			else if(session.getAttribute("selectedHotelBeanSession")!=null){
				modelAndView.addObject("userBeanSession",user);
				modelAndView.setViewName("ChoosePromoHotel");
			}
			
			else{
				modelAndView.addObject("userBeanSession",user);
				
				modelAndView.setViewName("UserLoginHeader");
			}
			
		} else {
			modelAndView.addObject("loginErrMessage",  " Invalid User id or password");
			modelAndView.setViewName("Login");
		}
		
		return modelAndView;
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "HomeHeader";
	}
}
