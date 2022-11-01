package com.iu.home.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.home.board.BoardFileVO;

@Component
public class FileManager extends AbstractView{
	
	@Value("${app.download.base}")
	private String base;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BoardFileVO boardFileVO = (BoardFileVO)model.get("fileVO");
		String path = (String)model.get("path");
		
		File file = new File(base+path, boardFileVO.getFileName());
		response.setCharacterEncoding("UTF-8");
		response.setContentLengthLong(file.length());
		String oriName = URLEncoder.encode(boardFileVO.getOriName(), "UTF-8");
		
		response.setHeader("Content-Disposition", "attachment;filename=\""+oriName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		FileInputStream fi = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		FileCopyUtils.copy(fi, os);
		
		os.close();
		fi.close();
		
	}
	
	public String saveFile(MultipartFile multipartFile, String path)throws Exception{
		String fileName = UUID.randomUUID().toString();
		
		StringBuffer bf = new StringBuffer();
		bf.append(fileName);
		bf.append("_");
		bf.append(multipartFile.getOriginalFilename());
		
		fileName = bf.toString();
		
		File file = new File(path, bf.toString());
		
		multipartFile.transferTo(file);
		return fileName;
	}

}
