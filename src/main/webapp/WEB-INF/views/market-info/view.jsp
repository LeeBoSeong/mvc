<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>물품의 상세 설명</h1>
<table border="1">
	<tr>
	<th>번호</th>
	<td>${mkOne.mkNum}</td>
	<th>이름</th>
	<td>${mkOne.mkName}</td>
	<th>설명</th>
	<td>${mkOne.mkDesc}</td>
	<th>가격</th>
	<td>${mkOne.mkPrice}</td>
	</tr>
</table>
</body>
</html>