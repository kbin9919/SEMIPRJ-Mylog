package com.mylog.app.admin.board.vo;

public class BoardSearchVo {
	private String searchValue;
	private String type;
	
	public BoardSearchVo() {
		super();
	}
	
	public BoardSearchVo(String searchValue, String type) {
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
		return "BoardSearchVo [searchValue=" + searchValue + ", type=" + type + "]";
	}
}
