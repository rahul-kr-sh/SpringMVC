package com.mmt.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mmt.model.bean.Admin;
import com.mmt.model.bean.User;
import com.mmt.model.bl.AdminBlMMT;
import com.mmt.model.bl.UserBlMMT;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		AdminBlMMT adminBlMMT = new AdminBlMMT();
		UserBlMMT blMMT = new UserBlMMT();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		Admin admin = null;
		try {
			admin = adminBlMMT.checkAdminLogin(userName, password);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		User user = null;
		try {
			user = blMMT.checkLogin(userName, password);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (admin != null) {

			session.setAttribute("admin", admin);
			RequestDispatcher dispatch = request.getRequestDispatcher("AdminLogin.jsp");
			dispatch.forward(request, response);

		} else if (user != null) {

			session.setAttribute("user", user);
			RequestDispatcher dispatch = request.getRequestDispatcher("UserLogin.jsp");
			dispatch.forward(request, response);
		} else {
			session.setAttribute("name", userName);
			RequestDispatcher dispatch = request.getRequestDispatcher("InvalidUser.jsp");
			dispatch.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
