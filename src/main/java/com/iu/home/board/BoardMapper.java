package com.iu.home.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.iu.home.util.Pager;

@Mapper
public interface BoardMapper {
	
	public BoardFileVO getFileDetail(BoardFileVO boardFileVO)throws Exception;
	public int setAddFile(BoardFileVO boardFileVO)throws Exception;
	public int setAdd(BoardVO boardVO)throws Exception;
	public BoardVO getDetail(BoardVO boardVO)throws Exception;
	public List<BoardVO> getList(Pager pager)throws Exception;
	public Long getCount(Pager pager)throws Exception;

}
