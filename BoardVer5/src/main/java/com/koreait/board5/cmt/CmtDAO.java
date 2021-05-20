package com.koreait.board5.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board5.DBU;


// select문은 vo insert delete update 는 int or void
public class CmtDAO { 
	public static void insCmt(CmtVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board_cmt ( iboard, iuser, cmt) VALUES ( ? , ? , ? );";
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			ps.setInt(2, vo.getIuser());
			ps.setString(3, vo.getCmt());
		
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBU.close(con, ps);
		}
	}
	
	public static List<CmtVO> selListCmt(int vo) {
		List<CmtVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.iuser, A.cmt, B.unm, A.regdate, A.icmt FROM t_board_cmt A  "
				+ " INNER JOIN t_user B ON A.iuser = B.iuser WHERE A.iboard = ? ";
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			ps.setInt(1,vo);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CmtVO cvo = new CmtVO();
				cvo.setIboard(cvo.getIboard());
				cvo.setIuser(rs.getInt("iuser"));
				cvo.setCmt(rs.getString("cmt"));
				cvo.setUnm(rs.getString("unm"));
				cvo.setRegdate(rs.getString("regdate"));
				cvo.setIcmt(rs.getInt("icmt"));
			
				list.add(cvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBU.close(con, ps, rs);
		}	
		return list;
	}
	
	public static int delCmt(CmtVO cvo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " DELETE FROM t_board_cmt WHERE icmt = ? AND iboard = ? ";
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			ps.setInt(1,cvo.getIcmt());
			ps.setInt(2, cvo.getIboard());
			
			return ps.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBU.close(con, ps);
		}
	}
	
	public static int updCmt(CmtVO cvo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " UPDATE t_board_cmt SET cmt = ? WHERE icmt = ? AND iuser = ? ";
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			ps.setString(1,cvo.getCmt());
			ps.setInt(2,cvo.getIcmt());
			ps.setInt(3, cvo.getIuser());
			
			return ps.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBU.close(con, ps);
		}
	}
}
