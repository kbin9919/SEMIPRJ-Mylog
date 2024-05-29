package com.mylog.app.admin.faq.vo;

public class FAQVo {
	private String no;
	private String title;
	private String contents;
	private String enrollDate;
	private String modifyDate;
	private String delDate;
	
	public FAQVo() {
		super();
	}

	public FAQVo(String no, String title, String contents, String enrollDate, String modifyDate, String delDate) {
		super();
		this.no = no;
		this.title = title;
		this.contents = contents;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.delDate = delDate;
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

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getDelDate() {
		return delDate;
	}

	public void setDelDate(String delDate) {
		this.delDate = delDate;
	}

	@Override
	public String toString() {
		return "FAQVo [no=" + no + ", title=" + title + ", contents=" + contents + ", enrollDate=" + enrollDate
				+ ", modifyDate=" + modifyDate + ", delDate=" + delDate + "]";
	}
	
}
