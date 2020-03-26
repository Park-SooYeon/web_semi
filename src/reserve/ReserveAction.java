package reserve;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReserveAction {
	ReserveDao dao;
	
	ReserveAction() {
		dao = new ReserveDao();
	}
	String rsInsert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg = "";
		boolean flag = false;
		
		// reserve.jsp에서 파라미터값 받아오기
		// 많은 데이터를 받아와야함..ㅎ
		String name = req.getParameter("reserve_name_k");
		String phone = req.getParameter("reserve_Phone_k");
		String payment = req.getParameter("paySelect_k");
		
		System.out.println("name : " + name);
		System.out.println("phone : " + phone);
		System.out.println("payment : " + payment);
		
		// 데이터베이스에 insert
		//flag = dao.insert();
		if(flag) { // insert 성공!
			msg = "정상 예약되었습니다.";
		} else { // insert 실패!
			msg = "예약 중 오류가 발생했습니다.\n고객센터에 문의해주세요.";
		}
		return msg;
	}
	String rsDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg = "";
		boolean flag = false;
		// reserve_modify.jsp에서 파라미터값 받아오기
		// 예약번호만 가져오면 됨!!
		
		// 데이터베이스에서 delete
		//flag = dao.delete();
		if(flag) { // insert 성공!
			msg = "정상 삭제되었습니다.";
		} else { // insert 실패!
			msg = "취소 중 오류가 발생했습니다.\n고객센터에 문의해주세요.";
		}
		return msg;
	}
}
