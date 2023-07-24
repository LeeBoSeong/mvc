<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>list</h3>

	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>비번</th>
		</tr>
		<c:forEach items="${userInfoList}" var="userinfo">
			<tr>
				<td>${userinfo.uiNum}</td>
				<td><a href="/user-info/view?uiNum=${userinfo.uiNum}">${userinfo.uiName}</td>
				<td>${userinfo.uiId}</td>
				<td>${userinfo.uiPwd}</td>
			</tr>
		</c:forEach>
		<tr>
			<td align="right" colspan="4"><button onclick="location.href='/user-info/insert'">등록</button>
		</tr>
	</table>
</body>
</html>