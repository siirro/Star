package com.iu.home.board;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.util.FileManager;
import com.iu.home.util.Pager;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private FileManager fileManager;
	@Value("${app.upload.board}")
	private String path;
	
	public BoardFileVO getFileDetail(BoardFileVO boardFileVO)throws Exception{
		return boardMapper.getFileDetail(boardFileVO);
	}
	
	public int setAdd(BoardVO boardVO)throws Exception{
		int result = boardMapper.setAdd(boardVO);
//		File file = new File(path+"qna"); application에 qna안넣었을때는이렇게
		File file = new File(path);
		
		if(!file.exists()) {
			boolean check = file.mkdirs();
		}
		for(MultipartFile f : boardVO.getFiles()) {
			if(!f.isEmpty()) {
				String fileName = fileManager.saveFile(f, path);
				BoardFileVO boardFileVO = new BoardFileVO();
				boardFileVO.setNum(boardVO.getNum());
				boardFileVO.setOriName(f.getOriginalFilename());
				boardFileVO.setFileName(fileName);
				boardMapper.setAddFile(boardFileVO);
			}
		}
		return result;
	}
	
	public BoardVO getDetail(BoardVO boardVO)throws Exception{
		return boardMapper.getDetail(boardVO);
	}
	
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
