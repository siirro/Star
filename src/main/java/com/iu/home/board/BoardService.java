package com.iu.home.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.home.util.Pager;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public List<BoardVO> getList(Pager pager)throws Exception{
		Long totalCount = boardMapper.getCount(pager);
		pager.makeRow();
		pager.getNum(totalCount);
		System.out.println("스타트넘은?"+pager.getStartNum());
		System.out.println("라스트넘은?"+pager.getLastNum());
		List<BoardVO> ar = boardMapper.getList(pager);
		return ar;
	}

}
