package com.el.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.el.score.Score;

@WebServlet("/controller.do")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		
		if(command.equals("elpage")) {
			response.sendRedirect("basic.jsp");
		} else if(command.equals("eltest")) {
			Score sc = new Score("이창진",89,72,98);
			
			request.setAttribute("score", sc);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("eltest.jsp");
			dispatch.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
