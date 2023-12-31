package com.mvc.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.repository.MarketInfoRepository;


public class MarketInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MarketInfoRepository mkRepo = new MarketInfoRepository();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx+1);
		String path = "/WEB-INF/views/";
		if("list".equals(uri)) {
			request.setAttribute("marketInfo", mkRepo.selectMarketInfoList());
			path+="market-info/list.jsp";
		}else if ("view".equals(uri)) {
			path+="market-info/view.jsp";
			String mkNum = request.getParameter("mkNum");
			Map<String, String> mkInfo = mkRepo.selectMakrketListOne(mkNum);
			request.setAttribute("mkInfo", mkInfo);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
