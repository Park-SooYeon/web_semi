package com.user.review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.mypage.command.MpCommand;
import com.user.review.controller.RvDao;

public class RvInsert implements MpCommand{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String rContent = req.getParameter("rContent");
		String eMail = req.getParameter("eMail");
		int star = Integer.parseInt(req.getParameter("star"));
		int rCode = Integer.parseInt(req.getParameter("rCode"));
		
		RvDao dao = new RvDao();
		int re = dao.rvWrite(rCode, eMail, rContent, star);
		
		req.setAttribute("re", re);
	}
}
