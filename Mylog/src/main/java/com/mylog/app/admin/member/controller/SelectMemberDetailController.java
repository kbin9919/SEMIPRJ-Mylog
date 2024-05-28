package com.mylog.app.admin.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.admin.member.service.AdminService;
import com.mylog.app.admin.member.vo.MemberVo;

@WebServlet("/admin/select/member/detail")
public class SelectMemberDetailController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			String no = req.getParameter("no");
			AdminService adminService = new AdminService();
			MemberVo memberVo = adminService.selectMemberDetail(no);
			
//			req.setAttribute("memberVo", memberVo);
//			req.getRequestDispatcher("/WEB-INF/views/admin/member/detail.jsp").forward(req, resp);
			PrintWriter out = resp.getWriter();
			out.write("관리자 로그인 성공! : " + memberVo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			session.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
