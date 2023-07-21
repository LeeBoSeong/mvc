package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx+1);
		String path = "/WEB-INF/views/";
		if("calc".equals(uri)) {
			path += "calc/input.jsp";
		}else {
			int num1 = Integer.parseInt(request.getParameter("num1"));
			int num2 = Integer.parseInt(request.getParameter("num2"));
			int result = 0;
			if("p".equals(uri)) {
				result = num1 + num2;
			}else if ("s".equals(uri)) {
				result = num1 - num2;
			}else if ("m".equals(uri)) {
				result = num1 * num2;
			}else if ("d".equals(uri)) {
				result = num1 / num2;
			}
			request.setAttribute("result", result);
			path += "calc/result.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		response.getWriter().append("Served at: ").append("It gonna go to " + path + " page!");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
