package com.user.mypage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.mypage.contoroller.MpDao;

public class MpUpdate implements MpCommand{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String nName = req.getParameter("nName");
		String uName = req.getParameter("uName");
		String phone = req.getParameter("phone");
		String eMail = req.getParameter("eMail");
		MpDao dao = new MpDao();
		
		dao.mpUpdate(nName, uName, phone, eMail);
		
		
	}
	
	
}
