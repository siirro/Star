package com.iu.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public int setAdd(MemberVO memberVO)throws Exception{
		memberVO.setPw(passwordEncoder.encode(memberVO.getPw()));
		int result = memberMapper.setAdd(memberVO);
		return result;
	}

}
