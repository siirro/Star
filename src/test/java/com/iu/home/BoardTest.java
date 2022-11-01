package com.iu.home;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.iu.home.board.BoardMapper;
import com.iu.home.board.BoardVO;
@SpringBootTest
public class BoardTest {
	
		@Autowired
		private BoardMapper boardMapper;
		
		@Test
		void addQna()throws Exception{
			BoardVO boardVO = new BoardVO();
			
			for(int i=0; i<101; i++) {
				boardVO.setTitle("제목"+i);
				boardVO.setWriter("작성자"+i);
				boardVO.setContents("내용"+i);
				int result = boardMapper.setAdd(boardVO);
			}
			
			
			
			assertEquals(1, 1);
		}

	


}
