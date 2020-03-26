package com.login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.controller.LoginDao;
import com.login.controller.LoginVo;

public class Login implements LogCommand{

	@Override
	public void logInter(HttpServletRequest req, HttpServletResponse resp) {
		LoginDao dao = new LoginDao();

		String email = req.getParameter("email_c");
		String pwd = req.getParameter("pwd_c");
	
		LoginVo vo = dao.login(email, pwd);
		req.setAttribute("email", vo.getEmail());
		req.setAttribute("nName", vo.getnName());
	}
	
}
