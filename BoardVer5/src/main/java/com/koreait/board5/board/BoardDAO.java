package com.koreait.board5.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board5.DBU;

public class BoardDAO {

	public static int insertBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board ( title , ctnt , iuser ) VALUES ( ? , ? , ? ) " ;
		
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIuser());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBU.close(con, ps);
		}	
		return 0;
	}
	
	public static List<BoardVO> selBoardList() {
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT A.iboard, A.title, A.iuser, A.regdt, B.unm FROM t_board A LEFT JOIN t_user B "
				+ " ON A.iuser = B.iuser ORDER BY A.iboard DESC ";
		
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				String unm = rs.getString("unm");
				int iboard = rs.getInt("iboard");
				int iuser = rs.getInt("iuser");
				
				BoardVO vo = new BoardVO();
				vo.setIboard(iboard);
				vo.setIuser(iuser);
				vo.setTitle(title);
				vo.setRegdt(regdt);
				vo.setUnm(unm);
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBU.close(con, ps, rs);
		}
		return list;
	}
	
	public static BoardVO sleBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.iboard, A.title, A.iuser , A.ctnt , A.regdt ,B.unm "
				+ " , if(C.iboard IS NULL, 0,1) AS isFav"
				+ " FROM t_board A "
				+ " LEFT JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " LEFT JOIN t_board_fav C "
				+ " ON A.iboard = C.iboard "
				+ " AND C.iuser = ? "
				+ " WHERE A.iboard = ? ";
		
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			ps.setInt(1,param.getIuser()); // 로그인 user PK
			ps.setInt(2,param.getIboard());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String regdt = rs.getString("regdt");
				String unm = rs.getString("unm");
				int iboard = rs.getInt("iboard");
				int iuser = rs.getInt("iuser");
				
				BoardVO vo = new BoardVO();
				vo.setTitle(title);
				vo.setUnm(unm);
				vo.setCtnt(ctnt);
				vo.setRegdt(regdt);
				vo.setIboard(iboard);
				vo.setIuser(iuser);
				vo.setIsFav(rs.getInt("isFav"));
				
				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBU.close(con, ps);
		}
		return null;
	}
	
	public static int updBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " UPDATE t_board SET title = ? , ctnt = ? , regdt = NOW() WHERE iboard = ? ";
		
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());
			
			return ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBU.close(con, ps);
		}	
	}
	
	public static int delBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " DELETE FROM t_board WHERE iboard = ? " ;
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBU.close(con, ps);
		}		
	}
}
