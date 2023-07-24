package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.repository.UserInfoRepository;


public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserInfoRepository uiRepo = new UserInfoRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx+1);
		String path = "/WEB-INF/views/";
		if("list".equals(uri)) {
			path += "user-info/list.jsp";
			request.setAttribute("userInfoList", uiRepo.selectUserInfoList());
		}else if ("view".equals(uri)) {
			path += "user-info/view.jsp";
			String uiNum = request.getParameter("uiNum");
			Map<String, String> userInfo = uiRepo.selectUserInfoOne(uiNum);
			request.setAttribute("userInfo",userInfo);
		}else if ("insert".equals(uri)) {
			path += "user-info/insert.jsp";
		}else if ("update".equals(uri)) {
			path += "user-info/update.jsp";
			String uiNum = request.getParameter("uiNum");
			Map<String, String> userInfo = uiRepo.selectUserInfoOne(uiNum);
			request.setAttribute("userInfo", userInfo);
		}else if ("delete".equals(uri)) {
			path += "user-info/delete.jsp";
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
		if("insert".equals(uri)) {
			Map<String, String> parm = new HashMap<String, String>();
			parm.put("uiId", request.getParameter("uiId"));
			parm.put("uiPwd",  request.getParameter("uiPwd"));
			parm.put("uiName", request.getParameter("uiName"));
			int result = uiRepo.insertUserInfo(parm);
			request.setAttribute("msg", "회원 등록이 실패 하였습니다");
			request.setAttribute("url", "/user-info/list");
			if(result == 1) {
				request.setAttribute("msg", "회원 등록이 성공 하였습니다");
			}
		}else if ("update".equals(uri)) {
			Map<String, String> parm = new HashMap<String, String>();
			parm.put("uiId", request.getParameter("uiId"));
			parm.put("uiPwd",  request.getParameter("uiPwd"));
			parm.put("uiName", request.getParameter("uiName"));
			parm.put("uiNum", request.getParameter("uiNum"));
			int result = uiRepo.updateUserInfo(parm);
			request.setAttribute("msg", "회원 수정이 실패 하였습니다");
			request.setAttribute("url", "/user-info/update?uiNum="+request.getParameter("uiNum"));
			if(result == 1) {
				request.setAttribute("msg", "회원 수정이 성공 하였습니다");
			}
		}else if("delete".equals(uri)) {
			String uiNum =request.getParameter("uiNum");
			int result = uiRepo.deleteUserInfo(uiNum);
			request.setAttribute("msg", "삭제가 실패 하였습니다");
			request.setAttribute("url", "/user-info/view?uiNum="+request.getParameter("uiNum"));
			if(result == 1) {
				request.setAttribute("msg", "삭제가 성공 하였습니다");
				request.setAttribute("url", "/user-info/list");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
