package com.mylog.app.admin.member.vo;

public class WarningVo {
	private String no;
	private String warningNo;
	private String memberNo;
	private String enrollDate;
	
	public WarningVo() {
		super();
	}

	public WarningVo(String no, String warningNo, String memberNo, String enrollDate) {
		super();
		this.no = no;
		this.warningNo = warningNo;
		this.memberNo = memberNo;
		this.enrollDate = enrollDate;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getWarningNo() {
		return warningNo;
	}

	public void setWarningNo(String warningNo) {
		this.warningNo = warningNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "WarningVo [no=" + no + ", warningNo=" + warningNo + ", memberNo=" + memberNo + ", enrollDate="
				+ enrollDate + "]";
	}
	
}
