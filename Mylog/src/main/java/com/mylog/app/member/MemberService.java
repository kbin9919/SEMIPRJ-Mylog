package com.mylog.app.member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberService {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mylogdb";
        String username = "root";
        String password = "password";
        return DriverManager.getConnection(url, username, password);
    }

    public List<MemberVO> getAllMembers() throws SQLException {
        List<MemberVO> member = new ArrayList<>();
        String query = "SELECT * FROM member";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                MemberVO members = new MemberVO();
                members.setNo(rs.getInt("no"));
                members.setEmail(rs.getString("email"));
            }
        }
        return member;
    }

    public void addMember(MemberVO member) throws SQLException {
        String query = "INSERT INTO member (email) VALUES (?)";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, member.getEmail());
            pstmt.executeUpdate();
        }
    }

    public MemberVO getMember(int no) throws SQLException {
        String query = "SELECT * FROM member WHERE no = ?";
        MemberVO member = null;
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, no);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    member = new MemberVO();
                    member.setNo(rs.getInt("no"));
                    member.setEmail(rs.getString("email"));
                }
            }
        }
        return member;
    }

    public void updateMember(MemberVO member) throws SQLException {
        String query = "UPDATE member SET email = ? WHERE no = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, member.getEmail());
            pstmt.setInt(2, member.getNo());
            pstmt.executeUpdate();
        }
    }

    public void deleteMember(int no) throws SQLException {
        String query = "DELETE FROM member WHERE no = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, no);
            pstmt.executeUpdate();
        }
    }
}