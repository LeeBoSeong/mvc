package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.repository.ClassInfoRepository;

public class ClassInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClassInfoRepository ciRepo = new ClassInfoRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = "";
		if ("/class-info/list".equals(uri)) {
			List<Map<String, String>> classInfoList = ciRepo.selectClassInfoList();
			request.setAttribute("classInfoList", classInfoList);
			path ="/WEB-INF/views/class-info/class-info-list.jsp";
		}else if("/class-info/view".equals(uri)) {
			List<Map<String, String>> classInfoList = ciRepo.selectClassInfoList();
			request.setAttribute("classInfoList", classInfoList);
			path ="/WEB-INF/views/class-info/class-info-view.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
