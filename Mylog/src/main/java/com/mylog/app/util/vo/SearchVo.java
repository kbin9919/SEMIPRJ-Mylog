package com.mylog.app.util.vo;

public class SearchVo {
	private String searchValue;
	private String type;

	public SearchVo() {
		super();
	}

	public SearchVo(String searchValue, String type) {
		super();
		this.searchValue = searchValue;
		this.type = type;
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

	@Override
	public String toString() {
		return "SearchVo [searchValue=" + searchValue + ", type=" + type + "]";
	}

}
