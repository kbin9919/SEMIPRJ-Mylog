package com.mylog.app.admin.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.admin.member.service.AdminMemberService;
import com.mylog.app.admin.member.vo.WarningVo;

@WebServlet("/admin/warning")
public class WarningMemberController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			String warningNo = req.getParameter("warningNo");
			String memberNo = req.getParameter("memberNo");
			WarningVo warningVo = new WarningVo();
			warningVo.setWarningNo(warningNo);
			warningVo.setMemberNo(memberNo);
			
			AdminMemberService adminService = new AdminMemberService();
			int result = adminService.warningMember(warningVo);
//			req.setAttribute("memberVo", memberVo);
//			req.getRequestDispatcher("/WEB-INF/views/admin/member/detail.jsp").forward(req, resp);
			PrintWriter out = resp.getWriter();
			out.write("회원 경고 : " + result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			session.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
