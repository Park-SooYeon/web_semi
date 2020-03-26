package com.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Redirect;

import com.login.command.LogCommand;
import com.login.command.Login;
import com.login.command.MsendEmail;
import com.user.mypage.command.MpCommand;
import com.user.mypage.command.MpView;
import com.user.mypage.command.ReserveList;

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
		LogCommand command = null;
		
		String url = req.getRequestURI();
		int pos = url.lastIndexOf("/");
		String tempUrl = url.substring(pos);
		
		if(tempUrl.equals("/login.lg")) {
			command = new Login();
			command.logInter(req, resp);
			path = "../index.jsp";
		}else if(tempUrl.equals("/email.lg")) {
			command = new MsendEmail();
			command.logInter(req, resp);
			
		}
		resp.sendRedirect(path);

	}
	
}
