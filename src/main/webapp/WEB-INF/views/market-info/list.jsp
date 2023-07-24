<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>마켓 물품 리스트</h1>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>가격</th>
		</tr>

		<c:forEach items="${marketInfo}" var="marketList">
			<tr>
				<td>${marketList.mkNum}</td>
				<td><a href="/market-info/view?mkNum=${marketList.mkNum}">${marketList.mkName}</td>
				<td>${marketList.mkPrice}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>