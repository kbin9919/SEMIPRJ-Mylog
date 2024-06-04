package com.mylog.app.admin.qna.vo;

public class QNAVo {
	private String no;
	private String nick;
	private String adminNick;
	private String writerNo;
	private String title;
	private String content;
	private String createdDate;
	private String secretYn;
	private String adminNo;
	private String answerTitle;
	private String answerContent;
	private String answerDate;
	private String delDate;
	
	public QNAVo() {
		super();
	}

	public QNAVo(String no, String nick, String adminNick, String writerNo, String title, String content,
			String createdDate, String secretYn, String adminNo, String answerTitle, String answerContent,
			String answerDate, String delDate) {
		super();
		this.no = no;
		this.nick = nick;
		this.adminNick = adminNick;
		this.writerNo = writerNo;
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
		this.secretYn = secretYn;
		this.adminNo = adminNo;
		this.answerTitle = answerTitle;
		this.answerContent = answerContent;
		this.answerDate = answerDate;
		this.delDate = delDate;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getAdminNick() {
		return adminNick;
	}

	public void setAdminNick(String adminNick) {
		this.adminNick = adminNick;
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

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getSecretYn() {
		return secretYn;
	}

	public void setSecretYn(String secretYn) {
		this.secretYn = secretYn;
	}

	public String getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}

	public String getAnswerTitle() {
		return answerTitle;
	}

	public void setAnswerTitle(String answerTitle) {
		this.answerTitle = answerTitle;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public String getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}

	public String getDelDate() {
		return delDate;
	}

	public void setDelDate(String delDate) {
		this.delDate = delDate;
	}

	@Override
	public String toString() {
		return "QNAVo [no=" + no + ", nick=" + nick + ", adminNick=" + adminNick + ", writerNo=" + writerNo + ", title="
				+ title + ", content=" + content + ", createdDate=" + createdDate + ", secretYn=" + secretYn
				+ ", adminNo=" + adminNo + ", answerTitle=" + answerTitle + ", answerContent=" + answerContent
				+ ", answerDate=" + answerDate + ", delDate=" + delDate + "]";
	}

}
