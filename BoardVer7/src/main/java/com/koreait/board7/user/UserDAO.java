package com.koreait.board7.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board7.DBU;

public class UserDAO {
	//중복체크 아이디 있으면 ㅣ 1     없으면 : 0 
	public static int selIdChk(String uid) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT uid FROM t_user WHERE uid = ? ";
		
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			ps.setString(1, uid.trim());
			rs = ps.executeQuery();
			if (rs.next()) {
				result = 1;
				return result;
			}		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBU.close(con, ps, rs);
		}
		return result;
	}
	
	public static int loginUser(UserEntity vo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT * FROM t_user WHERE uid = ? ";
		
		try {
			con = DBU.getcon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getUid());
			rs = ps.executeQuery();
			// rs.next() 줄을 가르킴 불린타입이고 첫줄이 없으면 아이디가없다는뜻;
			if(rs.next()) {
				// 아이디가 있는경우 & 비밀번호 체크
				String dbPw = rs.getString("upw");
				//왼쪽(앞) 암호화안된값 , 오른쪽(뒤) 암호화된 값
				if(BCrypt.checkpw(vo.getUpw(), dbPw)) {
					int iuser = rs.getInt("iuser");
					String num = rs.getString("unm");
					vo.setIuser(iuser);
					vo.setUnm(num);
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

public static int joinUser(UserEntity vo) {
	Connection con = null;
	PreparedStatement ps = null;
	String sql = " INSERT INTO t_user ( uid , upw , unm , gender ) VALUES ( ? , ? , ? , ? )" ;
	
	try {
		con = DBU.getcon();
		ps = con.prepareStatement(sql);
		ps.setString(1, vo.getUid());
		ps.setString(2, vo.getUpw());
		ps.setString(3, vo.getUnm());
		ps.setInt(4, vo.getGender());
		
		return ps.executeUpdate();	
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		DBU.close(con, ps);
	}
	return 0;
}
}
