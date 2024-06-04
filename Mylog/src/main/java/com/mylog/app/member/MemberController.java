package com.mylog.app.member;

import java.sql.SQLException;
import java.util.List;

public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    public void getAllMembers() {
        try {
            List<MemberVO> members = memberService.getAllMembers();
            // 멤버 리스트를 어떻게 처리할지 구현
        } catch (SQLException e) {
            e.printStackTrace();
            // 예외 처리
        }
    }

    public void addMember(MemberVO member) {
        try {
            memberService.addMember(member);
            // 추가 성공 시 처리
        } catch (SQLException e) {
            e.printStackTrace();
            // 예외 처리
        }
    }

    public void getMember(int no) {
        try {
            MemberVO member = memberService.getMember(no);
            // 멤버를 어떻게 처리할지 구현
        } catch (SQLException e) {
            e.printStackTrace();
            // 예외 처리
        }
    }

    public void updateMember(int no, MemberVO member) {
        try {
            member.setNo(no);
            memberService.updateMember(member);
            // 업데이트 성공 시 처리
        } catch (SQLException e) {
            e.printStackTrace();
            // 예외 처리
        }
    }

    public void deleteMember(int no) {
        try {
            memberService.deleteMember(no);
            // 삭제 성공 시 처리
        } catch (SQLException e) {
            e.printStackTrace();
            // 예외 처리
        }
    }
}