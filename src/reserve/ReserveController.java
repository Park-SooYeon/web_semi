package reserve;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

@WebServlet("*.rs")
public class ReserveController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		doAaction(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		doAaction(req, resp);
	}
	
	protected void doAaction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8"); // 응답 인코딩 설정(한글깨짐 방지)
		String msg = "ajax 혼내준다ㅡㅡ"; // 예약 or 예약 취소할 때, 성공 or 실패 메세지 반환
		
		// 요청받은 url 확인
		String temp = req.getRequestURI();
		int pos = temp.lastIndexOf("/");
		String tempUrl = temp.substring(pos);
		System.out.println(tempUrl);
		
		ReserveAction ra = new ReserveAction();
		Map<String, String[]> param = req.getParameterMap();
		System.out.println(param.get("reserve_name_k")[0]);
		switch(tempUrl) {
		case "/rsInsert.rs":
			// 예약 현황 테이블에 데이터 추가
			msg = ra.rsInsert(req, resp);
			break;
		case "/rsDelete.rs":
			// 예약 현황 테이블에서 데이터 제거
			break;
		}
		
		// 데이터 반환
		PrintWriter out = resp.getWriter();
		out.print(msg);
		out.flush();
	}
}
