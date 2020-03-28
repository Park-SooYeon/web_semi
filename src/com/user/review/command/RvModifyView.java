package com.user.review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.review.controller.RvDao;
import com.user.review.controller.RvVo;

public class RvModifyView implements RvCommand{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		int rNo = Integer.parseInt(req.getParameter("rNo"));
		System.out.println(rNo);
		RvDao dao = new RvDao();
		RvVo vo = dao.rvMoView(rNo);
		
		req.setAttribute("vo", vo);
	}
	
}
