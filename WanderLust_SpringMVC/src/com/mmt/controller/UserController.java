package com.mmt.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mmt.model.bean.User;
import com.mmt.model.bl.UserBlMMT;





//sdsd

@Controller
public class UserController {
	
	private UserBlMMT userBl=new UserBlMMT();
//	@RequestMapping("/")
//	public String startApplication(){
//		
//		return "HomeHeader";
//	}
	@RequestMapping("/userRegister")
	public ModelAndView userRegisterStatus(@ModelAttribute("user") User user){
		ModelAndView modelAndView=new ModelAndView();
		try {
			if(userBl.register(user)){
				modelAndView.addObject("message", user.getUserName() +  " Successfully registered");
				modelAndView.setViewName("status");

			}
			else{
				modelAndView.addObject("message", user.getUserName() +  " Successfully  not registered");
				modelAndView.setViewName("status");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
		
			e.printStackTrace();
		}
		return modelAndView;
		
	}
	
}
