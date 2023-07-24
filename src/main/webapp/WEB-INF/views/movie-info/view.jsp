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
<h2>상세 화면</h2>
<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>감독</th>
		<th>장르</th>
		<th>내용</th>
		<th>개봉일</th>
		<th>관객수</th>
	</tr>
	<tr>
		<td>${movie.miNum}</td>
		<td>${movie.miTitle}</td>
		<td>${movie.miDirector}</td>
		<td>${movie.miGenre}</td>
		<td>${movie.miDesc}</td>
		<td>${movie.miCredat}</td>
		<td>${movie.miCnt}</td>
	</tr>
</table>
</body>
</html>