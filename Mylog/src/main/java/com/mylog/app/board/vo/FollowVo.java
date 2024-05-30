package com.mylog.app.board.vo;

public class FollowVo {

	private String no;
	private String followerNo;
	private String memberNo;

	public FollowVo(String no, String followerNo, String memberNo) {
		super();
		this.no = no;
		this.followerNo = followerNo;
		this.memberNo = memberNo;
	}

	public FollowVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getFollowerNo() {
		return followerNo;
	}

	public void setFollowerNo(String followerNo) {
		this.followerNo = followerNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "FollowVo [no=" + no + ", followerNo=" + followerNo + ", memberNo=" + memberNo + "]";
	}

}
