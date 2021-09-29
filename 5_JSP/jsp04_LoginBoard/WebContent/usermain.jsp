<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@page import = "com.login.dto.MyMemberDto" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	MyMemberDto dto =(MyMemberDto)session.getAttribute("dto");
%>
<body>
	<h1>메인화면</h1>
	<div>
		<span><%= dto.getMyname() %>님 환영합니다. (등급: <%= dto.getMyrole() %>)</span>
		<a href="logincontroller.jsp?command=logout">로그아웃</a>
	</div>
	<div>
		<div>
			<a href="logincontroller.jsp?command=userinfo&myno=<%= dto.getMyno()%>">내 정보보기</a>
		</div>
	</div>
</body>
</html>