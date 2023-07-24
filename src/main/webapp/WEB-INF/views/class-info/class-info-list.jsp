<%@page import="java.security.interfaces.RSAKey"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>난 강의 리스트</h3>
<table border="1">
	<tr>
		<th>이름</th>
		<th>번호</th>
<c:forEach items="${classInfoList}" var="classInfo">
	<tr>
		<td>${classInfo.ciNum}</td>
		<td><a href="/class-info/view?ciNum=${classInfo.ciNum}">${classInfo.ciName}</td>
	
	</tr>
</c:forEach>
	<tr>
		<td align="right" colspan="4"><button onclick="location.href='/class-info/insert'">등록</button></td> 
	</tr>
 </table>
</body>
</html>