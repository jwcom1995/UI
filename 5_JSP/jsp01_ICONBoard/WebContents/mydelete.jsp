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
	int ino = Integer.parseInt(request.getParameter("ino"));
	IconBoardDao dao = new IconBoardDao();
	
	int res=dao.delete(ino);
	
	if(res > 0){
		%>
	<script type="text/javascript">
		alert("게시글이 삭제되었습니다");
		location.href="mylist.jsp";
	</script>
		<%
	}else{
		%>
		<script type="text/javascript">
			alert("게시글 삭제를 실패하였습니다.");
			location.href="mylist.jsp";
		</script>
			<%
	}
%>
</body>
</html>