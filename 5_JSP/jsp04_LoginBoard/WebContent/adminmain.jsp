<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@page import ="com.login.dto.MyMemberDto" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Main</title>
</head>
<body>
<%
	MyMemberDto dto = (MyMemberDto)session.getAttribute("dto");

	if(dto == null){
		pageContext.forward("index.jsp");
	}
%>

<div>
	<span><%= dto.getMyname() %>님 환영합니다. (등급 : <%= dto.getMyrole() %>)</span>
	<a href="test.jsp">로그아웃</a>
</div>
</body>
</html>