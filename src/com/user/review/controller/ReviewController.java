package com.user.review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.mypage.command.LastPlaceView;
import com.user.mypage.command.MpCommand;
import com.user.review.command.RvCommand;
import com.user.review.command.RvInsert;
import com.user.review.command.RvSelect;

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
		String url="index.jsp?middle=./user/u_subtitle.jsp?inc2=";
		String viewPage = "";
		RvCommand command = null;
		MpCommand command2 = null;
		
		String uri = req.getRequestURI();
		String conPath = req.getContextPath();
		String com = uri.substring(conPath.length());
		
		System.out.println(com);
		if(com.equals("/review.rv")) {
			String eMail = req.getParameter("eMail");
			int rCode = Integer.parseInt(req.getParameter("rCode"));
			viewPage = url + "../review/rvInsert.jsp?eMail="+eMail+"& rCode="+rCode;
		}else if(com.equals("/reviewInsert.rv")) {
			command = new RvInsert();
			command.execute(req, res);
			viewPage = "/lastPlace.mp";
		}else if(com.equals("/lastPlace.mp")) {
			command2 = new LastPlaceView();
			command2.execute(req, res);
			viewPage = url + "lastPlace.jsp";
		}else if(com.equals("/reviewSelect.rv")) {
			command = new RvSelect();
			command.execute(req, res);
			viewPage = url+"../review/rvSelect.jsp";
		}else if(com.equals("/reviewModify.rv")) {
			viewPage = "/reviewSelect.rv";
		}
		RequestDispatcher dis = req.getRequestDispatcher(viewPage);
		dis.forward(req, res);
	}
}