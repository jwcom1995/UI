package com.bike.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bike.dao.BikeDao;
import com.bike.dto.BikeDto;


@WebServlet("/BikeServlet")
public class BikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command= request.getParameter("command");
		System.out.println("[command: "+command+"]");
		
		
		if(command.equals("first")) {
			response.sendRedirect("bike01.jsp");
			
		} else if (command.equals("first_db")) {
			//같은 이름에 다양한 값이 넘어올 경우 getParameterValues 로 받음
			String[] bikeList = request.getParameterValues("bike");
			List<BikeDto> dtos = new ArrayList<BikeDto>();
			
			for(int i = 0 ; i<bikeList.length;i++) {
				String[] tmp = bikeList[i].split("/");
				
				BikeDto dto = new BikeDto(tmp[0],
						Integer.parseInt(tmp[1]),
						tmp[2],
						tmp[3],
						Integer.parseInt(tmp[4]),
						Double.parseDouble(tmp[5]),
						Double.parseDouble(tmp[6]));
				
				dtos.add(dto);
			}
			
			int res = new BikeDao().insert(dtos);
			if(res== dtos.size()) {
				System.out.println("\n insert 성공 \n");
				response.sendRedirect("index.html");
			} else {
				System.out.println("\n insert 실패 \n");
				response.sendRedirect("bike01.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
