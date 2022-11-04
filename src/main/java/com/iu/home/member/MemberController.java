package com.iu.home.member;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("add")
	public ModelAndView setAdd(ModelAndView mv, @Valid MemberVO memberVO, BindingResult bindingResult)throws Exception{
		if(bindingResult.hasErrors()) {
			mv.setViewName("member/add");
			return mv;
		}
		int result = memberService.setAdd(memberVO);
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@GetMapping("add")
	public String setAdd(@ModelAttribute MemberVO memberVO)throws Exception{
		return "member/add";
	}
	
	@GetMapping("login")
	public String getLogin()throws Exception{
		return "member/login";
	}

}
