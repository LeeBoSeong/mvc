package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> lotto = new ArrayList();

	public LottoServlet() {
		Random random = new Random();
		while (lotto.size() < 6) {
			String rNum = random.nextInt(45) + 1 + "";
			if (!lotto.contains(rNum)) {
				lotto.add(rNum);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx + 1);
		String path = "/WEB-INF/views/";
		int cnt = 0;
		if ("lotto".equals(uri)) {
			path += "lotto/lotto.jsp";

		} else if ("comp".equals(uri)) {
			String[] nums = request.getParameterValues("num");

			for (int i = 0; i < 6; i++) {
				if (lotto.contains(nums[i])) {
					cnt++;
				}
			}
			// 로또와 넘s 안에 값들을 비교하여 몇개 밎추었는지 result.jsp로 보내준다
			path += "lotto/result.jsp";
		}
		request.setAttribute("cnt", cnt);
		request.setAttribute("lotto", lotto);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
