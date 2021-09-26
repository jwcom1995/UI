<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@page import ="com.login.dto.MyMemberDto" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MyMemberDto dto = (MyMemberDto)session.getAttribute("dto");
	
	if(dto==null){
		pageContext.forward("index.jsp");
	}

%>
	<%= dto.getMyid() %>
</body>
</html>