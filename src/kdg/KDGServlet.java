package kdg;

import java.io.IOException;
import java.util.ArrayList;
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
		case "/penshion.ff":
			penshion(req,resp);
			break;
		case "/guesthouse.ff":
			guesthouse(req,resp);
			break;
		case "/roomView.ff":
			roomView(req,resp);
			break;
		case "/gooSelect.ff":
			gooSelect(req,resp);
			break;
		case "/fillter.ff":
			fillter(req,resp);
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
	public void penshion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
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
	public void guesthouse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
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
		if(req.getParameter("place_f")!=null) {
			if(place=="구전체호텔"||place=="구전체모텔"||place=="구전체게하"||place=="구전체펜션") {
				place="";
			}else {
				place = req.getParameter("place_f");				
			}
		}
		page p_f = new page();
		p_f.setNowPage(nowPage_f);
		
		RoomsDao dao = new RoomsDao();
		List<RoomsListVo> list = dao.selectGoo(aType, p_f,place);
		
		req.setAttribute("list_f", list);
		req.setAttribute("p_f", p_f);
		req.setAttribute("place_f", place);
		
		String path = url + target;
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
		
		
	}

	
	
	public void fillter(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String place ="";	//호옥시 지역 선택했니?
		int aType = 0;		//숙소타입
		int nowPage =1;	//페이징
		String target ="";	//보낼 페이지
		String sort ="";	//가격 정렬 뭘로할거니
		//라디오 버튼이 만약 null로 들어온다면 초기값을 5로할거다
		int kind = 5;		//호텔 타입?
		int maxPeople =0;	//최대인원?
		int bedtype =5;		//베드 타입?
	
		List<String> fillter = new ArrayList<String>();//체크사항에 체크되어 값이 넘어오면 sql문은 만들어 배열에담아 dao에 전달
		List<String> pagingSql = new ArrayList<String>();
		SelectorVo2 svo = new SelectorVo2();// 체크사항 이외의 값들은 널이 아닐때만 담아 dao에 전달할것
		
		
		if(req.getParameter("place_f")!=null) {
			if(place=="구전체호텔"||place=="구전체모텔"||place=="구전체게하"||place=="구전체펜션") {
				place="";
			}else {
				place = req.getParameter("place_f");				
			}
			svo.setPlace(place);
		}
		if(req.getParameter("aType")!=null) {
			aType = Integer.parseInt(req.getParameter("aType"));
			svo.setaType(aType);
		}
		if(req.getParameter("nowPage_f")!=null) {
			nowPage = Integer.parseInt(req.getParameter("nowPage_f"));
			svo.setNowPage(nowPage);
		}
		if(req.getParameter("target")!=null) {
			target = req.getParameter("target");
			svo.setTarget(target);
		}
		if(req.getParameter("sort_f")!=null) {
			sort = req.getParameter("sort_f");
			svo.setSort(sort);
		}
		if(req.getParameter("kind")!=null) {
			kind = Integer.parseInt(req.getParameter("kind"));
			svo.setKind(kind);
		}
		if(req.getParameter("maxPeople")!=null) {
			maxPeople = Integer.parseInt(req.getParameter("maxPeople"));
			svo.setMaxPeople(maxPeople);
		}
		if(req.getParameter("bedtype")!=null) {
			bedtype = Integer.parseInt(req.getParameter("bedtype"));
			svo.setBedtype(bedtype);
		}
		
		//-----------체크사항이 on이라면 sql문을 만들어 fillter와 paginSql에 담을것-------------------------------------------------------
		
		if(req.getParameter("pt")!=null) {
			if(req.getParameter("pt")=="on") {
				fillter.add(" and R.pt = 1 ");
				pagingSql.add(" and R.pt =1 ");
			}	
		}
		if(req.getParameter("swim")!=null) {
			if(req.getParameter("swim")=="on") {
				fillter.add(" and S.swim = 1 ");
				pagingSql.add(" and S.swim =1 ");
			}	
		}
		if(req.getParameter("rest")!=null) {
			if(req.getParameter("rest")=="on") {
				fillter.add(" and S.rest = 1 ");
				pagingSql.add(" and S.rest =1 ");
			}	
		}
		if(req.getParameter("cafe")!=null) {
			if(req.getParameter("cafe")=="on") {
				fillter.add(" and S.cafe = 1 ");
				pagingSql.add(" and S.cafe =1 ");
			}	
		}
		if(req.getParameter("bar")!=null) {
			if(req.getParameter("bar")=="on") {
				fillter.add(" and S.bar = 1 ");
				pagingSql.add(" and S.bar =1 ");
			}	
		}
		if(req.getParameter("tv")!=null) {
			if(req.getParameter("tv")=="on") {
				fillter.add(" and R.tv = 1 ");
				pagingSql.add(" and R.tv =1 ");
			}	
		}
		if(req.getParameter("wifi")!=null) {
			if(req.getParameter("wifi")=="on") {
				fillter.add(" and R.wifi = 1 ");
				pagingSql.add(" and R.wifi =1 ");
			}	
		}
		if(req.getParameter("spa")!=null) {
			if(req.getParameter("spa")=="on") {
				fillter.add(" and R.spa = 1 ");
				pagingSql.add(" and R.spa =1 ");
			}	
		}
		if(req.getParameter("tub")!=null) {
			if(req.getParameter("tub")=="on") {
				fillter.add(" and R.tub = 1 ");
				pagingSql.add(" and R.tub =1 ");
			}	
		}
		if(req.getParameter("iron")!=null) {
			if(req.getParameter("iron")=="on") {
				fillter.add(" and R.iron = 1 ");
				pagingSql.add(" and R.iron =1 ");
			}	
		}
		if(req.getParameter("computer")!=null) {
			if(req.getParameter("computer")=="on") {
				fillter.add(" and R.computer = 1 ");
				pagingSql.add(" and R.computer =1 ");
			}	
		}
		if(req.getParameter("refr")!=null) {
			if(req.getParameter("refr")=="on") {
				fillter.add(" and R.refr = 1 ");
				pagingSql.add(" and R.refr =1 ");
			}	
		}
		if(req.getParameter("aircon")!=null) {
			if(req.getParameter("aircon")=="on") {
				fillter.add(" and R.aircon = 1 ");
				pagingSql.add(" and R.aircon =1 ");
			}	
		}
		if(req.getParameter("socket")!=null) {
			if(req.getParameter("socket")=="on") {
				fillter.add(" and R.socket = 1 ");
				pagingSql.add(" and R.socket =1 ");
			}	
		}
		if(req.getParameter("pet")!=null) {
			if(req.getParameter("pet")=="on") {
				fillter.add(" and S.pet = 1 ");
				pagingSql.add(" and S.pet =1 ");
			}	
		}
		if(req.getParameter("smoke")!=null) {
			if(req.getParameter("smoke")=="on") {
				fillter.add(" and S.smoke = 1 ");
				pagingSql.add(" and S.smoke =1 ");
			}	
		}
		if(req.getParameter("noSmoke")!=null) {
			if(req.getParameter("noSmoke")=="on") {
				fillter.add(" and S.noSmoke = 1 ");
				pagingSql.add(" and S.noSmoke =1 ");
			}	
		}
		if(req.getParameter("parking")!=null) {
			if(req.getParameter("parking")=="on") {
				fillter.add(" and S.parking = 1 ");
				pagingSql.add(" and S.parking =1 ");
			}	
		}
		if(req.getParameter("breakfast")!=null) {
			if(req.getParameter("breakfast")=="on") {
				fillter.add(" and S.breakfast = 1 ");
				pagingSql.add(" and S.breakfast =1 ");
			}	
		}
		if(req.getParameter("washer")!=null) {
			if(req.getParameter("washer")=="on") {
				fillter.add(" and S.washer = 1 ");
				pagingSql.add(" and S.wqsher =1 ");
			}	
		}
		if(req.getParameter("lounge")!=null) {
			if(req.getParameter("lounge")=="on") {
				fillter.add(" and S.lounge = 1 ");
				pagingSql.add(" and S.lounge =1 ");
			}	
		}
		if(req.getParameter("kitchen")!=null) {
			if(req.getParameter("kitchen")=="on") {
				fillter.add(" and S.kitchen = 1 ");
				pagingSql.add(" and S.kitchen =1 ");
			}	
		}
		if(req.getParameter("dryer")!=null) {
			if(req.getParameter("dryer")=="on") {
				fillter.add(" and S.dryer = 1");
				pagingSql.add(" and S.dryer =1");
			}	
		}
		if(req.getParameter("talsu")!=null) {
			if(req.getParameter("talsu")=="on") {
				fillter.add(" and S.talsu = 1 ");
				pagingSql.add(" and S.talsu =1 ");
			}	
		}
		
		page p_f = new page();
		p_f.setNowPage(nowPage);
	
		RoomsDao dao = new RoomsDao();
		List<RoomsListVo> list = dao.selector(svo,p_f,fillter,pagingSql);
		
		req.setAttribute("list_f", list);
		req.setAttribute("p_f", p_f);
		req.setAttribute("place_f", place);
		
		String path = url + target;
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}
	
}

























































