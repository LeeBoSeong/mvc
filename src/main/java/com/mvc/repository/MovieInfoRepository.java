package com.mvc.repository;

import java.net.Authenticator.RequestorType;
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

import com.mvc.common.DBCon;

public class MovieInfoRepository {

	public List<Map<String, String>> selectMovieList() {
<<<<<<< HEAD
		String driverName = "org.mariadb.jdbc.Driver";
		String uri = "jdbc:mariadb://localhost:3306/kd";
		String user = "root";
		String pwd = "ll09130731";

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		List<Map<String, String>> movieList = new ArrayList<Map<String,String>>();
		try (Connection con = DriverManager.getConnection(uri, user, pwd)) {
			String sql = "SELECT * FROM MOVIE_INFO WHERE 1=1";
			try (PreparedStatement ptstm = con.prepareStatement(sql)) {
				try (ResultSet rs = ptstm.executeQuery()) {
					while (rs.next()) {
						Map<String, String> movie = new HashMap<String, String>();
						movie.put("miNum",rs.getString("MI_NUM"));
						movie.put("miTitle",rs.getString("MI_TITLE"));
						movie.put("miDirector",rs.getString("MI_DIRECTOR"));
						movie.put("miDesc",rs.getString("MI_DESC"));
						movie.put("miGenre",rs.getString("MI_GENRE"));
						movie.put("miCredat",rs.getString("MI_CREDAT"));
						movie.put("miCnt",rs.getString("MI_CNT"));
						movieList.add(movie);
					}
				} catch (Exception e) {
				}
			} catch (Exception e) {
			}
		} catch (Exception e) {
		}

		return movieList;
	}
	public static void main(String[] args) {
		
		MovieInfoRepository m = new MovieInfoRepository();
		List<Map<String, String>>movieList = m.selectMovieList();
		for(Map<String, String> map : movieList) {
			System.out.println(map.toString());
		}
	}
=======
		List<Map<String, String>> movieInfoList = new ArrayList<Map<String, String>>();
		try {
			Connection con = DBCon.getCon();
			String sql = "SELECT * FROM MOVIE_INFO WHERE 1=1";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Map<String, String> movie = new HashMap<String, String>();
				movie.put("miNum", rs.getString("MI_NUM"));
				movie.put("miTitle", rs.getString("MI_TITLE"));
				movie.put("miDirector", rs.getString("MI_DIRECTOR"));
				movie.put("miGenre", rs.getString("MI_GENRE"));
				movie.put("miCredat", rs.getString("MI_CREDAT"));
				movie.put("miCnt", rs.getString("MI_CNT"));
				movieInfoList.add(movie);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return movieInfoList;
	}

	public Map<String, String> selectMovieListOne(String miNum) {

		try {
			Connection con = DBCon.getCon();
			String sql = "SELECT * FROM MOVIE_INFO WHERE 1=1 AND MI_NUM=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, miNum);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public int insertMovieInfo(Map<String, String> movieList) {
		try (Connection connection = DBCon.getCon()) {
			String sql = "INSERT INTO MOVIE_INFO(MI_TITLE,MI_DIRECTOR,MI_DESC,MI_GENRE) VALUES(?,?,?,?)";
			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
				pstmt.setString(1, movieList.get("miTitle"));
				pstmt.setString(2, movieList.get("miDirector"));
				pstmt.setString(3, movieList.get("miDesc"));
				pstmt.setString(4, movieList.get("miGenre"));

				return pstmt.executeUpdate();
			} catch (Exception e) {
			}
		} catch (Exception e) {
		}
		return 0;
	}

	public static void main(String[] args) {
		MovieInfoRepository movie = new MovieInfoRepository();
		List<Map<String, String>> moviList = movie.selectMovieList();
		for (Map<String, String> map : moviList) {
			System.out.println(map.toString());
		}
	}

>>>>>>> branch 'master' of https://github.com/LeeBoSeong/mvc.git
}
