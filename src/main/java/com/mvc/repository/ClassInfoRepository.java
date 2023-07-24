package com.mvc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;

import com.mvc.common.DBCon;

public class ClassInfoRepository {

	public List<Map<String, String>> selectClassInfoList() {

		List<Map<String, String>> classInfoList = new ArrayList<>();
		try {
			Connection con = DBCon.getCon();
			String sql = "SELECT * FROM CLASS_INFO WHERE 1=1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Map<String, String> cl = new HashMap();
				cl.put("ciNum", rs.getString("CI_NUM"));
				cl.put("ciName", rs.getString("CI_NAME"));
				cl.put("ciDesc", rs.getString("CI_DESC"));
				classInfoList.add(cl);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classInfoList;
	}

	public Map<String, String> slectClassInfo(String ciNum) {

		try {
			Connection con = DBCon.getCon();
			String sql = "SELECT * FROM CLASS_INFO WHERE 1=1 AND CI_NUM=? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ciNum);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, String> cl = new HashMap();
				cl.put("ciNum", rs.getString("CI_NUM"));
				cl.put("ciName", rs.getString("CI_NAME"));
				cl.put("ciDesc", rs.getString("CI_DESC"));
				return cl;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int insertClassInfo(Map<String, String> clInfoList) {
		try (Connection con = DBCon.getCon()) {
			String sql = "INSERT INTO CLASS_INFO(CI_NAME,CI_DESC) VALUES(?,?)";
			try (PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, clInfoList.get("ciName"));
				pstmt.setString(2, clInfoList.get("ciDesc"));

				return pstmt.executeUpdate();
			} catch (Exception e) {
			}
		} catch (Exception e) {
		}
		return 0;
	}

	public int updateClassInfo(Map<String, String> ciInfo) {
		try (Connection con = DBCon.getCon()) {
			String sql = "UPDATE CLASS_INFO SET CI_NAME=?, CI_DESC=? WHERE CI_NUM=?";
			try (PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, ciInfo.get("ciName"));
				pstmt.setString(2, ciInfo.get("ciDesc"));
				pstmt.setString(3, ciInfo.get("ciNum"));
				return pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public int deleteClassInfo(String ciNum) {
		try(Connection con = DBCon.getCon()){
			String sql ="DELETE FROM CLASS_INFO WHERE CI_NUM=?";
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, ciNum);
				return pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public static void main(String[] args) {
		ClassInfoRepository cl = new ClassInfoRepository();
		cl.selectClassInfoList();
	}
}
