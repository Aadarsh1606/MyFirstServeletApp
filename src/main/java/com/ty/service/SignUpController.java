package com.ty.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.InsertInfo;
import com.ty.dto.User;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
//		String email = req.getParameter("email");
		String phonenumber = req.getParameter("phonenumber");
		String address = req.getParameter("address");
		
//		System.out.println("Info given by the user" + name + " " + email +" " + phonenumber + " " + pass );

		User user = new User();
		user.setName(name);
//		user.setEmail(email);
		user.setPhoneNumber(Long.parseLong(phonenumber));
		user.setAddress(address);
		user.setId(Integer.parseInt(id));
		
		boolean result = false;
		
		InsertInfo i = new InsertInfo();
		
		try {
			result = i.insertUserInfo(user);
		} 
		catch (Exception e) {
			System.out.println(e);
		}

		PrintWriter output = resp.getWriter();
		if (result) {
			output.print("Signed up successfully");
		} 
		else
			output.print("Invalid credentials");
	}

}
