package com.iu.home.util;

import lombok.Data;

@Data
public class Pager {
	
	private Long page;
	private Long startNum;
	private Long lastNum;
	private Long startRow;

	private Long perPage=10L;
	private Long perBlock=10L;
	
	private String search;
	private String kind;
	
	private boolean pre;
	private boolean next;
	
	
	
	
	public Long getPage() {
		if(this.page==null||this.page<1) {
			this.page=1L;
		}
		return page;
	}
	public Long getPerPage() {
		if(this.perPage==null) {
			this.perPage=10L;
		}
		return perPage;
	}
	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return search;
	}
	
	public void makeRow() {
		this.startRow = (this.getPage()-1)*perPage;
	}
	
	// 2. 각종 페이지수 계산 메서드 - totalCount는 매퍼에서 getCount생성 후 서비스에서 호출
		public void getNum(Long totalCount)throws Exception{
			//1. 전체글수(totalCount)로 (전체페이지수)totalPage 계산
			Long totalPage = totalCount/this.getPerPage();
			if(totalCount%this.getPerPage()!=0) {
				totalPage +=1;
			}
			
			//cf)1-1. totalPage보다 page가 큰 경우 못가게 막기
			if(this.getPage()>totalPage) {
				this.setPage(totalPage);
			}
			
			//2. totalPage를 이용해 totalBlock(페이지한묶음의 수)
			Long totalBlock = totalPage/this.getPerBlock();
			if(totalPage%this.getPerBlock()!=0) {
				totalBlock +=1;
			}
			//3. page로 현재나의페이지블럭위치(curBlock) 구하기
			Long curBlock = this.getPage()/this.getPerBlock();
			if(this.getPage()%this.getPerBlock()!=0) {
				curBlock +=1;
			}
			
			//4. curBlock으로 페이지의 시작번호랑 끝번호 계산
			this.startNum = (curBlock-1)*this.getPerBlock()+1;
			this.lastNum = curBlock*this.getPerBlock();

			//5. 현재내가있는블럭이 토탈블락의 끝일때 (라스트넘이 전체페이지수보다 많아짐 방지)
			if(curBlock==totalBlock) {
				this.lastNum=totalPage;
			}
			System.out.println("토탈카운트는?"+totalCount);
			System.out.println("토탈페이지는?"+totalPage);
			System.out.println("토탈블럭은?"+totalBlock);

			
			//?? 검색결과가 0개면 라스트넘도 0이 되는 식 (제가 임의로 추가한거라 에러뜨면 사용x)
			if(totalBlock==0) {
				//this.lastNum=totalPage;
				
				this.lastNum=0L;
			}
			
			//6.이전, 다음 블럭의 유무
			if(curBlock>1) {
				pre=true;
			}
			
			if(curBlock<totalBlock) {
				next=true;
			}
		}

}
