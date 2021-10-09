package com.answer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.answer.biz.AnswerBiz;
import com.answer.dao.AnswerDao;
import com.answer.dto.AnswerDto;


@WebServlet("/answer.do")
public class AnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩 언어 셋팅
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("[command:"+command+"]");
		
		AnswerDao dao = new AnswerDao();
		
		if(command.equals("list")) {
			List<AnswerDto> list = dao.selectAll();
			
			request.setAttribute("list", list);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("boardlist.jsp");
			dispatch.forward(request, response);
			
		} else if(command.equals("detail")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			
			AnswerDto dto = dao.selectOne(boardno);
			
			request.setAttribute("dto", dto);
			RequestDispatcher dispatch = request.getRequestDispatcher("boarddetail.jsp");
			dispatch.forward(request, response);
			
		} else if (command.equals("writeform")){
			response.sendRedirect("boardwrite.jsp");
		
		} else if (command.equals("boardwrite")) {
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			AnswerDto dto = new AnswerDto(writer,title,content);
			
			int res = dao.insert(dto);
			
			if(res>0) {
				dispatch("answer.do?command=list",request,response);
			} else {
				dispatch("answer.do?command=writeform",request,response);
			}
			
		} else if (command.equals("updateform")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			
			AnswerDto dto = dao.selectOne(boardno);
			
			request.setAttribute("dto", dto);
			
			dispatch("boardupdate.jsp",request,response);
			
		} else if (command.equals("boardupdate")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			AnswerDto dto = new AnswerDto();
			dto.setBoardno(boardno);
			dto.setTitle(title);
			dto.setContent(content);
			
			int res = dao.update(dto);
			
			if(res>0) {
				dispatch("answer.do?command=list&",request,response);
			} else {
				dispatch("answer.do?command=detail&boardno="+boardno,request,response);
			}
			
		} else if (command.equals("delete")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			
			int res= dao.delete(boardno);
			
			if(res>0) {
				dispatch("answer.do?command=list",request,response);
			}else {
				dispatch("answer.do?command=detail&boardno="+boardno,request,response);
			}
			
		} else if(command.equals("answerform")) {
			int parentboardno = Integer.parseInt(request.getParameter("parentboardno"));
			
			AnswerDto dto = dao.selectOne(parentboardno);
			request.setAttribute("parent", dto);
			dispatch("answerwrite.jsp",request,response);
						
		} else if (command.equals("answerwrite")) {
			int parentboardno = Integer.parseInt(request.getParameter("parentboardno"));
			
			String writer =request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			AnswerDto parent= dao.selectOne(parentboardno);
			
			int parentgroupno = parent.getGroupno();
			int parentgroupsq = parent.getGroupsq();
			int parenttitletab = parent.getTitletab();
			
			AnswerDto dto = new AnswerDto(0,parentgroupno,parentgroupsq,parenttitletab,title,content,writer,null);
			
			boolean res = new AnswerBiz().answerLogic(dto);
			
			if(res) {
				response.sendRedirect("answer.do?command=list");
			} else {
				response.sendRedirect("answer.do?command=detail&boardno="+parentboardno);
			}
			
		}
				
	}
	
	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
