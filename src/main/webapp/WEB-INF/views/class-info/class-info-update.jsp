<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/class-info/update" method="POST">
	<input type="hidden" name="ciNum" value="${classInfoList.ciNum}">
		<input type="text" name="ciName" placeholder="이름" value="${classInfoList.ciName}"><br>
		<input type="text" name="ciDesc" placeholder="내용" value="${classInfoList.ciDesc}"><br>
			<button>스정</button>
	</form>
</body>
</html>