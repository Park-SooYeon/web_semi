package com.user.review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.mypage.command.MpCommand;
import com.user.review.command.RvInsert;

/**
 * Servlet implementation class ReviewController
 */
@WebServlet("*.rv")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		String url="";
		String viewPage = "";
		
		MpCommand command = null;
		String uri = req.getRequestURI();
		String conPath = req.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/review/review.rv")) {
			viewPage = "/user/mpindex.jsp?inc2=../review/rvInsert.jsp";
		}else if(com.equals("/review/rvInsert.rv")) {
			command = new RvInsert();
			command.execute(req, res);
			viewPage = "/user/mpindex.jsp?inc2=lastPlace.jsp";
		}
		RequestDispatcher dis = req.getRequestDispatcher(viewPage);
		dis.forward(req, res);
	}
}
