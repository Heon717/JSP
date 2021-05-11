package com.koreait.board4.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board4.DBU;

public class UserDAO {
	public static int joinUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO t_user ( uid , upw , unm , gender) VALUES ( ? , ? , ? , ? )";
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			ps.setString(2, param.getUpw());
			ps.setString(3, param.getUnm());
			ps.setInt(4, param.getGender());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBU.close(con, ps);
		}
	}
	
	// 로그인 성공 : 1 , 아이디없음 : 2 , 비밀번호틀림 : 3 , 에러 : 0
	public static int loginUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM t_user WHERE uid = ? ";
		
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs = ps.executeQuery();
			// rs.next() 줄을 가르킴 불린타입이고 첫줄이 없으면 아이디가없다는뜻;
			if(rs.next()) {
				// 아이디가 있는경우 & 비밀번호 체크
				String dbPw = rs.getString("upw");
				//왼쪽(앞) 암호화안된값 , 오른쪽(뒤) 암호화된 값
				if(BCrypt.checkpw(param.getUpw(), dbPw)) {
					int iuser = rs.getInt("iuser");
					String num = rs.getString("unm");
					param.setIuser(iuser);
					param.setUnm(num);
					return 1;
				} else {
					return 3;
				}
			} else {
				// 아이디가 없는경우
				return 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBU.close(con, ps, rs);
		}
		return 0;
	}
}
