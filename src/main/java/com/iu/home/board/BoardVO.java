package com.iu.home.board;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardVO {
	
	private Long num;
	@NotBlank(message="BACK : 제목을 입력해주세요")
	private String title;
//	@NotBlank(message="BACK : 작성자를 입력해주세요")
	private String writer;
	@NotBlank(message="BACK : 내용을 입력해주세요")
	private String contents;
	private Long hit;
	private Date regDate;
	private List<BoardFileVO> boardFileVOs;
	
	private MultipartFile [] files;

}
