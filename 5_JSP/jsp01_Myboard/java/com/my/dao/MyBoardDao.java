package com.my.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.dto.MyBoardDto;

public class MyBoardDao {
	Connection con=null;
	public MyBoardDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("01. driver 연결");
		} catch (ClassNotFoundException e) {
			System.out.println("error : driver 연결 실패");
			e.printStackTrace();
		}
	}
	
	//전체출력
	public List<MyBoardDto> selectAll(){
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","JW","JW");
			System.out.println("02. 계정 연결");
		} catch (SQLException e) {
			System.out.println("error : 계정 연결 실패");
			e.printStackTrace();
		}
		
		Statement stmt= null;
		ResultSet rs =null;
		String sql = "SELECT * FROM MYBOARD";
		List<MyBoardDto> res = new ArrayList<MyBoardDto>();
		
		try {
			stmt= con.createStatement();
			System.out.println("03. query 준비 : "+ sql);
			
			rs = stmt.executeQuery(sql);
			System.out.println("04. query 실행 및 리턴");
			
			while(rs.next()) {
				MyBoardDto dto = new MyBoardDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				res.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("error: query 준비/실행/리턴 오류발생");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
				System.out.println("05. db 종료 \n");
			} catch (SQLException e) {
				System.out.println("error: db종료 실패");
				e.printStackTrace();
			}
		}
		return res;
	}
	
	//선택출력
	public MyBoardDto selectOne(int myno) {
		return null;
	}
	
	//추가
	public int insert(MyBoardDto dto) {
		return 0;
	}
	//삭제
	public int delete(int myno) {
		return 0;
	}
}
