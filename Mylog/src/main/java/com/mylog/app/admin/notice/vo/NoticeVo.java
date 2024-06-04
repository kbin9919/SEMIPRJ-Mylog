package com.mylog.app.admin.notice.vo;

public class NoticeVo {
	private String no;
	private String categoryNo;
	private String category;
	private String writerNo;
	private String nick;
	private String title;
	private String content;
	private String enrollDate;
	private String modifyDate;
	private String hits;
	private String png;
	
	public NoticeVo() {
		super();
	}

	public NoticeVo(String no, String categoryNo, String category, String writerNo, String nick, String title,
			String content, String enrollDate, String modifyDate, String hits, String png) {
		super();
		this.no = no;
		this.categoryNo = categoryNo;
		this.category = category;
		this.writerNo = writerNo;
		this.nick = nick;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.hits = hits;
		this.png = png;
	}
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getWriterNo() {
		return writerNo;
	}

	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getHits() {
		return hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}

	public String getPng() {
		return png;
	}

	public void setPng(String png) {
		this.png = png;
	}

	@Override
	public String toString() {
		return "NoticeVo [no=" + no + ", categoryNo=" + categoryNo + ", category=" + category + ", writerNo=" + writerNo
				+ ", nick=" + nick + ", title=" + title + ", content=" + content + ", enrollDate=" + enrollDate
				+ ", modifyDate=" + modifyDate + ", hits=" + hits + ", png=" + png + "]";
	}

	

}
