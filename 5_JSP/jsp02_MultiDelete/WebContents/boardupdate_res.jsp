<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@page import = "com.multi.dao.MDBoardDao" %>
<%@page import = "com.multi.dto.MDBoardDto" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<% 
	int seq = Integer.parseInt(request.getParameter("seq"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	MDBoardDto dto = new MDBoardDto();
	dto.setSeq(seq);
	dto.setTitle(title);
	dto.setContent(content);
	
	MDBoardDao dao = new MDBoardDao();
	int res = dao.update(dto);
	
	if(res>0){
%>
	<script type="text/javascript">
		alert("수정 성공");
		location.href="boardlist.jsp";
	</script>
<%		
	} else{
%>
	<script type="text/javascript">
		alert("수정 실패");
		location.href="boarddetail.jsp?=seq<%= seq%>";
	</script>
<%		
	}
%>

<body>

</body>
</html>