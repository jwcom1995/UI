package com.my.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.dto.IconBoardDto;

public class IconBoardDao {
	Connection con = null;
	
	public IconBoardDao() {
		super();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("01. driver 연결");
		} catch (ClassNotFoundException e) {
			System.out.println("error : driver 연결 실패");
			e.printStackTrace();
		}
	}

	public List<IconBoardDto> selectAll(){
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JW","JW");
			System.out.println("02. 계정 연결");
		} catch (SQLException e) {
			System.out.println("error : 계정 연결");
			e.printStackTrace();
		}
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT * FROM ICONBOARD";
		List<IconBoardDto> list = new ArrayList<IconBoardDto>();
		try {
			stmt=con.createStatement();
			System.out.println("03. query 준비 : "+ sql);
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				IconBoardDto dto =new IconBoardDto();
				dto.setI_no(rs.getInt(1));
				dto.setI_img(rs.getString(2));
				dto.setI_name(rs.getString(3));
				dto.setI_designer(rs.getString(4));
				dto.setI_description(rs.getString(5));
				dto.setI_price(rs.getString(6));
				dto.setI_date(rs.getString(7));
				list.add(dto);
			}
			System.out.println("04. query 실행");
		} catch (SQLException e) {
			System.out.println("error : query 준비/실행 실패");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
				System.out.println("05. db 종료");
			} catch (SQLException e) {
				System.out.println("error : db종료 실패");
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public IconBoardDto selectOne(int i_no) {
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JW","JW");
			System.out.println("02. 계정 연결");
		} catch (SQLException e) {
			System.out.println("error : 계정 연결");
			e.printStackTrace();
		}
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		IconBoardDto dto=new IconBoardDto();
		String sql ="SELECT * FROM ICONBOARD WHERE I_NO="+i_no;
		try {
			pstm=con.prepareStatement(sql);
			System.out.println("03. query 준비 : "+ sql);
			
			rs = pstm.executeQuery();			
			
			if(rs.next()) {
			dto.setI_no(rs.getInt(1));
			dto.setI_img(rs.getString(2));
			dto.setI_name(rs.getString(3));
			dto.setI_designer(rs.getString(4));
			dto.setI_description(rs.getString(5));
			dto.setI_price(rs.getString(6));
			dto.setI_date(rs.getString(7));
			}
			System.out.println("04. query 실행");
		} catch (SQLException e) {
			System.out.println("error : query 준비/실행 실패");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstm.close();
				con.close();
				System.out.println("05. db 종료");
			} catch (SQLException e) {
				System.out.println("error : db종료 실패");
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	public int insert() {
		
		
		return 0;
	}

	public int delete() {
		return 0;
	}
	public int update(IconBoardDto dto) {
		
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JW","JW");
			System.out.println("02. 계정 연결");
		} catch (SQLException e) {
			System.out.println("error : 계정 연결");
			e.printStackTrace();
		}
		
		PreparedStatement pstm = null;
		String sql ="UPDATE ICONBOARD "+
					"SET I_NAME = ?, I_DESIGNER = ? , I_DESCRIPT = ?,I_PRICE = ?"
					+" WHERE I_NO=?";
		int res=0;		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, dto.getI_name());
			pstm.setString(2, dto.getI_designer());
			pstm.setString(3, dto.getI_description());
			pstm.setString(4, dto.getI_price());
			pstm.setInt(5, dto.getI_no());
			System.out.println("03. query 준비 : "+ sql);
			
			res=pstm.executeUpdate();			
			System.out.println("04. query 실행");
			
		} catch (SQLException e) {
			System.out.println("error : query 준비/실행 실패");
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
				System.out.println("05. db 종료");
			} catch (SQLException e) {
				System.out.println("error : db종료 실패");
				e.printStackTrace();
			}
		}
		return res;
	}
}
