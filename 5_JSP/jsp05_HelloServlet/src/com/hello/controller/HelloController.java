package com.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController extends HttpServlet{
	
	private String initP;
	
	public HelloController() {
		System.out.println("servlet 생성자");
	}
	
	@Override
	public void init(ServletConfig config) {
		System.out.println("servlet init(생성)");
	
		System.out.println("context param: "+config.getServletContext().getInitParameter("url"));
		
		initP = config.getInitParameter("driver");
		System.out.println("init param:"+initP);
				
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		System.out.println("get 방식");
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("post 방식");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("파라미터: "+command);
		
		//doPost() 메소드를 실행한 브라우저로 출력
		PrintWriter out = response.getWriter();
		out.print("<h1 style='background-color:skyblue;'>helloServlet</h1>");
		out.print("<h2>servlet 라이프사이클, url mapping</h2>");
		out.print("<a href='home.html'>돌아가기</a>");
	}
	
	@Override
	public void destroy() {
		System.out.println("servlet destroy(종료)");
	}
}
