<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>ONE</h3>
	<form action="/class-info/delete" method="POST">
	<input type="hidden" name="ciNum" value="${classInfoList.ciNum}">
		<table border="1">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>내용</th>
			</tr>
			<tr>
				<td>${classInfoList.ciNum}</td>
				<td>${classInfoList.ciName}</td>
				<td>${classInfoList.ciDesc}</td>
				<button onclick="location.href='/class-info/update?ciNum=${classInfoList.ciNum}'" type="button">수정</button>
				<button>삭제</button>
			</tr>
		</table>
	</form>
</body>
</html>