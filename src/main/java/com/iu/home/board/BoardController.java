package com.iu.home.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.util.Pager;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("add")
	public ModelAndView setAdd(ModelAndView mv, BoardVO boardVO)throws Exception{
		int result = boardService.setAdd(boardVO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@GetMapping("add")
	public String setAdd(@ModelAttribute BoardVO boardVO)throws Exception{
		return "board/add";
	}
	
	@GetMapping("detail")
	public ModelAndView getDetail(BoardVO boardVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = boardService.getDetail(boardVO);
		mv.addObject("detail", boardVO);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardVO> ar = boardService.getList(pager);
		mv.addObject("list", ar);
		System.out.println(ar.size());
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		return mv;
	}

}
