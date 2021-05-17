package com.koreait.board5.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.koreait.board5.DBU;

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
}
