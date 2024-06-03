package com.mylog.app.comment.vo;

public class CommentVo {

	private String no;
	private String boardNo;
	private String writerNo;
	private String content;
	private String enrollDate;
	private String modifyDate;
	private String delDate;
	private String writerNick;

	public CommentVo(String no, String boardNo, String writerNo, String content, String enrollDate, String modifyDate,
			String delDate, String writerNick) {
		super();
		this.no = no;
		this.boardNo = boardNo;
		this.writerNo = writerNo;
		this.content = content;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.delDate = delDate;
		this.writerNick = writerNick;
	}

	public CommentVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public String getWriterNo() {
		return writerNo;
	}

	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
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

	public String getDelDate() {
		return delDate;
	}

	public void setDelDate(String delDate) {
		this.delDate = delDate;
	}

	public String getWriterNick() {
		return writerNick;
	}

	public void setWriterNick(String writerNick) {
		this.writerNick = writerNick;
	}

	@Override
	public String toString() {
		return "CommentVo [no=" + no + ", boardNo=" + boardNo + ", writerNo=" + writerNo + ", content=" + content
				+ ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", delDate=" + delDate + ", writerNick="
				+ writerNick + "]";
	}

}
