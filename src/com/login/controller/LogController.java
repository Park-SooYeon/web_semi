package com.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.command.Login;
import com.login.command.MsendEmail;

@WebServlet("*.lg")
public class LogController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		all(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		all(req, resp);
	}
	
	private void all(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String path = null;
		
		String url = req.getRequestURI();
		int pos = url.lastIndexOf("/");
		String tempUrl = url.substring(pos);
		if(tempUrl.equals("/login.lg")) {
			
			Login log = new Login();
			boolean flag = log.login(req, resp);
			
			if(flag) {
				path = "../index.jsp";				
			}else {
				path = "./login.jsp";
			}
			
		}else if(tempUrl.equals("/email.lg")) {
			String toEmail = req.getParameter("email");
			System.out.println(toEmail);
			MsendEmail mse = new MsendEmail();
			String num = mse.send(toEmail);
			PrintWriter out = resp.getWriter();
			out.print(num);
			out.flush();
			return;
		}
		resp.sendRedirect(path);
	}
	
}
