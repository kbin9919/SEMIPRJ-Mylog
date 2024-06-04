package com.mylog.app.util.vo;

public class PageVo {
	private String startNo; 
	private String endNo;
	
	public PageVo() {
		super();
	}

	public PageVo(String startNo, String endNo) {
		super();
		this.startNo = startNo;
		this.endNo = endNo;
	}

	public String getStartNo() {
		return startNo;
	}

	public void setStartNo(String startNo) {
		this.startNo = startNo;
	}

	public String getEndNo() {
		return endNo;
	}

	public void setEndNo(String endNo) {
		this.endNo = endNo;
	}
	
	@Override
	public String toString() {
		return "PageVo [startNo=" + startNo + ", endNo=" + endNo + "]";
	} 
	
}
