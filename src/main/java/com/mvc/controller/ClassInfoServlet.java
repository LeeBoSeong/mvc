package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
			String ciNum = request.getParameter("ciNum");
			Map<String, String> classInfo = ciRepo.slectClassInfo(ciNum);
			request.setAttribute("classInfoList", classInfo);
			path ="/WEB-INF/views/class-info/class-info-view.jsp";
		}else if("/class-info/insert".equals(uri)) {
			path = "/WEB-INF/views/class-info/class-info-insert.jsp";
		}else if ("/class-info/update".equals(uri)) {
			String ciNum = request.getParameter("ciNum");
			Map<String, String> classInfo = ciRepo.slectClassInfo(ciNum);
			request.setAttribute("classInfoList", classInfo);
			path = "/WEB-INF/views/class-info/class-info-update.jsp";
		}else if ("/class-info/delete".equals(uri)) {
			path = "/WEB-INF/views/class-info/class-info-delete.jsp";
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx+1);
		String path = "/WEB-INF/views/common/msg.jsp";
		
		if ("insert".equals(uri)) {
			Map<String, String> ciList = new HashMap<String, String>();
			ciList.put("ciName", request.getParameter("ciName")); 
			ciList.put("ciDesc", request.getParameter("ciDesc"));
			int result = ciRepo.insertClassInfo(ciList);
			request.setAttribute("msg","등록 불가");
			request.setAttribute("url","/class-info/list");
			if(result == 1) {
				request.setAttribute("msg","등록 완료");				
			}
		}else if ("update".equals(uri)) {
			Map<String, String> classInfo = new HashMap<String, String>();
			classInfo.put("ciNum",request.getParameter("ciNum"));
			classInfo.put("ciName",request.getParameter("ciName"));
			classInfo.put("ciDesc",request.getParameter("ciDesc"));
			
			int result = ciRepo.updateClassInfo(classInfo);
			request.setAttribute("msg", "업데이트 실패");
			request.setAttribute("url", "/class-info/update?ciNum="+request.getParameter("ciNum"));
			if(result == 1) {
				request.setAttribute("msg", "업데이트 성공");
				request.setAttribute("url", "/class-info/list");
			}
		}else if("delete".equals(uri)) {
			String ciNum = request.getParameter("ciNum");
			int result = ciRepo.deleteClassInfo(ciNum);
			request.setAttribute("msg", "삭제 실패");
			request.setAttribute("url", "/class-info/view?ciNum="+request.getParameter("ciNum"));
			if(result == 1) {
				request.setAttribute("msg", "삭제 성공");
				request.setAttribute("url", "/class-info/list");
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
