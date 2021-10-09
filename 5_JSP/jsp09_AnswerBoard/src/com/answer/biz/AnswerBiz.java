package com.answer.biz;

import java.sql.Connection;

import com.answer.dao.AnswerDao;
import com.answer.dto.AnswerDto;

import common.JDBCTemplate;

public class AnswerBiz extends JDBCTemplate {
	private AnswerDao dao = new AnswerDao();
	
	public boolean answerLogic(AnswerDto dto) {
		Connection con = getConnection();
		
		int parentgroupno = dto.getGroupno();
		int parentgroupsq = dto.getGroupsq();
		//update
		int countRes = dao.countAnswer(con,parentgroupno,parentgroupsq);
		int updateRes = dao.updateAnswer(con,parentgroupno,parentgroupsq);
		
		//insert
		int insertRes=dao.insertAnswer(con,dto);
		
		if(countRes == updateRes && insertRes>0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		System.out.println("05. db 종료 \n");
		
		return (countRes == updateRes && insertRes>0)?true:false;
	}
}
