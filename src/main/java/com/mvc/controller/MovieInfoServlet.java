package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.repository.MovieInfoRepository;


public class MovieInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MovieInfoRepository movieRepo =  new MovieInfoRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();	
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx+1);
		String path = "/WEB-INF/views/";
		
		if("list".equals(uri)) {
			request.setAttribute("movieList", movieRepo.selectMovieList());
			path += "movie-info/list.jsp";
		}else if ("view".equals(uri)) {
			String miNum = request.getParameter("miNum");
			request.setAttribute("movie", movieRepo.selectMovieListOne(miNum));
			path += "movie-info/view.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
