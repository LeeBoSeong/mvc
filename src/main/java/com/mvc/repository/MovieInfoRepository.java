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

public class MovieInfoRepository {

	public List<Map<String, String>> selectMovieList() {
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
}
