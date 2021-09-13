package com.my.dto;

public class IconBoardDto {
	private int i_no;
	private String i_img;
	private String i_name;
	private String i_designer;
	private String i_description;
	private String i_price;
	private String i_date;
	
	public IconBoardDto() {
		super();
	}
	
	public IconBoardDto(int i_no, String i_img, String i_name, String i_designer, String i_description,String i_price, String i_date) {
		super();
		this.i_no = i_no;
		this.i_img = i_img;
		this.i_name = i_name;
		this.i_designer = i_designer;
		this.i_description = i_description;
		this.i_price = i_price;
		this.i_date = i_date;
	}
	
	public String getI_price() {
		return i_price;
	}

	public void setI_price(String i_price) {
		this.i_price = i_price;
	}

	public String getI_designer() {
		return i_designer;
	}

	public void setI_designer(String i_designer) {
		this.i_designer = i_designer;
	}

	public int getI_no() {
		return i_no;
	}
	public void setI_no(int i_no) {
		this.i_no = i_no;
	}
	public String getI_img() {
		return i_img;
	}
	public void setI_img(String i_img) {
		this.i_img = i_img;
	}
	public String getI_name() {
		return i_name;
	}
	public void setI_name(String i_name) {
		this.i_name = i_name;
	}
	public String getI_description() {
		return i_description;
	}
	public void setI_description(String i_description) {
		this.i_description = i_description;
	}
	public String getI_date() {
		return i_date;
	}
	public void setI_date(String i_date) {
		this.i_date = i_date;
	}
	
	
}
