package com.mvc.biz;

import java.util.List;

import com.mvc.dto.MyMVCDto;

public interface MyMVCBiz {
	public List<MyMVCDto> selectAll();
	public MyMVCDto selectOne(int seq);
	public boolean insert(MyMVCDto dto);
	public boolean update(MyMVCDto dto);
	public boolean delete(int seq);
}
