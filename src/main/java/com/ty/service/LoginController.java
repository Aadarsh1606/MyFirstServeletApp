package com.ty.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.InsertInfo;
import com.ty.dto.User;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String number = req.getParameter("phonenumber");
		String id = req.getParameter("id");
		User user = new User();
		InsertInfo i = new InsertInfo();
		try {
			user = i.getUserInfo(user);
		} 
		catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(user.getAddress());
		System.out.println(user.getName());

	}

}
