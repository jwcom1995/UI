<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@page import = "com.my.dao.IconBoardDao" %>
<%@page import = "com.my.dto.IconBoardDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	
	String iName = request.getParameter("iName");
	String iDesigner = request.getParameter("iDesigner");
	String iImage = request.getParameter("iImage");
	String iPrice = request.getParameter("iPrice");
	String iDescript = request.getParameter("iDescript");
	
	IconBoardDto dto = new IconBoardDto();
	dto.setI_name(iName);
	dto.setI_designer(iDesigner);
	dto.setI_img(iImage);
	dto.setI_price(iPrice);
	dto.setI_description(iDescript);
	
	IconBoardDao dao = new IconBoardDao();
	int res=dao.insert(dto);
	if(res > 0){
		%>
	<script type="text/javascript">
		alert("새 글이 추가되었습니다.");
		location.href="mylist.jsp";
	</script>
		<%
	}else{
		%>
		<script type="text/javascript">
			alert("새 글 작성에 실패하였습니다.");
			location.href="mylist.jsp";
		</script>
			<%
	}
%>
</body>
</html>