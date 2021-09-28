<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@page import = "com.login.dto.MyMemberDto" %>
<%@page import = "java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function updateRole(myno){
		location.href="logincontroller.jsp?command=updateroleform&myno="+myno;
	}
</script>
</head>
<body>
<%
	List<MyMemberDto> list = (List<MyMemberDto>)request.getAttribute("list");
%>
<h1>회원정보조회(enabled)</h1>
<table border="1">
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
		<th>등급</th>
		<th>등급변경</th>
	</tr>
<%
	for(MyMemberDto dto : list){
%>
	<tr>
		<td><%= dto.getMyno() %></td>
		<td><%= dto.getMyid() %></td>
		<td><%= dto.getMyname() %></td>
		<td><%= dto.getMyemail() %></td>
		<td><%= dto.getMyrole() %></td>
		<td align="center"><button onclick="updateRole(<%= dto.getMyno()%>);">변경</button></td>
	</tr>
<%
	}
%>	<tr>
		<td colspan="6" align="right">
			<button onclick="location.href='adminmain.jsp'">메인</button>
		</td>
	</tr>	
</table>
</body>
</html>