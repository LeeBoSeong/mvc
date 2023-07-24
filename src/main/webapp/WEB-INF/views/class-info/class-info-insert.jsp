<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/class-info/insert" method="POST">
		<input type="text" name="ciName" placeholder="이름"> 
		<input type="text" name="ciDesc" placeholder="내용">
			<button>등록</button>
	</form>
</body>
</html>