<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>안녕</h3>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>감독</th>
			<th>장르</th>
			<th>개봉일</th>
			<th>관객수</th>
		</tr>
		<c:forEach items="${moviList}" var="moviList">
			<tr>
				<td>${moviList.miNum}</td>
				<td><a href="/movie-info/view?miNum=${moviList.miNum}">${moviList.miTitle}</td>
				<td>${moviList.miDirector}</td>
				<td>${moviList.miGenre}</td>
				<td>${moviList.miCredat}</td>
				<td>${moviList.miCnt}</td>
			</tr>
		</c:forEach>
	</table>
=======
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>영화 리스트</h2>
<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>장르</th>
		<th>감독</th>
		<th>개봉일</th>
		<th>관객수</th>
	</tr>
	
	<c:forEach items="${movieList}" var="movieList">
	<tr>
		<td>${movieList.miNum}</td>
		<td><a href="/movie-info/view?miNum=${movieList.miNum}">${movieList.miTitle}</td>
		<td>${movieList.miDirector}</td>
		<td>${movieList.miGenre}</td>
		<td>${movieList.miCredat}</td>
		<td>${movieList.miCnt}</td>
	</tr>
	</c:forEach>
	<tr>
		<td align="right" colspan="6"><button onclick="location.href='movie-info/insert'">등록</button>
	</tr>
</table>
>>>>>>> branch 'master' of https://github.com/LeeBoSeong/mvc.git
</body>
</html>