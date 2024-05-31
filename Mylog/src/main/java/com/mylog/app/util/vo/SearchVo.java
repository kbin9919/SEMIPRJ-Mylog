package com.mylog.app.util.vo;

public class SearchVo {
	private String searchValue;
	private String type;
	private String categoryNo;
	private String startNo; 
	private String endNo;
	
	public SearchVo() {
		super();
	}

	public SearchVo(String searchValue, String type, String categoryNo, String startNo, String endNo) {
		super();
		this.searchValue = searchValue;
		this.type = type;
		this.categoryNo = categoryNo;
		this.startNo = startNo;
		this.endNo = endNo;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
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
		return "SearchVo [searchValue=" + searchValue + ", type=" + type + ", categoryNo=" + categoryNo + ", startNo="
				+ startNo + ", endNo=" + endNo + "]";
	}

}
