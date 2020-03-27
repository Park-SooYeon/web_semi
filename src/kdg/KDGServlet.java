package kdg;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.ff")
public class KDGServlet extends HttpServlet {
	String url = "index.jsp?middle=./kdg";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("두포스트");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		String temp = req.getRequestURI();
		int pos = temp.lastIndexOf("/");
		String tempUrl = temp.substring(pos);
		switch(tempUrl) {
		case "/hotel.ff":
			hotel(req,resp);
			break;
		case "/motel.ff":
			motel(req,resp);		
			break;
		case "/pension.ff":
			pension(req,resp);
			break;
		case "/gesthous.ff":
			gesthouse(req,resp);
			break;
		case "/roomView.ff":
			roomView(req,resp);
			break;
		case "/gooSelect.ff":
			gooSelect(req,resp);
			break;
		}
			
	}
	public void hotel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int aType=0;
		if(req.getParameter("aType")!=null) {
			aType = Integer.parseInt(req.getParameter("aType"));
		}else {
			aType = 2;
		}
		//페이징작업
		int nowPage_f = 1;
		if(req.getParameter("nowPage_f")!=null) {
			nowPage_f = Integer.parseInt(req.getParameter("nowPage_f"));
		}
		page p_f = new page();
		p_f.setNowPage(nowPage_f);
		
		RoomsDao dao = new RoomsDao();
		List<RoomsListVo> list =dao.select(aType,p_f);
		req.setAttribute("list_f", list);
		req.setAttribute("p_f", p_f);
		String path = url + "/hrooms.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
		
	}
	public void motel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int aType=0;
		if(req.getParameter("aType")!=null) {
			aType = Integer.parseInt(req.getParameter("aType"));
		}else {
			aType = 2;
		}
		//페이징작업
		int nowPage_f = 1;
		if(req.getParameter("nowPage_f")!=null) {
			nowPage_f = Integer.parseInt(req.getParameter("nowPage_f"));
		}
		page p_f = new page();
		p_f.setNowPage(nowPage_f);
		
		RoomsDao dao = new RoomsDao();
		List<RoomsListVo> list =dao.select(aType,p_f);
		req.setAttribute("list_f", list);
		req.setAttribute("p_f", p_f);
		String path = url + "/mrooms.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);	
	}
	public void pension(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int aType=0;
		if(req.getParameter("aType")!=null) {
			aType = Integer.parseInt(req.getParameter("aType"));
		}else {
			aType = 2;
		}
		//페이징작업
		int nowPage_f = 1;
		if(req.getParameter("nowPage_f")!=null) {
			nowPage_f = Integer.parseInt(req.getParameter("nowPage_f"));
		}
		page p_f = new page();
		p_f.setNowPage(nowPage_f);
		
		RoomsDao dao = new RoomsDao();
		List<RoomsListVo> list =dao.select(aType,p_f);
		req.setAttribute("list_f", list);
		req.setAttribute("p_f", p_f);
		String path = url + "/prooms.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}
	public void gesthouse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int aType=0;
		if(req.getParameter("aType")!=null) {
			aType = Integer.parseInt(req.getParameter("aType"));
		}else {
			aType = 2;
		}
		//페이징작업
		int nowPage_f = 1;
		if(req.getParameter("nowPage_f")!=null) {
			nowPage_f = Integer.parseInt(req.getParameter("nowPage_f"));
		}
		page p_f = new page();
		p_f.setNowPage(nowPage_f);
		
		RoomsDao dao = new RoomsDao();
		List<RoomsListVo> list =dao.select(aType,p_f);
		req.setAttribute("list_f", list);
		req.setAttribute("p_f", p_f);
		String path = url + "/grooms.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}
	public void roomView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	
		int rCode=0;
		String checkIn="";
		String checkOut="";
		if(req.getParameter("rCode")!=null) {
			rCode = Integer.parseInt(req.getParameter("rCode"));
		}
		if(req.getParameter("checkIn")!=null) {
			checkIn = req.getParameter("checkIn");
		}
		if(req.getParameter("checkOut")!=null) {
			checkOut = req.getParameter("checkOut");
		}
		RoomsDao2 dao2 = new RoomsDao2();
		
		RoomsVo vo = dao2.view(rCode);
		
		req.setAttribute("vo", vo);
		req.setAttribute("rCode", rCode);
		req.setAttribute("checkIn", checkIn);
		req.setAttribute("checkOut", checkOut);
		
		String path = url + "/rooms_view.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}
	//구 선택시
	public void gooSelect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String place ="";
		int aType=0;
		int nowPage_f = 1;
		String target ="";
		if(req.getParameter("target")!=null) {
			target = req.getParameter("target");
		}
		if(req.getParameter("nowPage_f")!=null) {
			nowPage_f = Integer.parseInt(req.getParameter("nowPage_f"));
		}
		if(req.getParameter("aType")!=null) {
			aType = Integer.parseInt(req.getParameter("aType"));
		}
		if(req.getParameter("place")!=null) {
			place = req.getParameter("place");
		}
		page p_f = new page();
		p_f.setNowPage(nowPage_f);
		
		RoomsDao dao = new RoomsDao();
		List<RoomsListVo> list = dao.selectGoo(aType, p_f,place);
		
		req.setAttribute("list", list);
		req.setAttribute("p_f", p_f);
		
		String path = url + target;
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
		
		
	}
	
}

























































