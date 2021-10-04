package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.dto.MyMVCDto;

import static common.JDBCTemplate.*;

public class MyMVCDaoImpl implements MyMVCDao{

	@Override
	public List<MyMVCDto> selectAll(Connection con) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MyMVCDto> res = new ArrayList<MyMVCDto>();
		
		try {
			pstm =con.prepareStatement(selectAllSql);
			System.out.println("03. query 준비 : "+selectAllSql);
			
			rs=pstm.executeQuery();
			System.out.println("04. query 실행");
			
			while(rs.next()) {
				MyMVCDto tmp = new MyMVCDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5));
				res.add(tmp);
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

	@Override
	public MyMVCDto selectOne(Connection con, int seq) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MyMVCDto res= null;
		
		try {
			pstm=con.prepareStatement(selectOneSql);
			pstm.setInt(1, seq);
			System.out.println("03. query 준비 : "+selectOneSql);
			
			rs=pstm.executeQuery();
			System.out.println("04. query 실행");
			if(rs.next()) {
				res = new MyMVCDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5));
			}
		} catch (SQLException e) {
			System.out.println("error : query 준비/실행 failed");
			e.printStackTrace();
		} finally{
			close(rs);
			close(pstm);
		}
		
		return res;
	}

	@Override
	public boolean insert(Connection con, MyMVCDto dto) {
		PreparedStatement pstm = null;
		int res=0;
		
		try {
			pstm=con.prepareStatement(insertSql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());			
			System.out.println("03. query 준비 : "+insertSql);
			
			res=pstm.executeUpdate();
			System.out.println("04. query 실패");

		} catch (SQLException e) {
			System.out.println("error : query 준비/실행 failed");
			e.printStackTrace();
		} finally {
			close(pstm);
		}
		return (res>0)?true:false;
	}

	@Override
	public boolean update(Connection con, MyMVCDto dto) {
		PreparedStatement pstm = null;
		int res= 0;
		
		try {
			pstm=con.prepareStatement(updateSql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			System.out.println("03. query 준비 : "+ updateSql);
			
			res=pstm.executeUpdate();
			System.out.println("04. query 실행");
		} catch (SQLException e) {
			System.out.println("error : query 준비/실행 failed");
			e.printStackTrace();
		} finally {
			close(pstm);
		}
		return (res>0)?true:false;
	}

	@Override
	public boolean delete(Connection con, int seq) {
		PreparedStatement pstm = null;
		int res= 0;
		
		try {
			pstm=con.prepareStatement(deleteSql);
			pstm.setInt(1, seq);
			System.out.println("03. query 준비 : "+deleteSql);
			
			res=pstm.executeUpdate();
			System.out.println("04. query 실행");
			
		} catch (SQLException e) {
			System.out.println("error : qeury 준비/실행 failed");
			e.printStackTrace();
		} finally {
			close(pstm);
		}
		return (res>0)?true:false;
	}
	
}
