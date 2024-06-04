public class MemberVO {
    private int no;
    private String email;
    private String password;
    private String nick;
    private Timestamp enrollDate;
    private String introduction;
    private Timestamp delDate;
    private String adminYn;

    // Getters and Setters
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
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
    public Timestamp getEnrollDate() {
        return enrollDate;
    }
    public void setEnrollDate(Timestamp enrollDate) {
        this.enrollDate = enrollDate;
    }
    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public Timestamp getDelDate() {
        return delDate;
    }
    public void setDelDate(Timestamp delDate) {
        this.delDate = delDate;
    }
    public String getAdminYn() {
        return adminYn;
    }
    public void setAdminYn(String adminYn) {
        this.adminYn = adminYn;
    }
}
