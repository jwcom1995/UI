package com.score.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;


@WebServlet("/CalScore")
public class CalScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name=request.getParameter("name");
		int kor=Integer.parseInt(request.getParameter("kor"));
		int eng=Integer.parseInt(request.getParameter("eng"));
		int math=Integer.parseInt(request.getParameter("math"));
		
		int sum=kor+eng+math;
		double avg = (double)sum/3;
		
		//json-simple : 자바에서 json을 처리하기 위한 라이브러리
		//JSONObject 클래스 (hash map을 상속받음)
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		obj.put("sum", sum);
		obj.put("avg", avg);
		//{"name":value, "sum":value, "avg":value}
	      
	      //printwriter을 통해서 응답을 해준다.
	     PrintWriter out = response.getWriter();
	     out.println(obj.toJSONString());
	      
	      System.out.println("servlet에서 보내는 데이터: "+obj.toJSONString());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
