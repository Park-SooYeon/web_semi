package com.user.review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.review.controller.RvDao;

public class RvModify implements RvCommand{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		int rNo = Integer.parseInt(req.getParameter("rNo"));
		int stars = Integer.parseInt(req.getParameter("star"));
		String content = req.getParameter("content");
		
		RvDao dao = new RvDao();
		
	}
}
