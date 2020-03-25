package com.user.mypage.contoroller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

public class MpDao {
	Connection conn;
	public MpDao() {
		conn = DBConn.getConn();
	}
	
	public MpVo mpView(String email) {
		PreparedStatement pstmt = null;
		ResultSet set = null;
		MpVo vo = null;
		String query = "select * from membership where email=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "ddddd");
			set = pstmt.executeQuery();
			
			if(set.next()) {
				vo = new MpVo();
				vo.setmNo(set.getInt("mno"));
				vo.seteMail(set.getString("email"));
				vo.setPwd(set.getString("pwd"));
				vo.setPhone(set.getString("phone"));
				vo.setmName(set.getString("nname"));
				vo.setBirth(set.getDate("birth"));
				vo.setuName(set.getString("uname"));
				vo.setmAdmin(set.getInt("madmin"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public List<ReListVo> reList(String eMail) {
		String query = "select a.rcode, a.rname, a.rplace, a.ginfo, a.orifile, a.sysfile, a.address from rooms a join reserve b on a.rcode=b.rno where b.email=?";
		PreparedStatement pstmt = null;
		ResultSet set = null;
		ReListVo vo = null;
		List<ReListVo> list = new ArrayList<ReListVo>();
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, "ddddd");
			set=pstmt.executeQuery();
			
			while(set.next()){
				vo = new ReListVo();
				vo.setrCode(set.getInt("rcode"));
				vo.setrName(set.getString("rname"));
				vo.setrPlace(set.getString("rplace"));
				vo.setgInfo(set.getString("ginfo"));
				vo.setOriFile(set.getString("orifile"));
				vo.setSysFile(set.getString("sysfile"));
				vo.setAddress(set.getString("address"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public ResVo resView(String rCode) {
		PreparedStatement pstmt;
		ResultSet set = null;
		ResVo vo = null;
		String query = "select * from reserve where rCode=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rCode);
			set=pstmt.executeQuery();
			
			if(set.next()) {
				vo = new ResVo();
				vo.setrNo(set.getInt("rno"));
				vo.setrName(set.getString("rname"));
				vo.setrPhone(set.getString("rphone"));
				vo.setrCode(set.getInt("rcode"));
				vo.setrDate(set.getDate("rDate"));
				vo.setPeriod(set.getInt("period"));
				vo.setPayment(set.getString("payment"));
				vo.setPrice(set.getInt("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
}
