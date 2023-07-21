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

public class UserInfoRepository {

	public List<Map<String, String>> selectUserInfoList() {
		String driverName = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3307/kd";
		String user = "root";
		String pwd = "kd1824java";

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		List<Map<String, String>> userInfoList = new ArrayList<Map<String, String>>();
		try {
			Connection con = DriverManager.getConnection(url, user, pwd);
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
		String driverName = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3307/kd";
		String user = "root";
		String pwd = "kd1824java";

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection(url, user, pwd);
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

}
