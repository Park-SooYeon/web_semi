package com.user.review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RvReplyView implements RvCommand{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		int rCode = Integer.parseInt(req.getParameter("rCode"));
		int rGroup = Integer.parseInt(req.getParameter("rGro"));
		int rStep = Integer.parseInt(req.getParameter("rStep"));
		int rIndent = Integer.parseInt(req.getParameter("rIndent"));
		
		System.out.println(rCode);
		System.out.println(rGroup);
		System.out.println(rStep);
		System.out.println(rIndent);
		
		
		req.setAttribute("rCode", rCode);
		req.setAttribute("rGroup", rGroup);
		req.setAttribute("rStep", rStep);
		req.setAttribute("rIndent", rIndent);
	}

}
