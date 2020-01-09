package com.iu.b1.util;

import org.springframework.stereotype.Component;

@Component
public class Pager {
	
	private Integer curPage;
	private Integer perPage;
	private String kind; //검색종류
	private String search; //검색어
	private Integer startRow;//시작 rownum
	//View(jsp)
	
	private Integer startNum; //시작 번호
	private Integer lastNum; //끝 번호
	private Integer curBlock; //현재 블럭 번호
	private Integer totalBlock; //전체 블럭 갯수
	
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		if(search == null) {
			search="";
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getStartNum() {
		return startNum;
	}
	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}
	public Integer getLastNum() {
		return lastNum;
	}
	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}
	public Integer getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(Integer curBlock) {
		this.curBlock = curBlock;
	}
	public Integer getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(Integer totalBlock) {
		this.totalBlock = totalBlock;
	}
	public Integer getCurPage() {
		if(curPage == null || curPage==0)
			curPage=1;
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getPerPage() {
		if(perPage == null || perPage ==0)
			perPage=10;
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	
	public void makeRow() {
		this.startRow = (this.getCurPage()-1)*this.getPerPage();
	}
	
	public void makePage(int totalCount) {
		
		int totalPage = totalCount / this.getPerPage();
		if(totalCount%this.getPerPage() !=0)
			totalPage++;
		
		int perBlock = 5;
		totalBlock = totalPage / perBlock;
		if(totalPage%perBlock !=0)
			totalBlock++;
		
		curBlock = this.getCurPage() / perBlock;
		if(this.getCurPage() % perBlock !=0)
			curBlock++;
		
		startNum = (curBlock-1)*perBlock+1;
		lastNum = curBlock*perBlock;
		
		if(curBlock == totalBlock)
			lastNum = totalPage;
		
	}
}
