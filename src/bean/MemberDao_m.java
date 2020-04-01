package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MemberDao_m {
	Connection conn;
	String pattern ="{'nno' : '%s', 'title' : '%s', 'rDate' : '%s', 'memo' : '%s'},"; 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	String sql =null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	public MemberDao_m() {
		conn = DBConn.getConn();
	}
	public List<MemberVo_m> select(Page_m p) {
		
		List<MemberVo_m> list = new ArrayList<MemberVo_m>();
		int totList = 0;
		try {
			sql = " select count(title) cnt from notice "
				+ " where title like ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+p.getFindStr() + "%");
			rs= ps.executeQuery();
			if(rs.next()) totList = rs.getInt("cnt");
			p.setTotListSize(totList);
			p.pageCompute();
		
			sql = " select *from ( "
				+ "  select rownum rn, A.*from ( "
				+ "      select nno, title, to_char(rDate, 'rrrr-MM-dd') rDate, memo "
				+ "		 from notice "
				+ "		 where title like ? "
				+ "		 order by nno desc)A "
				+ " )where rn between ? and ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + p.getFindStr() + "%");
			ps.setInt(2, p.getStartNo());
			ps.setInt(3, p.getEndNo());
		
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberVo_m vo = new MemberVo_m();
				vo.setNno(rs.getInt("nno"));
				vo.setTitle(rs.getString("title"));
				vo.setrDate(rs.getString("rDate"));
				vo.setMemo(rs.getString("memo"));
				list.add(vo);
			
			}	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public String insert(String title, String memo) {
		String msg ="";
		
		try {
			sql = "insert into notice(nno, title, rDate, memo) "
				+ " values(seq_notice_nno.nextval,?,sysdate,?) ";

			/*conn.setAutoCommit(false);*/
		
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, memo);
			int r = ps.executeUpdate();
			
			if(r<1) {
				throw new Exception();
			}
			/*conn.commit();*/
		}catch(Exception ex) {
			msg = ex.toString();
		}finally {
			return msg;
		}
	}
	
	public String modify(int nno) {
		String msg = "게시물 내용이 수정 되었습니다.";
		
		sql = " update notice set title=?, memo=? where nno=? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,title);
			ps.setString(2,memo);
			ps.setInt(3, nno);
			
			int r = ps.executeUpdate();
			if(r<1) {
				throw new Exception();
			}
			conn.commit();
		}catch(Exception ex) {
			msg = ex.toString();
			conn.rollback();
		}finally {
			return msg;
		}
			
	}
	
	public String delete(String title) {
		String msg = "게시물이 삭제 되었습니다.";
		sql = " delete from notice where title= ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			
			int cnt = ps.executeUpdate();
			if(cnt<1) {
				throw new Exception("자료 삭제중 예외 발생");
			}
		}catch(Exception ex) {
			msg = ex.getMessage();
		}finally {
			return msg;
		}
	}
}





















