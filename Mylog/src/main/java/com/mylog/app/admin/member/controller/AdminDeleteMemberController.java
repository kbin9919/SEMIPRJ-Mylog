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
	
@WebServlet("/admin/delete/member")
public class AdminDeleteMemberController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			String memberNo = req.getParameter("memberNo");
			
			AdminMemberService adminService = new AdminMemberService();
			int result = adminService.deleteMember(memberNo);
			if(result == 1) {
				PrintWriter out = resp.getWriter();
				out.write("1");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			session.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
