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

public class ClassInfoRepository {
	
	public List<Map<String, String>> selectClassInfoList() {
		String driverName = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3307/kd";
		String user ="root";
		String pwd = "kd1824java";
	
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		List<Map<String, String>> classInfoList = new ArrayList();
		try {
			Connection con = DriverManager.getConnection(url,user,pwd);
			String sql = "SELECT * FROM CLASS_INFO WHERE 1=1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
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
	
	public Map<String, String> slectClassInfo() {
		String driverName = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3307/kd";
		String user ="root";
		String pwd = "kd1824java";
		
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url,user,pwd);
			String sql = "SELECT * FROM CLASS_INFO WHERE 1=1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
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
	public static void main(String[] args) {
		ClassInfoRepository cl = new ClassInfoRepository();
		cl.selectClassInfoList();
	}
}
