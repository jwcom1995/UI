package com.answer.dto;

import java.util.Date;

public class AnswerDto {
	private int boardno;
	private int groupno;
	private int groupsq;
	private int titletab;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	
	public AnswerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnswerDto(int boardno, int groupno, int groupsq, int titletab, String title, String content, String writer,
			Date regdate) {
		super();
		this.boardno = boardno;
		this.groupno = groupno;
		this.groupsq = groupsq;
		this.titletab = titletab;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
	}

	public AnswerDto(String writer,String title, String content) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public int getGroupno() {
		return groupno;
	}

	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}

	public int getGroupsq() {
		return groupsq;
	}

	public void setGroupsq(int groupsq) {
		this.groupsq = groupsq;
	}

	public int getTitletab() {
		return titletab;
	}

	public void setTitletab(int titletab) {
		this.titletab = titletab;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
