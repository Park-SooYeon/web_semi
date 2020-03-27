package kdg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomsDao {
	Connection conn;
	public RoomsDao() {
		conn = DBConn.getConn();
	}
	
	public List<RoomsListVo> select(int aType,page p_f) {
		List<RoomsListVo> list = new ArrayList<RoomsListVo>();
		String sql = "";
		PreparedStatement ps =null;
		ResultSet rs =null;
		int totList = 0;
		
		try {
			sql = " select count(rcode) cnt"
				+ " from rooms"
				+ " where atype=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aType);
			rs = ps.executeQuery();
			if(rs.next()) {
				totList = rs.getInt("cnt");
			}
			p_f.setTotListSize(totList);
			p_f.pageCompute();
			
			
			sql	=" select * from ( "
				+" 	select rownum rn , A.* from ("
				+" select S.rCode a, S.rName b, S.gInfo c, S.sysFile d, S.stars e, S.address f, min(R.price) price"
				+"	from rooms S join room R "
				+"	on S.rCode = R.rCode "
				+"	where S.atype =? "
				+"	group by S.rCode, S.rName, S.gInfo, S.sysFile, S.stars, S.address "
				+"  order by S.rCode ) A"
				+" ) where rn between ? and ?";
			ps =conn.prepareStatement(sql);
			ps.setInt(1, aType);
			ps.setInt(2, p_f.getStartNo());
			ps.setInt(3, p_f.getEndNo());
			rs = ps.executeQuery();
			while(rs.next()) {
				RoomsListVo vo = new RoomsListVo();
				vo.setrCode(rs.getInt("a"));
				vo.setrName(rs.getString("b"));
				vo.setgInfo(rs.getString("c"));
				vo.setSysFile(rs.getString("d"));
				vo.setStars(rs.getInt("e"));
				vo.setAddress(rs.getString("f"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return list;
		}
	}
	public List<RoomsListVo> selectGoo(int aType,page p_f,String place) {
	      List<RoomsListVo> list = new ArrayList<RoomsListVo>();
	      String sql = "";
	      PreparedStatement ps =null;
	      ResultSet rs =null;
	      int totList = 0;
	      String[] p = place.split(",");
	      
	      try {
	         sql = " select count(rcode) cnt"
	            + " from rooms"
	            + " where atype=? and (rplace=? or rplace=? or rplace=? or rplace=?)";
	         ps = conn.prepareStatement(sql);
	         ps.setInt(1, aType);
	         ps.setString(2, p[0]);
	         ps.setString(3, p[1]);
	         ps.setString(4, p[2]);
	         ps.setString(5, p[3]);
	         rs = ps.executeQuery();
	         if(rs.next()) {
	            totList = rs.getInt("cnt");
	         }
	         p_f.setTotListSize(totList);
	         p_f.pageCompute();
	         
	         
	         sql   =" select * from ( "
	            +"    select rownum rn , A.* from ("
	            +" select S.rCode a, S.rName b, S.gInfo c, S.sysFile d, S.stars e, S.address f, min(R.price) price"
	            +"   from rooms S join room R "
	            +"   on S.rCode = R.rCode "
	            +"   where S.atype =? and (S.rplace=? or S.rplace=? or S.rplace=? or S.rplace=?)"
	            +"   group by S.rCode, S.rName, S.gInfo, S.sysFile, S.stars, S.address "
	            +"  order by S.rCode ) A"
	            +" ) where rn between ? and ?";
	         ps =conn.prepareStatement(sql);
	         ps.setInt(1, aType);
	         ps.setString(2, p[0]);
	         ps.setString(3, p[1]);
	         ps.setString(4, p[2]);
	         ps.setString(5, p[3]);
	         ps.setInt(6, p_f.getStartNo());
	         ps.setInt(7, p_f.getEndNo());
	         rs = ps.executeQuery();
	         while(rs.next()) {
	            RoomsListVo vo = new RoomsListVo();
	            vo.setrCode(rs.getInt("a"));
	            vo.setrName(rs.getString("b"));
	            vo.setgInfo(rs.getString("c"));
	            vo.setSysFile(rs.getString("d"));
	            vo.setStars(rs.getInt("e"));
	            vo.setAddress(rs.getString("f"));
	            vo.setPrice(rs.getInt("price"));
	            list.add(vo);
	         }
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         return list;
	      }
	   
	   }
	
	
	
	
}
