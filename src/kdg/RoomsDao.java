package kdg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.DBConn;

public class RoomsDao {
	Connection conn;
	public RoomsDao() {
		conn = DBConn.getConn();
	}
	//처음상태 일때 데이터만들기
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
	//구 선택시 대이터 만들기
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
			
			
			sql	=" select * from ( "
				+" 	select rownum rn , A.* from ("
				+" select S.rCode a, S.rName b, S.gInfo c, S.sysFile d, S.stars e, S.address f, min(R.price) price"
				+"	from rooms S join room R "
				+"	on S.rCode = R.rCode "
				+"	where S.atype =? and (S.rplace=? or S.rplace=? or S.rplace=? or S.rplace=?)"
				+"	group by S.rCode, S.rName, S.gInfo, S.sysFile, S.stars, S.address "
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
	//필터링 적용
	public List<RoomsListVo> selector(SelectorVo2 svo,page p_f,List<String> fillter,List<String> pasingSql){
		List<RoomsListVo> list = new ArrayList<RoomsListVo>();
		String sql = " select count(S.rcode) cnt "
					+" from rooms S join room R "
					+" on S.rCode = R.rCode "
					+" where S.atype=? and (S.rplace=? or S.rplace=? or S.rplace=? or S.rplace=?) ";
		String sql2 =" select * from ( "
					+" 		select rownum rn , A.* from ( "
					+" 			select S.rCode a, S.rName b, S.gInfo c, S.sysFile d, S.stars e, S.address f, min(R.price) price "
					+"			from rooms S join room R "
					+"			on S.rCode = R.rCode "
					+"			where S.atype =? and (S.rplace=? or S.rplace=? or S.rplace=? or S.rplace=?) ";
		List<Integer> pagelist = new ArrayList<Integer>();//나중에 ps에 setInt를 할때 몇개의 정보가 있는지 확인을위해 list.size()를 사용할것임
		List<Integer> mainlist = new ArrayList<Integer>();//나중에 ps에 setInt를 할때 몇개의 정보가 있는지 확인을위해 list.size()를 사용할것임
		PreparedStatement ps =null;
		ResultSet rs =null;
		int totList = 0;
		String[] p = svo.getPlace().split(",");
		
		//최대인원 조건추가
		sql += " and maxPeople >= ?";
		sql2 += " and maxPeople >= ?";
		pagelist.add(svo.maxPeople);
		mainlist.add(svo.maxPeople);
		if(svo.kind!=5) {//kind가 5가 아니라면
			sql += " and S.kind = ? ";
			sql2+= " and S.kind = ? ";
			pagelist.add(svo.kind);
			mainlist.add(svo.kind);
			
			if(svo.bedtype!=5) {//bedtype이 5가 아니라면
				sql +=" and R.bed =? ";
				sql2 +=" and R.bed =? ";
				pagelist.add(svo.bedtype);
				mainlist.add(svo.bedtype);
				
				if(pagelist.size()>0) {//페이징sql에 값이 담겨있다면
					for(int i=0;i<pasingSql.size();i++) {//페이지sql 사이즈만금 돌아라~
						sql += pasingSql.get(i);
						pagelist.add(1);
					}
				}else {//페이징sql에 값이 담겨있다면
					
				}
				
				if(fillter.size()>0) {//필터에 값이 담겨있다면
					for(int i=0;i<fillter.size();i++) {//필터의 사이즈만큼 돌아라~~~~~~~~~~
						sql2 += fillter.get(i);
						mainlist.add(1);
					}
				}else {//필터에 값이 담겨있다면
					
				}
				
			}else {//bedtype 이 5 라면
				
			}
		}else {//kind가 5 라면
			
		}
		sql2 +=" 	group by S.rCode, S.rName, S.gInfo, S.sysFile, S.stars, S.address "
			 +"  	order by S.rCode ) A "
			 +" ) where rn between ? and ?";
		if(svo.getSort()=="asc") {
			sql2+= " oder by price ";
		}else if(svo.getSort()=="dsc") {
			sql2+= " oder by price desc ";
		}
		try {
			//페이징 sql 열기---------------------------------
			ps = conn.prepareStatement(sql);
			ps.setInt(1,svo.getaType());
			ps.setString(2, p[0]);
			ps.setString(3, p[1]);
			ps.setString(4, p[2]);
			ps.setString(5, p[3]);
			if(pagelist.size()>0) {//페이징을 위한 sql을 담은 list 에 값이 존재한다면
				for(int i=0;i<pagelist.size();i++) {
					ps.setInt(5+i+1, pagelist.get(i));
				}
			}
			rs = ps.executeQuery();
			if(rs.next()) {
				totList = rs.getInt("cnt");
			}
			p_f.setTotListSize(totList);
			p_f.pageCompute();
			
			
			//메인 sql열기-------------------------------------
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, svo.getaType());
			ps.setString(2, p[0]);
			ps.setString(3, p[1]);
			ps.setString(4, p[2]);
			ps.setString(5, p[3]);
			if(mainlist.size()>0) {
				for(int i=0;i<mainlist.size();i++) {
					ps.setInt(5+i+1, mainlist.get(i));
				}
			}
			ps.setInt(5 + mainlist.size()+1, p_f.getStartNo());
			ps.setInt(5 + mainlist.size()+2, p_f.getEndNo());
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
			
		}finally {
			return list;
		}
	}
}

















































