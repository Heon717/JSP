package com.koreait.JSPExam3.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.JSPExam3.DBU;

public class UserDAO {

	public static void UserJoin(UserVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO jsp_user ( uid , upw , unm , gender ) VALUES ( ? , ? , ? , ?)";
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getUid());
			ps.setString(2, vo.getUpw());
			ps.setString(3, vo.getUnm());
			ps.setInt(4, vo.getGender());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBU.close(con, ps);
		}
	}
	// select 문만 ResultSet
	// select 문은 int ( 영양받은행 = 은 숫자라서 )
	public static int UserLogin(UserVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT * FROM jsp_user WHERE uid = ? " ;
		
		// 성공 : 1  아이디없음 : 2   비밀번호틀림 : 3   에러 : 0
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getUid());
			rs = ps.executeQuery();
			// 여기서 if문 rs.next() (boolean)는 아이디가 있다면 true 없다면 false 
			if (rs.next()) {
				// 입력한 비밀번호값
				String dbpw = rs.getString("upw");
				if (vo.getUpw().equals(dbpw)) {
					vo.setIuser(rs.getInt("iuser"));
					vo.setUnm(rs.getString("unm"));
					return 1;
					// 비밀번호 일치 : 성공
				} else {
					return 3;
					// 비밀번호 틀림
				}
			} else {
				return 2;
				// 아이디 없음
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBU.close(con, ps, rs);
		}
		return 0;
	}
}
