package com.mylog.app.board.vo;

public class MemberVo {

	private String no;
	private String email;
	private String password;
	private String nick;
	private String enrollDate;
	private String introduction;
	private String delDate;
	private String adminYn;

	public MemberVo(String no, String email, String password, String nick, String enrollDate, String introduction,
			String delDate, String adminYn) {
		super();
		this.no = no;
		this.email = email;
		this.password = password;
		this.nick = nick;
		this.enrollDate = enrollDate;
		this.introduction = introduction;
		this.delDate = delDate;
		this.adminYn = adminYn;
	}

	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getDelDate() {
		return delDate;
	}

	public void setDelDate(String delDate) {
		this.delDate = delDate;
	}

	public String getAdminYn() {
		return adminYn;
	}

	public void setAdminYn(String adminYn) {
		this.adminYn = adminYn;
	}

	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", email=" + email + ", password=" + password + ", nick=" + nick + ", enrollDate="
				+ enrollDate + ", introduction=" + introduction + ", delDate=" + delDate + ", adminYn=" + adminYn + "]";
	}

}
