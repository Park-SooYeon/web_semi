package servlet;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import bean.MemberDao_m;
import bean.MemberVo_m;
import bean.Page_m;

@WebServlet("*.mm")
public class MemberServlet_m extends HttpServlet{
	String url = "../plus_menu";
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		select(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String temp = req.getRequestURI();
		int pos = temp.lastIndexOf("/");
		String tempUrl = temp.substring(pos);
		//System.out.println(url + tempUrl);
		switch(tempUrl) {
		case "/nt_insert.mm":
			insert(req, resp);                       
			break;
		case "/nt_modify.mm":
			modify(req,resp);
			break;
		case "/nt_select.mm":
			select(req, resp);
			break;
		case "/nt_delete.mm":
			delete(req,resp);
			break;
		case "/nt_update.mm":
			update(req,resp);
			break;
		case "/nt_insertview.mm":
			insertView(req, resp);
			break;
		}
	}
	
	public void insertView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String path = url + "/nt_insert.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}
	
	public void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String path = url + "/nt_update.jsp";
		String bbsTitle = req.getParameter("bbsTitle");
		String bbsContent = req.getParameter("bbsContent");
		MemberDao_m dao = new MemberDao_m();
		String msg = dao.insert(bbsTitle, bbsContent);
		req.setAttribute("msg", msg);
		System.out.println("title=" + bbsTitle );
		System.out.println("memo =" + bbsContent);
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}
	
	public void modify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String path = url+"/nt_modify.jsp";
		MemberDao_m dao = new MemberDao_m();
		String title = req.getParameter("title");
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
		
	}
	public void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		MemberDao_m dao = new MemberDao_m();
		int nowPage= 1;
		String findStr = "";
		
		if(req.getParameter("nowPage") != null) {
			nowPage = Integer.parseInt(req.getParameter("nowPage"));
		}
		if(req.getParameter("findStr") != null) {
			findStr = req.getParameter("findStr");
		}
		
		Page_m p = new Page_m();
		p.setNowPage(nowPage);
		p.setFindStr(findStr);
		p.pageCompute();
		
		List<MemberVo_m> list = dao.select(p);		
		req.setAttribute("list", list);
		req.setAttribute("p", p);
		
		String path = url + "nt_select.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
		
		
	}
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String path = url + "/nt_delete.jsp";
		MemberDao_m dao = new MemberDao_m();
		String title = req.getParameter("title");
		String msg = dao.delete(title);
		req.setAttribute("msg", msg);
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}
	public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{	
	 String path = url + "/nt_update.jsp";
	
	}
}

