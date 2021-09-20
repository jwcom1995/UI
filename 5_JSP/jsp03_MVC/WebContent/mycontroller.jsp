<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@page import = "com.mvc.dto.MVCBoardDto" %>
<%@page import = "com.mvc.dao.MVCBoardDao" %>
<%@page import = "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>controller</title>
</head>
<body>
<%
	//페이지의 요청 정보 받음
	String command = request.getParameter("command");
	System.out.println("[command: "+command+"]");

	MVCBoardDao dao = new MVCBoardDao();
	
	if(command.equals("boardlist")){
		List<MVCBoardDto> list = dao.selectAll();
		
		request.setAttribute("allList", list); 	//request객체에 allList에 dao.selectAll()에서 받아온 값을 저장
		pageContext.forward("boardlist.jsp"); 	//페이지 이동을 위한 forward
		/*
			포워드 : request,response 유지.
			(page마다 request,response가 존재 / 포워드 방식으로 request,response을 유지,공유해줌)
			
			리다이렉트 : 다른 페이지로 이동할경우 request,response 유지 X
			
		*/
	
	} else if(command.equals("boarddetail")){
		int seq =Integer.parseInt(request.getParameter("seq"));
		
		MVCBoardDto dto = dao.selectOne(seq);
		
		request.setAttribute("dto", dto);
		pageContext.forward("boarddetail.jsp");
	
	} else if(command.equals("boardinsertform")){
		
		response.sendRedirect("boardinsert.jsp");	// 다음 페이지에 전달해줄 값이 없는 경우
	
	} else if(command.equals("boardinsert")){
		
		String writer = request.getParameter("writer");
		String title= request.getParameter("title");
		String content = request.getParameter("content");
	
		MVCBoardDto dto = new MVCBoardDto();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		
		int res=dao.insert(dto);
		
		if(res>0){
%>
		<script type="text/javascript">
			alert("글 작성 성공");
			location.href="mycontroller.jsp?command=boardlist";
		</script>
<%
		} else{
%>
		<script type="text/javascript">
			alert("글 작성 실패");
		</script>
<%			response.sendRedirect("mycontroller.jsp?command='boardinsertform'");
		}
		
	} else if(command.equals("boardupdateform")){
		
		int seq= Integer.parseInt(request.getParameter("seq"));
		
		MVCBoardDto dto = dao.selectOne(seq);
		request.setAttribute("dto",dto);
		
		pageContext.forward("boardupdate.jsp");
	
	} else if(command.equals("boardupdate")){
	
		int seq= Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MVCBoardDto dto = new MVCBoardDto();
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContent(content);
		
		int res = dao.update(dto);
		
		if(res>0){
%>
		<script type="text/javascript">
			alert("수정 완료")
			location.href = "mycontroller.jsp?command=boarddetail&seq=<%= seq%>"
		</script>
<%			
		} else{
%>
		<script type="text/javascript">
			alert("수정 실패")
			location.href = "mycontroller.jsp?command=boardupdateform&seq=<%= seq%>"
		</script>
<%
		}
	} else if(command.equals("boarddelete")){
		String[] seqArr = new String[1];
		seqArr[0] = request.getParameter("seq");
		
		int res = dao.multiDelete(seqArr);
		
		if(res>0){
%>
		<script type="text/javascript">
			alert("삭제 완료")
			location.href = "mycontroller.jsp?command=boardlist"
		</script>
<%			
		} else{
%>
		<script type="text/javascript">
			alert("삭제 실패")
			location.href = "mycontroller.jsp?command=boarddetail&seq=<%= seqArr[0]%>"
		</script>
<%
		}
		
	} else if(command.equals("muldel")){
		String[] chks = request.getParameterValues("chk");
		
		if(chks.length==0 || chks==null){
%>
		<script type="text/javascript">
			alert("하나 이상 체크해주세요");
		</script>
<%
		response.sendRedirect("mycontroller.jsp?command=boardlist");
		} else{
			
			int res = dao.multiDelete(chks);
			
			if(res == chks.length){
%>
			<script type="text/javascript">
				alert("삭제 성공");
				location.href="mycontroller.jsp?command=boardlist";
			</script>
<%			
			}else{
%>
		<script type="text/javascript">
			alert("삭제 실패");
		</script>
<%			response.sendRedirect("mycontroller.jsp?command=boardlist");
				
			}
		}
	}
%>
</body>
</html>