import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
    private final DataSource dataSource;

    public MemberDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // 회원 정보 삽입 메서드
    public void insertMember(MemberVO member) throws SQLException {
        String sql = "INSERT INTO MEMBER (NO, EMAIL, PASSWORD, NICK, ENROLL_DATE, INTRODUCTION, DEL_DATE, ADMIN_YN) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, member.getNo());
            ps.setString(2, member.getEmail());
            ps.setString(3, member.getPassword());
            ps.setString(4, member.getNick());
            ps.setTimestamp(5, member.getEnrollDate());
            ps.setString(6, member.getIntroduction());
            ps.setTimestamp(7, member.getDelDate());
            ps.setString(8, member.getAdminYn());
            ps.executeUpdate();
        }
    }

    // 회원 정보 조회 메서드
    public MemberVO selectMember(int no) throws SQLException {
        String sql = "SELECT * FROM MEMBER WHERE NO = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, no);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    MemberVO member = new MemberVO();
                    member.setNo(rs.getInt("NO"));
                    member.setEmail(rs.getString("EMAIL"));
                    member.setPassword(rs.getString("PASSWORD"));
                    member.setNick(rs.getString("NICK"));
                    member.setEnrollDate(rs.getTimestamp("ENROLL_DATE"));
                    member.setIntroduction(rs.getString("INTRODUCTION"));
                    member.setDelDate(rs.getTimestamp("DEL_DATE"));
                    member.setAdminYn(rs.getString("ADMIN_YN"));
                    return member;
                }
            }
        }
        return null;
    }

    // 모든 회원 정보 조회 메서드
    public List<MemberVO> selectAllMembers() throws SQLException {
        String sql = "SELECT * FROM MEMBER";
        List<MemberVO> memberList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                MemberVO member = new MemberVO();
                member.setNo(rs.getInt("NO"));
                member.setEmail(rs.getString("EMAIL"));
                member.setPassword(rs.getString("PASSWORD"));
                member.setNick(rs.getString("NICK"));
                member.setEnrollDate(rs.getTimestamp("ENROLL_DATE"));
                member.setIntroduction(rs.getString("INTRODUCTION"));
                member.setDelDate(rs.getTimestamp("DEL_DATE"));
                member.setAdminYn(rs.getString("ADMIN_YN"));
                memberList.add(member);
            }
        }
        return memberList;
    }

    // 회원 정보 수정 메서드
    public void updateMember(MemberVO member) throws SQLException {
        String sql = "UPDATE MEMBER SET EMAIL = ?, PASSWORD = ?, NICK = ?, INTRODUCTION = ?, DEL_DATE = ?, ADMIN_YN = ? WHERE NO = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, member.getEmail());
            ps.setString(2, member.getPassword());
            ps.setString(3, member.getNick());
            ps.setString(4, member.getIntroduction());
            ps.setTimestamp(5, member.getDelDate());
            ps.setString(6, member.getAdminYn());
            ps.setInt(7, member.getNo());
            ps.executeUpdate();
        }
    }

    // 회원 정보 삭제 메서드
    public void deleteMember(int no) throws SQLException {
        String sql = "DELETE FROM MEMBER WHERE NO = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, no);
            ps.executeUpdate();
        }
    }
}
