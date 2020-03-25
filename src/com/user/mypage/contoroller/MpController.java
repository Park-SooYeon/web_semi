package com.user.mypage.contoroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.mypage.command.MpCommand;
import com.user.mypage.command.MpView;
import com.user.mypage.command.ReserveList;

/**
 * Servlet implementation class mp_controller
 */
@WebServlet("*.mp")
public class MpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionMp(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionMp(request, response);
	}
	
	private void actionMp(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String url = "/user/mpindex.jsp?inc2=";
		String viewPage = null;
		MpCommand command = null;
		
		String uri = req.getRequestURI();
		String conPath = req.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/user/mpview.mp")) {
			command = new MpView();
			command.execute(req, res);
			viewPage = url+"mypage.jsp";
		}else if(com.equals("/user/reserveList.mp")) {
			command = new ReserveList();
			command.execute(req, res);
			viewPage =  url+"reserveList.jsp";
		}
		RequestDispatcher dis = req.getRequestDispatcher(viewPage);
		dis.forward(req, res);
	}

}