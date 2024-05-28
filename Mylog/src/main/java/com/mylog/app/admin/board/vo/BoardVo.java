package com.mylog.app.admin.board.vo;

public class BoardVo {
	private String no;
	private String categoryNo;
	private String writerNo;
	private String title;
	private String content;
	private String enrollDate;
	private String secretYn;
	private String modifyDate;
	private String delDate;
	private String nick;
	private String category;
	
	public BoardVo() {
		super();
	}

	public BoardVo(String no, String categoryNo, String writerNo, String title, String content, String enrollDate,
			String secretYn, String modifyDate, String delDate, String nick, String category) {
		super();
		this.no = no;
		this.categoryNo = categoryNo;
		this.writerNo = writerNo;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.secretYn = secretYn;
		this.modifyDate = modifyDate;
		this.delDate = delDate;
		this.nick = nick;
		this.category = category;
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

	public String getWriterNo() {
		return writerNo;
	}

	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
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

	public String getSecretYn() {
		return secretYn;
	}

	public void setSecretYn(String secretYn) {
		this.secretYn = secretYn;
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

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", categoryNo=" + categoryNo + ", writerNo=" + writerNo + ", title=" + title
				+ ", content=" + content + ", enrollDate=" + enrollDate + ", secretYn=" + secretYn + ", modifyDate="
				+ modifyDate + ", delDate=" + delDate + ", nick=" + nick + ", category=" + category + "]";
	}
	
	
	
}
