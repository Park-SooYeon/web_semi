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
		conn = DBConn.getConn("web", "web");
	}
	public List<MemberVo_m> select(Page_m p) {
		
		List<MemberVo_m> list = new ArrayList<MemberVo_m>();
		int totList = 0;
		try {
			sql = " selelct count(title) cnt from notice "
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
				+ "		 order by title)A "
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

	public String insert(MemberVo_m) {
		String msg ="게시물이 정상적으로 등록 되었습니다.";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}





















