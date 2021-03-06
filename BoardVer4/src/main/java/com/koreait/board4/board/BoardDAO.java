package com.koreait.board4.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board4.DBU;
import com.koreait.board4.user.UserVO;

public class BoardDAO {
	public static int insBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board ( title , ctnt , iuser ) VALUES ( ? , ? , ?) ";
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIuser());
			
			return ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBU.close(con,ps);
		}
	}
	
	public static List<BoardVO> selBoardList() {
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.iboard, A.title, A.iuser, A.regdt ,B.unm "
				+ " FROM t_board A "
				+ " LEFT JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " ORDER BY A.iboard DESC ";
		
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				String unm = rs.getString("unm");
				
				BoardVO vo = new BoardVO();
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
				vo.setUnm(unm);
				
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBU.close(con, ps, rs);
		}
		return list;
	}
	
	public static BoardVO selBoard(int param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		BoardVO vo = null;
		
		String sql = " SELECT A.iboard, A.title, A.iuser , A.ctnt , A.regdt ,B.unm "
				+ " FROM t_board A "
				+ " LEFT JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " WHERE iboard = ? ";
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param);
			
			rs = ps.executeQuery();
			if(rs.next()) {	
				int iuser = rs.getInt("iuser");
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String regdt = rs.getString("regdt");
				String unm = rs.getString("unm");
				
				vo = new BoardVO();
				vo.setIuser(iuser);
				vo.setUnm(unm);
				vo.setTitle(title);
				vo.setCtnt(ctnt);
				vo.setRegdt(regdt);
			}
			return vo;		
		} catch (Exception e) {
			e.printStackTrace();
			return vo;
		} finally {
			DBU.close(con, ps, rs);
		}	
	}
	
	public static int delBoard(BoardVO iboard) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " DELETE FROM t_board WHERE iboard = ? ";
		
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard.getIboard());
			
			return ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBU.close(con, null);
		}
		return 0;
	}
	
	public static int updBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " UPDATE t_board SET title = ? , ctnt = ? , regdt = NOW() WHERE iboard = ? ";
		
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			ps.setString(1,	vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBU.close(con, ps);
		}
			
	}
}
