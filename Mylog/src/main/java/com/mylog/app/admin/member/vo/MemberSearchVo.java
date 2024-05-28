package com.mylog.app.admin.member.vo;

public class MemberSearchVo {
	private String searchValue;
	private String type;

	public MemberSearchVo() {
		super();
	}

	public MemberSearchVo(String searchValue, String type) {
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
		return "MemberSearchVo [searchValue=" + searchValue + ", type=" + type + "]";
	}
}
