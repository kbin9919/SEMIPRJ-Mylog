package com.mylog.app.admin.vo;

public class AdminVo {
	private String no;
	private String email;
	private String password;
	private String nick;
	private String adminYn;
	
	public AdminVo() {
		super();
	}

	public AdminVo(String no, String email, String password, String nick, String adminYn) {
		super();
		this.no = no;
		this.email = email;
		this.password = password;
		this.nick = nick;
		this.adminYn = adminYn;
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

	@Override
	public String toString() {
		return "AdminVo [no=" + no + ", email=" + email + ", password=" + password + ", nick=" + nick + ", adminYn="
				+ adminYn + "]";
	}
	
	
	
	
}
