package com.mylog.app.admin.member.vo;

public class AdminVo {
	private String no;
	private String email;
	private String password;
	private String nick;
	private String adminYn;
	private String enrollDate;
	private String delDate;
	private String introduction;
	private String warningPoint;
	
	public AdminVo() {
		super();
	}

	public AdminVo(String no, String email, String password, String nick, String adminYn, String enrollDate,
			String delDate, String introduction, String warningPoint) {
		super();
		this.no = no;
		this.email = email;
		this.password = password;
		this.nick = nick;
		this.adminYn = adminYn;
		this.enrollDate = enrollDate;
		this.delDate = delDate;
		this.introduction = introduction;
		this.warningPoint = warningPoint;
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

	public String getAdminYn() {
		return adminYn;
	}

	public void setAdminYn(String adminYn) {
		this.adminYn = adminYn;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getDelDate() {
		return delDate;
	}

	public void setDelDate(String delDate) {
		this.delDate = delDate;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getWarningPoint() {
		return warningPoint;
	}

	public void setWarningPoint(String warningPoint) {
		this.warningPoint = warningPoint;
	}

	@Override
	public String toString() {
		return "AdminVo [no=" + no + ", email=" + email + ", password=" + password + ", nick=" + nick + ", adminYn="
				+ adminYn + ", enrollDate=" + enrollDate + ", delDate=" + delDate + ", introduction=" + introduction
				+ ", warningPoint=" + warningPoint + "]";
	}

}
