package com.jhj.util;

public class Pager {
	private int curPage;
	private int perPage;
	private int totalPage;

	private int startRow;
	private int lastRow;

	private String kind;
	private String search;

	private int startNum;
	private int lastNum;
	private int curBlock;
	private int perBlock;
	private int totalBlock;

	
	public int getCurPage() {
		if (curPage == 0) {
			curPage = 1;
		}
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPerPage() {
		if (perPage == 0) {
			perPage = 10;
		}
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getLastRow() {
		return lastRow;
	}

	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}

	public String getKind() {
		if (kind == null || kind == "") {
			kind = "title";
		}
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if (search == null) {
			search = "";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getLastNum() {
		return lastNum;
	}

	public void setLastNum(int lastNum) {
		this.lastNum = lastNum;
	}

	public int getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}

	public int getPerBlock() {
		if (perBlock == 0) {
			perBlock = 5;
		}
		return perBlock;
	}

	public void setPerBlock(int perBlock) {
		this.perBlock = perBlock;
	}

	public int getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}

	public void makeRow() {
		this.startRow = (getCurPage() - 1) * getPerPage() + 1;
		this.lastRow = getCurPage() * getPerPage();
	}

	public void makePage(int totalCount) {
		this.totalPage = totalCount / getPerPage();
		if (totalCount % perPage != 0) {
			this.totalPage++;
		}
		this.totalBlock = this.totalPage / getPerBlock();
		if (this.totalPage % this.perBlock != 0) {
			this.totalBlock++;
		}
		this.curBlock = this.curPage / this.perBlock;
		if (this.curPage % this.perBlock != 0) {
			this.curBlock++;
		}
		this.startNum = (this.curBlock - 1) * this.perBlock + 1;
		this.lastNum = this.curBlock * this.perBlock;

		if (this.curBlock == this.totalBlock) {
			this.lastNum = this.totalPage;
		}
	}

}
