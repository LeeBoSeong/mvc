<%@page import="java.security.interfaces.RSAKey"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>난 강의 리스트</h3>
<table border="1">
<%
List<Map<String,String>> classInfoList = (List<Map<String,String>>)request.getAttribute("classInfoList");
for(Map<String,String> ciList : classInfoList){
	%>
		<tr>
			<th>번호</th>
			<td><%=ciList.get("ciNum") %></td>
		
		
			<th>이름</th>
			<td><a href="/class-info/view.jsp?ciNum=<%=ciList.get("ciNum")%>"><%=ciList.get("ciName") %></td>
		
	
			<th>desc</th>
			<td><%=ciList.get("ciDesc") %></td>
		</tr>
	<%
}
 %>
 </table>
</body>
</html>