package com.mvc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketInfoRepository {

	public List<Map<String, String>> selectMarketInfoList() {
		String driverName = "org.mariadb.jdbc.Driver";
		String uri = "jdbc:mariadb://localhost:3306/kd";
		String user = "root";
		String pwd = "kd1824java";

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		List<Map<String, String>> marketInfoList = new ArrayList<Map<String,String>>();
		try (Connection con = DriverManager.getConnection(uri, user, pwd)) {
			String sql = "SELECT * FROM MARKET_INFO WHERE 1=1";
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				try(ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						Map<String, String> marketInfo = new HashMap<String, String>();
						marketInfo.put("mkNum", rs.getString("MK_NUM"));
						marketInfo.put("mkName", rs.getString("MK_NAME"));
						marketInfo.put("mkPrice", rs.getString("MK_PRICE"));
						marketInfoList.add(marketInfo);
					}
				} catch (Exception e) {
				}
			} catch (Exception e) {
			}
		} catch (Exception e) {
		}
		return marketInfoList;
	}
	
	public Map<String, String> selectMakrketListOne(String mkNum){
		String driverName = "org.mariadb.jdbc.Driver";
		String uri = "jdbc:mariadb://localhost:3306/kd";
		String user = "root";
		String pwd = "kd1824java";
		
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection(uri,user,pwd)) {
			String sql = "SELECT * FROM MARKET_INFO WHERE 1=1 AND MK_NUM=?";
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, mkNum);
				try(ResultSet rs = pstmt.executeQuery()) {
					while(rs.next()) {
						Map<String, String> mkList = new HashMap<String, String>();
						mkList.put("mkNum", rs.getString("MK_NUM"));
						mkList.put("mkName", rs.getString("MK_NAME"));
						mkList.put("mkPrice", rs.getString("MK_PRICE"));
						mkList.put("mkDesc", rs.getString("MK_DESC"));
						
						return mkList;
					}
				} catch (Exception e) {
				}
			} catch (Exception e) {
			}
		} catch (Exception e) {
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		MarketInfoRepository market = new MarketInfoRepository();
		for(Map<String, String> map : market.selectMarketInfoList()) {
			System.out.println(map.toString());
		}
	}
}
