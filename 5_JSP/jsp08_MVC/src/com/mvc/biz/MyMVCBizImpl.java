package com.mvc.biz;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.mvc.dao.MyMVCDao;
import com.mvc.dao.MyMVCDaoImpl;
import com.mvc.dto.MyMVCDto;

public class MyMVCBizImpl implements MyMVCBiz {

	private MyMVCDao dao = new MyMVCDaoImpl();
	
	@Override
	public List<MyMVCDto> selectAll() {
		Connection con = getConnection();
		
		List<MyMVCDto> res =dao.selectAll(con);
		close(con);
		System.out.println("05. db 종료\n");
		
		return res;
	}

	@Override
	public MyMVCDto selectOne(int seq) {
		Connection con = getConnection();
		
		MyMVCDto res = dao.selectOne(con, seq);
		close(con);
		System.out.println("05. db 종료 \n");
		
		return res;
	}

	@Override
	public boolean insert(MyMVCDto dto) {
		return false;
	}

	@Override
	public boolean update(MyMVCDto dto) {
		return false;
	}

	@Override
	public boolean delete(int seq) {
		return false;
	}

}
