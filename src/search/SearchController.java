package search;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.se")
public class SearchController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Search_doGet");
		doAction_Get(req, resp);
	}
	
	protected void doAction_Get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8"); // 응답 인코딩 설정(한글깨짐 방지)
		//SearchVo vo = new SearchVo(); // DB select
		SearchDao dao = new SearchDao();
		PrintWriter out = resp.getWriter();
		
		String data = ""; // 반환해줄 데이터

		// 요청받은 url 확인
		String temp = req.getRequestURI();
		int pos = temp.lastIndexOf("/");
		String tempUrl = temp.substring(pos);
		System.out.println(tempUrl);
		String findStr = req.getParameter("findStr");
		System.out.println("findStr : " + findStr);
		
		if(tempUrl.equals("/rsSearch.se")) {
			data = dao.search(findStr);
			System.out.println("data : " + data);
		}
		
		out.print(data);
		out.flush();
	}
}
