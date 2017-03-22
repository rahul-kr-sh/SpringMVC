package com.mmt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mmt.model.bean.FlightBooking;
import com.mmt.model.bean.User;
import com.mmt.model.bl.UserBlMMT;






//sdsd

@Controller
@SessionAttributes({"pastFlightBooking","pastHotelBooking"})
public class UserController {
	
	private UserBlMMT userBl=new UserBlMMT();
	@RequestMapping("/userSignup")
	public ModelAndView userSignup(){
		ModelAndView modelAndView=new ModelAndView("UserSignupForm","user", new User());
		return modelAndView;
	}
//	@RequestMapping("/userRegister")
//	public ModelAndView userRegisterStatus(@ModelAttribute("user") User user){
//		ModelAndView modelAndView=new ModelAndView();
//		try {
//			if(userBl.register(user)){
//				modelAndView.addObject("message", user.getUserName() +  " Successfully registered");
//				modelAndView.setViewName("status");
//
//			}
//			else{
//				modelAndView.addObject("message", user.getUserName() +  " Successfully  not registered");
//				modelAndView.setViewName("status");
//			}
//		} catch (ClassNotFoundException | SQLException | IOException e) {
//		
//			e.printStackTrace();
//		}
//		return modelAndView;
//		
//	}
	
	
//	@RequestMapping("/userRegister")
//	public ModelAndView userRegisterStatus(@Valid User user,BindingResult result, ModelMap model){
//		ModelAndView modelAndView=new ModelAndView();
//		if (result.hasErrors()) {
//			modelAndView.setViewName("UserSignupForm");
//			return modelAndView;
//		}
//		try {
//			if(userBl.register(user)){
//				modelAndView.addObject("message", user.getUserName() +  " Successfully registered");
//				modelAndView.setViewName("status");
//
//			}
//			else{
//				modelAndView.addObject("message", user.getUserName() +  " Successfully  not registered");
//				modelAndView.setViewName("status");
//			}
//		} catch (ClassNotFoundException | SQLException | IOException e) {
//		
//			e.printStackTrace();
//		}
//		return modelAndView;
//	}
//	
	
	
	
	@RequestMapping("/userRegister")
	public String userRegisterStatus(@Valid User user, BindingResult result,ModelMap model){
		
		String view=null;
		if(result.hasErrors()){
			view="UserSignupForm";
			
		}
		else{
		try {
			if(userBl.register(user)){
				//model.addAttribute("message", user.getUserName() +  " Successfully registered");
				view="Login";

			}
			else{
				model.addAttribute("message", user.getUserName() +  "Registration Failed");
				view="status";
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
		
			e.printStackTrace();
		}
		}
		return view;
		
		
	}
	
	
	@RequestMapping("/userPastFlight")
	public ModelAndView userPastFlight(HttpSession session){
		User user1=(User)session.getAttribute("userBeanSession");
		ModelAndView modelAndView =new ModelAndView();
		ArrayList<FlightBooking> pastFlightBooking=null;
		try {
			pastFlightBooking=userBl.pastFbooking(user1.getUserId());
			modelAndView.addObject("pastFlightBooking", pastFlightBooking);
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pastFlightBooking.get(0));
		modelAndView.setViewName("UserPastFlight");
		return modelAndView;
	}
	
	
		@RequestMapping("/userPastHotel")
		public ModelAndView userPastHotel(HttpSession session){
			User user1=(User)session.getAttribute("userBeanSession");
			ModelAndView modelAndView =new ModelAndView();
			ArrayList<FlightBooking> pastHotelBooking=null;
			try {
				pastHotelBooking=userBl.pastFbooking(user1.getUserId());
				modelAndView.addObject("pastHotelBooking", pastHotelBooking);
				
			} catch (ClassNotFoundException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(pastHotelBooking.get(0));
			modelAndView.setViewName("UserPastHotel");
			return modelAndView;
	}
	
	
	
	
	
}
