
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@page import="com.login.dto.MyMemberDto"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	MyMemberDto dto =(MyMemberDto)request.getAttribute("dto");
%>
<body>
	<h1>내 정보 보기</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<td><%= dto.getMyid() %></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><%= dto.getMypw() %></td>
		</tr>
		<tr>
			<th>NAME</th>
			<td><%= dto.getMyname() %></td>
		</tr>
		<tr>
			<th>ADDR</th>
			<td><%= dto.getMyaddr() %></td>
		</tr>
		<tr>
			<th>PHONE</th>
			<td><%= dto.getMyphone() %></td>
		</tr>
		<tr>
			<th>EMAIL</th>
			<td><%= dto.getMyemail() %></td>
		</tr>
		<tr>
			<th>ROLE</th>
			<td><%= dto.getMyrole().equals("ADMIN")?"관리자":dto.getMyrole().equals("MANAGER")?"매니저":"정회원" %></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="수정" onclick="">
				<input type="button" value="탈퇴" onclick="">
				<input type="button" value="메인" onclick="location.href='usermain.jsp'">
			</td>
		</tr>
	</table>
</body>
</html>