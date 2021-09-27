package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.login.dto.MyMemberDto;

import common.JDBCTemplate;

public class MyMemberDao extends JDBCTemplate {

	/*
	 * 관리자기능 (ADMIN)
	 * 
	 */

	// 회원전체 조회
	public List<MyMemberDto> selectAll() {
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<MyMemberDto> res = new ArrayList<MyMemberDto>();
		String sql = "SELECT * FROM MYMEMBER";

		try {
			stmt = con.createStatement();
			System.out.println("03. query문 준비 : " + sql);

			rs = stmt.executeQuery(sql);
			System.out.println("04. query문 실행");

			while (rs.next()) {
				MyMemberDto mmd = new MyMemberDto();
				mmd.setMyno(rs.getInt(1));
				mmd.setMyid(rs.getString(2));
				mmd.setMypw(rs.getString(3));
				mmd.setMyname(rs.getString(4));
				mmd.setMyaddr(rs.getString(5));
				mmd.setMyphone(rs.getString(6));
				mmd.setMyemail(rs.getString(7));
				mmd.setMyenabled(rs.getString(8));
				mmd.setMyrole(rs.getString(9));

				res.add(mmd);
			}
		} catch (SQLException e) {
			System.out.println("error : query문 준비/실행 실패");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);
			System.out.println("05. db 종료 \n");
		}

		return res;
	}
	
	// 회원 조회(enabled)
	public List<MyMemberDto> selectEnabled() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MyMemberDto> res = new ArrayList<MyMemberDto>();

		String sql = "SELECT * FROM MYMEMBER WHERE MYENABLED='Y'";

		try {
			pstm = con.prepareStatement(sql);
			System.out.println("03. query 준비 : " + sql);

			rs = pstm.executeQuery();
			System.out.println("04. query 실행");
			while (rs.next()) {
				MyMemberDto mmd = new MyMemberDto();
				mmd.setMyno(rs.getInt(1));
				mmd.setMyid(rs.getString(2));
				mmd.setMypw(rs.getString(3));
				mmd.setMyname(rs.getString(4));
				mmd.setMyaddr(rs.getString(5));
				mmd.setMyphone(rs.getString(6));
				mmd.setMyemail(rs.getString(7));
				mmd.setMyenabled(rs.getString(8));
				mmd.setMyrole(rs.getString(9));

				res.add(mmd);
			}
		} catch (SQLException e) {
			System.out.println("error : query문 준비/실행 실패");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05. db 종료 \n");
		}
		return res;
	}
	
	// 회원 등급 조정
	public int updateRole(int myno, String myrole) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = "UPDATE MYMEMBER SET MYROLE=? WHERE MYNO=?";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, myrole);
			pstm.setInt(2, myno);
			System.out.println("03. query 준비 : "+sql);
			
			res=pstm.executeUpdate();
			System.out.println("04. query 실행");
			if(res>0) {
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
	
	/*
	 * 사용자기능 (USER)
	 * 
	 */

	// 로그인
	public MyMemberDto login(String id, String pw) {

		Connection con = getConnection();

		PreparedStatement pstm = null;
		ResultSet rs = null;
		MyMemberDto res = new MyMemberDto();

		String sql = "SELECT * FROM MYMEMBER WHERE MYID=? AND MYPW=? AND MYENABLED=?";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			pstm.setString(3, "Y");
			System.out.println("03. query 준비 : " + sql);

			rs = pstm.executeQuery();
			System.out.println("04. query 실행");
			if (rs.next()) {
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
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05. db 종료. \n");
		}

		return res;
	}

	// 내 정보 조회
	public MyMemberDto selectUser(int myno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MyMemberDto res = new MyMemberDto();

		String sql = "SELECT * FROM MYMEMBER WHERE MYNO=?";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			System.out.println("03. query 준비 : " + sql);

			rs = pstm.executeQuery();
			System.out.println("04. query 실행");

			while (rs.next()) {
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
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05. db 종료 \n");
		}
		return res;
	}

	
}
