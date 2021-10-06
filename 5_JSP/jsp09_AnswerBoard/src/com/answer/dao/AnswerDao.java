package com.answer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.answer.dto.AnswerDto;

import common.JDBCTemplate;

public class AnswerDao extends JDBCTemplate{
	
	public List<AnswerDto> selectAll(){
		Connection con = getConnection();
		PreparedStatement pstm= null;
		ResultSet rs = null;
		List<AnswerDto> list = new ArrayList<AnswerDto>();
		
		String sql = "SELECT * FROM ANSWERBOARD ORDER BY GROUPNO DESC, GROUPSQ";
		
		try {
			pstm=con.prepareStatement(sql);
			System.out.println("03. query 준비 : "+sql);
			
			rs=pstm.executeQuery();
			System.out.println("04. query 실행");
			
			while(rs.next()) {
				AnswerDto tmp = new AnswerDto(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),
						rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8));
				list.add(tmp);
			}
			
		} catch (SQLException e) {
			System.out.println("error: query 준비/실행 failed");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05. db 종료 \n");
		}
		
		return list;
	}
	
	public AnswerDto selectOne(int boardno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		AnswerDto dto = null;
		
		String sql = "SELECT * FROM ANSWERBOARD WHERE BOARDNO=?";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, boardno);
			System.out.println("03. query 준비 : "+sql);
			
			rs=pstm.executeQuery();
			System.out.println("04. query 실행");
			if(rs.next()) {
				dto = new AnswerDto(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),
						rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8));
			}
		} catch (SQLException e) {
			System.out.println("error: query 준비/실행 failed");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05. db 종료 \n");
		}
		
		return dto;
	}
	
	public int insert(AnswerDto dto) {
		return 0;
	}
	
	public int update(AnswerDto dto) {
		return 0;
	}
	
	public int delete(int boardno) {
		return 0;
	}
}
