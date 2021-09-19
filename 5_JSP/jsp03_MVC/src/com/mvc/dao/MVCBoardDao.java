package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.dto.MVCBoardDto;
import static common.JDBCTemplate.*;

public class MVCBoardDao {

	public List<MVCBoardDto> selectAll(){
		
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs =null;
		List<MVCBoardDto> list = new ArrayList<MVCBoardDto>();
		
		String sql = "SELECT * FROM MVCBOARD";
		try {
			stmt=con.createStatement();
			System.out.println("03. query 준비 : "+ sql);
			
			rs=stmt.executeQuery(sql);
			System.out.println("04. query 실행");
			
			while(rs.next()) {
				MVCBoardDto dto = new MVCBoardDto();
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("error : query 준비/실행 실패");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);
			System.out.println("05. db 종료");
		}
		return list;
	}
	
	public MVCBoardDto selectOne(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs =null;
		MVCBoardDto res = new MVCBoardDto();
		
		String sql ="SELECT * FROM MVCBOARD WHERE SEQ = ?";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, seq);
			System.out.println("03. query 준비 : "+sql);
			
			rs=pstm.executeQuery();
			System.out.println("04. query 실행");
			
			if(rs.next()) {
				res.setSeq(rs.getInt(1));
				res.setWriter(rs.getString(2));
				res.setTitle(rs.getString(3));
				res.setContent(rs.getString(4));
				res.setRegdate(rs.getDate(5));
			}
		} catch (SQLException e) {
			System.out.println("error : query 준비/실행 실패");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05. db 종료 \n");
		}
		return res;
	}
	
	public int insert(MVCBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res=0;
		
		String sql = "INSERT INTO MVCBOARD VALUES(MVCBOARDSEQ.NEXTVAL,?,?,?,SYSDATE)";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			System.out.println("03. query 준비 : "+sql);
			
			res=pstm.executeUpdate();
			System.out.println("04. query 실행 : "+sql);
			
			if(res>0) {
				commit(con);
			}
		} catch (SQLException e) {
			System.out.println("error : query 준비/실행 실패");
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("05. db종료 \n");
		}
		
		return res;
	}
	public int update(MVCBoardDto dto) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = "UPDATE MVCBOARD SET TITLE=?, CONTENT=? WHERE SEQ=?";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			System.out.println("03. query 준비 : "+ sql);
			
			res=pstm.executeUpdate();
			System.out.println("04. query 실행");
			
			if(res>0) {
				commit(con);
			}
		} catch (SQLException e) {
			System.out.println("error : query 준비/실행 실패");
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("05. db 종료 \n");
		}
		
		return res;
	}
//	public int delete(int seq) {		
//		return 0;
//	}
	
	public int multiDelete(String[] seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		int cnt[];
		
		String sql = "DELETE FROM MVCBOARD WHERE SEQ=?";
		
		try {
			pstm = con.prepareStatement(sql);
			for(int i = 0 ; i<seq.length;i++) {
				pstm.setString(1, seq[i]);
				System.out.println("03. query 준비 : "+sql+"(삭제할 게시글 번호 : "+seq[i]+")");
				pstm.addBatch();				
			}
			
			cnt = pstm.executeBatch();
			
			System.out.println("04. query 실행");
			

			for(int i : cnt) {
				if(i==-2) {
					res++;
				}
			}
			
			if(res==seq.length) {
				commit(con);
			} else {
				rollback(con);
			}
		} catch (SQLException e) {
			System.out.println("error : query 준비/실행 실패");
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("05. db 종료 \n");
		}
		
		return res;
	}
}
