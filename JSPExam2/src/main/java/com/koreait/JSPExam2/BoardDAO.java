package com.koreait.JSPExam2;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Param;

public class BoardDAO { // 셀렉트문 빼고는 ResultSet 필요가없음 ( 결과값은 셀렉트문에서만 나오기때문에 )
	
	public static int insertBoard(BoardVO vo) {  // insert 글등록
		Connection con = null;   // 데이터베이스에 연결
		PreparedStatement ps = null; // 어떤 sql문을 쓸지 장착개념
		
		String sql = "INSERT INTO a_board (title,ctnt) VALUES ( ? , ? )";
		
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			
			ps.executeUpdate();   // insert, update, delete
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBU.close(con, ps);
		}
		return 0;
	}
	

	public static List<BoardVO> selectBoardList() { // list 전체 select
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BoardVO> li = new ArrayList();
		
		String sql = " SELECT * FROM a_board ORDER BY num DESC";
		
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();  //   select 실행한결과값을 rs에 넣어준다.
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setRg(rs.getString("rg"));
				
				li.add(vo);
			}
			return li;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBU.close(con, ps, rs);
		}
		return null;
	}
											    // try 문이 있으면 throw 안해도됨
	public static BoardVO selectBoard(int num) { // detail 의 select (한줄)
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT * FROM a_board WHERE num = ? ";
		
	
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			
			rs = ps.executeQuery(); // select
			
			if(rs.next()) {
				BoardVO vo = new BoardVO();
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String rg = rs.getString("rg");
				
				vo.setNum(num);
				vo.setTitle(title);
				vo.setCtnt(ctnt);
				vo.setRg(rg);
				
				return vo;	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBU.close(con, ps , rs);
		}
		return null;
	}
	
	public static int updboard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " UPDATE a_board SET title = ? , ctnt = ? WHERE num = ? ";
		
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql); 
			ps.setString(1,vo.getTitle());
			ps.setString(2,vo.getCtnt());
			ps.setInt(3,vo.getNum());
			
			return ps.executeUpdate(); // insert, update, delete
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBU.close(con, ps);
		}
		return 0;
	}
	
	public static int delboard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM a_board WHERE num = ? ";
		
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getNum());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBU.close(con, ps);
		}
		
		return 0;
	}
}
