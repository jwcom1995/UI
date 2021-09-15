<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@page import = "com.my.dao.IconBoardDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	
	IconBoardDao dao = new IconBoardDao();
	String [] check = request.getParameterValues("delContents");
	
	for(int i = 0 ; i <check.length;i++){
		dao.delete(Integer.parseInt(check[i]));
	}
%>
	<script type="text/javascript">
		location.href="mylist.jsp";
	</script>
</body>
</html>