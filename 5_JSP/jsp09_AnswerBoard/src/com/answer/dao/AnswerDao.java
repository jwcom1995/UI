package com.answer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.tools.DocumentationTool;

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
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = "INSERT INTO ANSWERBOARD "
				+ "VALUES(BOARDNOSQ.NEXTVAL,GROUPNOSQ.NEXTVAL,1,0,?,?,?,SYSDATE)";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setString(3, dto.getWriter());
			System.out.println("03. query 준비 : "+sql);
			
			res=pstm.executeUpdate();
			System.out.println("04. query 실행");
			
			if(res>0) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			System.out.println("error: query 준비/실행 failed");
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("05. db종료 \n");
		}
		return res;
	}
	
	public int update(AnswerDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res=0;
		
		String sql = "UPDATE ANSWERBOARD SET TITLE=?,CONTENT=? WHERE BOARDNO=?";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getBoardno());
			System.out.println("03. query 준비 : "+sql);
			
			res=pstm.executeUpdate();
			System.out.println("04. query 실행");
			
			if(res>0) {
				commit(con);
			}else {
				rollback(con);
			}
			
		} catch (SQLException e) {
			System.out.println("error: query 준비/실행 failed");
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("05. db 종료 \n");
		}
		
		return res;
	}
	
	public int delete(int boardno) {
		Connection con = getConnection();
		PreparedStatement pstm =null;
		int res=0;
		
		String sql = "DELETE FROM ANSWERBOARD WHERE BOARDNO=?";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, boardno);
			System.out.println("03. query 준비 : "+sql);
			
			res=pstm.executeUpdate();
			System.out.println("04. query 실행");
			
			if(res>0) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			System.out.println("error: query 준비/실행 failed");
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("05. db종료 \n");
		}
		
		return res;
	}

	public int countAnswer(Connection con, int parentgroupno, int parentgroupsq) {
		PreparedStatement pstm=null;
		ResultSet rs = null;
		int res = 0;
		
		String sql ="SELECT COUNT(*) FROM ANSWERBOARD WHERE GROUPNO=? AND GROUPSQ>?";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, parentgroupno);
			pstm.setInt(2, parentgroupsq);
			System.out.println("03. query 준비 : "+ sql);
			
			rs=pstm.executeQuery();
			System.out.println("04. query 실행");
			
			while(rs.next()) {
				res=rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("error : query 준비/실행 failed");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
		}
		return res;
	}

	public int updateAnswer(Connection con, int parentgroupno, int parentgroupsq) {
		PreparedStatement pstm=null;
		int res=0;
		
		String sql = "UPDATE ANSWERBOARD SET GROUPSQ = GROUPSQ+1"
				+ " WHERE GROUPNO=? AND GROUPSQ>?";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, parentgroupno);
			pstm.setInt(2, parentgroupsq);
			System.out.println("03. query 준비 : "+sql);
			
			res = pstm.executeUpdate();
			System.out.println("04. query 실행");
			
		} catch (SQLException e) {
			System.out.println("error: query 준비/실행 failed");
			e.printStackTrace();
		} finally {
			close(pstm);
		}
		return res;
	}

	public int insertAnswer(Connection con, AnswerDto dto) {
		PreparedStatement pstm = null;
		int res=0;
		
		String sql ="INSERT INTO ANSWERBOARD VALUES(BOARDNOSQ.NEXTVAL,?,?,?,?,?,?,SYSDATE)";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, dto.getGroupno());
			pstm.setInt(2, dto.getGroupsq()+1);
			pstm.setInt(3, dto.getTitletab()+1);
			pstm.setString(4,dto.getTitle());
			pstm.setString(5,dto.getContent());
			pstm.setString(6,dto.getWriter());
			System.out.println("03. query 준비 : "+sql);
			
			res=pstm.executeUpdate();
			System.out.println("04. query 실행");
			
		} catch (SQLException e) {
			System.out.println("error : query 준비/실행 failed");
			e.printStackTrace();
		} finally {
			close(pstm);
		}
		
		return res;
	}
}
