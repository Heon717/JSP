package com.koreait.board3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//Data Access Object (DB 담당)
public class BoardDAO {
	
	// 글등록
	public static int insertBoard(BoardVO3 vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board (title, ctnt) "
				+ " VALUES (?, ?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setString(1,vo.getTitle());
			ps.setString(2, vo.getContent());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
	}
	public static List<BoardVO3> selBoardList() {
		List<BoardVO3> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;  // 레코드 한줄
		
		String sql = "SELECT iboard, title, regdt FROM t_board"
				+ " ORDER BY iboard DESC ";
		
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql); // insert, update, delete
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardVO3 vo = new BoardVO3();
				list.add(vo);
				
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return list;
		
	}
	
	public static BoardVO3 selBoard(int iboard) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM t_board WHERE iboard = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql); // insert, update, delete
			ps.setInt(1, iboard);
			
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				BoardVO3 vo = new BoardVO3();
				
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String regdt = rs.getString("regdt");
				
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setContent(ctnt);
				vo.setRegdt(regdt);
				
				return vo;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return null;
	}
	
	public static int delBoard(int iboard) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM t_board WHERE iboard = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setInt(1,iboard); 
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
	}
	
	public static int updBoard(BoardVO3 iboard) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "UPDATE t_board SET title = ? , ctnt = ? WHERE iboard = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setString(1, iboard.getTitle());
			ps.setString(2, iboard.getContent());
			ps.setInt(3, iboard.getIboard());
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
	}
}
