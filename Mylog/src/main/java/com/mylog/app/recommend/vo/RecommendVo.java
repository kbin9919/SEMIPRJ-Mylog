package com.mylog.app.recommend.vo;

public class RecommendVo {

	private String boardNo;
	private String referenceNo;

	public RecommendVo(String boardNo, String referenceNo) {
		super();
		this.boardNo = boardNo;
		this.referenceNo = referenceNo;
	}

	public RecommendVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	@Override
	public String toString() {
		return "RecommendVo [boardNo=" + boardNo + ", referenceNo=" + referenceNo + "]";
	}

}
