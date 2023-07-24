package com.mvc.repository;

import java.awt.image.DataBuffer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mariadb.jdbc.MariaDbConnection;

import com.mvc.common.DBCon;

public class UserInfoRepository {

	public List<Map<String, String>> selectUserInfoList() {
		List<Map<String, String>> userInfoList = new ArrayList<Map<String, String>>();
		try {
			Connection con = DBCon.getCon();
			String sql = "SELECT * FROM USER_INFO WHERE 1=1";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Map<String, String> userInfo = new HashMap<String, String>();
				userInfo.put("uiNum", rs.getString("UI_NUM"));
				userInfo.put("uiName", rs.getString("UI_NAME"));
				userInfo.put("uiId", rs.getString("UI_ID"));
				userInfo.put("uiPwd", rs.getString("UI_PWD"));
				userInfoList.add(userInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userInfoList;
	}
	
	public Map<String, String> selectUserInfoOne(String uiNum) {

		try {
			Connection con = DBCon.getCon();
			String sql = "SELECT * FROM USER_INFO WHERE 1=1 AND UI_NUM=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,uiNum);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Map<String, String> userInfo = new HashMap<String, String>();
				userInfo.put("uiNum", rs.getString("UI_NUM"));
				userInfo.put("uiName", rs.getString("UI_NAME"));
				userInfo.put("uiId", rs.getString("UI_ID"));
				userInfo.put("uiPwd", rs.getString("UI_PWD"));
				return userInfo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int insertUserInfo(Map<String, String> userInfo) {
		String sql = "INSERT INTO USER_INFO(UI_ID,UI_PWD,UI_NAME)";
		sql+=" VALUES(?,?,?)";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userInfo.get("uiId"));
			pstmt.setString(2, userInfo.get("uiPwd"));
			pstmt.setString(3, userInfo.get("uiName"));
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateUserInfo(Map<String, String> userInfo) {
		String sql = "UPDATE USER_INFO SET UI_ID=?, UI_PWD=?, UI_NAME =? WHERE UI_NUM=?";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userInfo.get("uiId"));
			pstmt.setString(2, userInfo.get("uiPwd"));
			pstmt.setString(3, userInfo.get("uiName"));
			pstmt.setString(4, userInfo.get("uiNum"));
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteUserInfo(String userNum) {
		String sql = "DELETE FROM USER_INFO WHERE UI_NUM=?";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userNum);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
