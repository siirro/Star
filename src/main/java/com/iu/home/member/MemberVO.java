package com.iu.home.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class MemberVO implements UserDetails{
	
	@NotBlank(message = "ID 입력은 필수입니다.")
	private String id;
	@NotBlank(message = "비밀번호 입력은 필수입니다.")
	private String pw;
	private String pwCheck;
	@NotBlank(message = "이름 입력은 필수입니다.")
	private String name;
	@NotBlank(message = "이메일 입력은 필수입니다.")
	@Email
	private String email;
	private boolean enable;
	
	private List<RoleVO> roleVOs;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(RoleVO roleVO : roleVOs) {
			authorities.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
		}
		return authorities;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.getPw();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
