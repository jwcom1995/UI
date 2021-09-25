package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.login.dto.MyMemberDto;

import common.JDBCTemplate;

public class MyMemberDao extends JDBCTemplate{
	
	/*
	 관리자기능 (ADMIN)
	  
	 */
	
	/*
	 사용자기능 (USER)
	  
	 */
	public MyMemberDto login(String id,String pw) {
		
		Connection con = getConnection();
		
		PreparedStatement pstm =null; 
		ResultSet rs = null;
		MyMemberDto res =new MyMemberDto();
		
		String sql = "SELECT * FROM MYMEMBER WHERE MYID=? AND MYPW=? AND MYENABLED=?";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			pstm.setString(3, "Y");
			System.out.println("03. query 준비 : "+sql);
			
			rs=pstm.executeQuery();
			System.out.println("04. query 실행");
			if(rs.next()) {
				res.setMyno(rs.getInt(1));
				res.setMyid(rs.getString(2));
				res.setMypw(rs.getString(3));
				res.setMyname(rs.getString(4));
				res.setMyaddr(rs.getString(5));
				res.setMyphone(rs.getString(6));
				res.setMyemail(rs.getString(7));
				res.setMyenabled(rs.getString(8));
				res.setMyrole(rs.getString(9));				
			}
		} catch (SQLException e) {
			System.out.println("error : query 준비/실행 실패");
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05. db 종료. \n");
		}
		
		
		return res;
	}
}
