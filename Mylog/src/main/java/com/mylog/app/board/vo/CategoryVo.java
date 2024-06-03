package com.mylog.app.board.vo;

public class CategoryVo {

	private String no;
	private String title;

	public CategoryVo(String no, String title) {
		super();
		this.no = no;
		this.title = title;
	}

	public CategoryVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", title=" + title + "]";
	}

}
