package com.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
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
			MsendEmail mse = new MsendEmail();
			String num = mse.send(toEmail);
			PrintWriter out = resp.getWriter();
			out.print(num);
			out.flush();
			return;
		}else if(tempUrl.equals("/member.lg")) {
			LoginVo vo = new LoginVo();
			try {
				vo.setEmail(req.getParameter("email"));
				vo.setBirth(sdf.parse(req.getParameter("birth")));
				vo.setPwd(req.getParameter("pwd"));
				vo.setPhone(req.getParameter("phone"));
				vo.setnName(req.getParameter("nName"));
			} catch (ParseException e) { e.printStackTrace();}
			
			LoginDao dao = new LoginDao();
			boolean flag =  dao.membership(vo);
			if(flag) {
				path = "../index.jsp";
				req.getSession().setAttribute("email", vo.getEmail());
				req.getSession().setAttribute("nName", vo.getnName());
			}else {
				return;
			}
		}
		resp.sendRedirect(path);
	}
	
}
