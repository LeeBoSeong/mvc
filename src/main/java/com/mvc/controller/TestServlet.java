package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx+1);
		String path = "/WEB-INF/views/";
		if("list".equals(uri)) {
			path += "test-info/list.jsp";
		}else if ("view".equals(uri)) {
			path += "test-info/view.jsp";
		}else if ("insert".equals(uri)) {
			path += "test-info/insert.jsp";
		}else if ("update".equals(uri)) {
			path += "test-info/update.jsp";
		}else if ("delete".equals(uri)) {
			path += "test-info/delete.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
