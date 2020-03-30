package com.user.review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.review.controller.RvDao;

public class RvDelete implements RvCommand{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		int rNo = Integer.parseInt(req.getParameter("rNo"));
		int flag = Integer.parseInt(req.getParameter("rIndent"));
		int rGroup = Integer.parseInt(req.getParameter("rGroup"));
		System.out.println(flag);
		RvDao dao = new RvDao();
		/*dao.rvDelete(rNo, rGroup, flag);*/
	}

}
