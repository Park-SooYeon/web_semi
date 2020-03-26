package com.user.mypage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.mypage.contoroller.MpDao;
import com.user.mypage.contoroller.MpVo;

public class MpView implements MpCommand{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String mId = req.getParameter("mId");
		MpDao dao = new MpDao();
		MpVo vo = dao.mpView(mId);
	
		req.setAttribute("vo", vo);
	}
}
