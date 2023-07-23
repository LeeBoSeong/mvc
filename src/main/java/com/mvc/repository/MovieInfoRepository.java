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

import javax.servlet.jsp.jstl.sql.Result;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

public class MovieInfoRepository {

	public List<Map<String, String>> selectMovieList() {
		String driverName = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/kd";
		String user = "root";
		String pwd = "kd1824java";

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		List<Map<String, String>> movieInfoList = new ArrayList<Map<String,String>>();
		try {
			Connection con = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT * FROM MOVIE_INFO WHERE 1=1";
			try (PreparedStatement pstmt = con.prepareStatement(sql)) {
				try(ResultSet rs = pstmt.executeQuery()) {
					while(rs.next()) {
						Map<String, String> movie = new HashMap<String, String>();
						movie.put("miNum", rs.getString("MI_NUM"));
						movie.put("miTitle", rs.getString("MI_TITLE"));
						movie.put("miDirector", rs.getString("MI_DIRECTOR"));
						movie.put("miGenre", rs.getString("MI_GENRE"));
						movie.put("miCredat", rs.getString("MI_CREDAT"));
						movie.put("miCnt", rs.getString("MI_CNT"));
						movieInfoList.add(movie);
					}
					
				} catch (Exception e) {
				}
			} catch (Exception e) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return movieInfoList;
	}
	
	public Map<String, String> selectMovieListOne(String miNum){
		String driverName = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/kd";
		String user = "root";
		String pwd = "kd1824java";

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT * FROM MOVIE_INFO WHERE 1=1 AND MI_NUM=?";
			try (PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, miNum);
				try(ResultSet rs = pstmt.executeQuery()) {
					while(rs.next()) {
						Map<String, String> movie = new HashMap<String, String>();
						movie.put("miNum", rs.getString("MI_NUM"));
						movie.put("miTitle", rs.getString("MI_TITLE"));
						movie.put("miDirector", rs.getString("MI_DIRECTOR"));
						movie.put("miDesc", rs.getString("MI_DESC"));
						movie.put("miGenre", rs.getString("MI_GENRE"));
						movie.put("miCredat", rs.getString("MI_CREDAT"));
						movie.put("miCnt", rs.getString("MI_CNT"));
						
						return movie;
					}
					
				} catch (Exception e) {
				}
			} catch (Exception e) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static void main(String[] args) {
		MovieInfoRepository movie = new MovieInfoRepository();
		List<Map<String, String>> moviList = movie.selectMovieList();
		for(Map<String, String> map : moviList) {
			System.out.println(map.toString());
		}
	}

}
