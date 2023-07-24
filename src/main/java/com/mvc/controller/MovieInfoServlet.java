package com.mvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.Tomcat.ExistingStandardWrapper;

import com.mvc.repository.MovieInfoRepository;

public class MovieInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MovieInfoRepository movieRepo = new MovieInfoRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx + 1);
		String path = "/WEB-INF/views/";

		if ("list".equals(uri)) {
			request.setAttribute("movieList", movieRepo.selectMovieList());
			path += "movie-info/list.jsp";
		} else if ("view".equals(uri)) {
			String miNum = request.getParameter("miNum");
			request.setAttribute("movie", movieRepo.selectMovieListOne(miNum));
			path += "movie-info/view.jsp";
		} else if ("insert".equals(uri)) {
			path += "movie-info/insert.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx+1);
		String path = "/WEB-INF/views/common/msg.jsp";
		if("insert".equals(uri)) {
			Map<String, String> movieInfoMap = new HashMap<String, String>();
			movieInfoMap.put("miTitle", request.getParameter("miTitle"));
			movieInfoMap.put("miDirector", request.getParameter("miDirector"));
			movieInfoMap.put("miDesc", request.getParameter("miDesc"));
			movieInfoMap.put("miGenre", request.getParameter("miGenre"));
			int result = movieRepo.insertMovieInfo(movieInfoMap);
			request.setAttribute("msg", "등록 실패");
			request.setAttribute("url", "/movie-info/list");
			if(result ==1) {
				request.setAttribute("msg", "등록 성공");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
