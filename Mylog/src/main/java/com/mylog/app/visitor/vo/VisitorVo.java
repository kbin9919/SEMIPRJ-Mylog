package com.mylog.app.visitor.vo;

public class VisitorVo {

	private String boardNo;
	private String visitorNum;

	public VisitorVo(String boardNo, String visitorNum) {
		super();
		this.boardNo = boardNo;
		this.visitorNum = visitorNum;
	}

	public VisitorVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public String getVisitorNum() {
		return visitorNum;
	}

	public void setVisitorNum(String visitorNum) {
		this.visitorNum = visitorNum;
	}

	@Override
	public String toString() {
		return "VisitorVo [boardNo=" + boardNo + ", visitorNum=" + visitorNum + "]";
	}

}
