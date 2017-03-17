package com.mmt.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mmt.model.bean.Admin;

import com.mmt.model.bl.AdminBlMMT;

@Controller
public class AdminController {
	
	private AdminBlMMT adminBl=new AdminBlMMT();
	@RequestMapping("/adminRegister")
	public ModelAndView adminRegisterStatus(@ModelAttribute("admin") Admin admin){
		ModelAndView modelAndView=new ModelAndView();
		try {
			if(adminBl.addAdmin(admin)){
				modelAndView.addObject("message", admin.getAdminName() +  " Successfully registered");
				modelAndView.setViewName("status");

			}
			else{
				modelAndView.addObject("message", admin.getAdminName()+  " Successfully  not registered");
				modelAndView.setViewName("status");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
		
			e.printStackTrace();
		}
		return modelAndView;
		
	}
	
	public ModelAndView addFlight(){
		return null;
		
	}
	
	
}
