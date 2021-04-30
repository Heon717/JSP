package com.koreait.board3;

import java.sql.Connection;
import java.sql.PreparedStatement;

//Data Access Object (DB 담당)
public class BoardDAO {
	
	// 글등록
	public static int insertBoard(BoardVO3 vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board (title, ctnt) "
				+ " VALUSE (?, ?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setString(1,"dsddd");
			ps.setString(2, vo.getContent());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
	}
}
