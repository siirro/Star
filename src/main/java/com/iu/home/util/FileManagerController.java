package com.iu.home.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.BoardFileVO;
import com.iu.home.board.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileManagerController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/fileDown/{path}")
	public ModelAndView fileDown(@PathVariable String path, BoardFileVO boardFileVO)throws Exception{
		log.info("Path : {}", path);

		ModelAndView mv = new ModelAndView();
		
		if(path.equals("board")) {
			boardFileVO = boardService.getFileDetail(boardFileVO);
		} 
		
		mv.addObject("fileVO", boardFileVO);
		mv.addObject("path", path);
		mv.setViewName("fileManager");
		
		return mv;
	}

}
