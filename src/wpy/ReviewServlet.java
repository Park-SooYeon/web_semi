package wpy;

import java.io.IOException;
import java.io.InvalidObjectException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.vi")
public class ReviewServlet extends HttpServlet {
  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "index.jsp?=./kdg/rooms_view.jsp";
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		String temp = req.getRequestURI();
		int pos = temp.lastIndexOf("/"); //주소에서 mm과 관련된 파일명만 가져오기 위해서
		String tempUrl = temp.substring(pos);
		switch (tempUrl) {
		case "/roomReview.vi":
			roomReview(req, resp);
			break;
		}
		
	}
	public void roomReview(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "../wpy/roomReview.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(path);
		
		rd.forward(req, resp);

	}
  
}
