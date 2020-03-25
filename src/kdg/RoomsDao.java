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
	
	public List<RoomsListVo> select(int aType) {
		List<RoomsListVo> list = new ArrayList<RoomsListVo>();
		String sql = "";
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
			sql =" select S.rCode a, S.rName b, S.gInfo c, S.sysFile d, S.stars e, S.address f, min(R.price) price"
				+"	from rooms S join room R "
				+"	on S.rCode = R.rCode "
				+"	where S.atype =? "
				+"	group by S.rCode, S.rName, S.gInfo, S.sysFile, S.stars, S.address "
				+"  order by S.rCode";
			ps =conn.prepareStatement(sql);
			ps.setInt(1, aType);
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
