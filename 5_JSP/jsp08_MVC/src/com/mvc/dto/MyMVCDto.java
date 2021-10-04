package com.mvc.dto;

import java.util.Date;

public class MyMVCDto {
	
	private int seq;
	private String writer;
	private String title;
	private String content;
	private Date regdate;
	
	//생성자
	public MyMVCDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyMVCDto(int seq, String writer, String title, String content, Date regdate) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}
	
	public MyMVCDto(String writer,String title,String content) {
		super();
		this.writer=writer;
		this.title=title;
		this.content=content;
	}
	
	public MyMVCDto(int seq, String title, String content) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
	}
	//getter&setter
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
		
}
