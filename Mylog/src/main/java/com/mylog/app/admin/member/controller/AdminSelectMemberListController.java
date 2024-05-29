package com.mylog.app.admin.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.admin.member.service.AdminMemberService;
import com.mylog.app.admin.member.vo.MemberVo;
import com.mylog.app.util.vo.SearchVo;

@WebServlet("/admin/select/member/list")
public class AdminSelectMemberListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			String searchValue = req.getParameter("searchValue");
			String type = req.getParameter("type");
			SearchVo searchVo = new SearchVo();
			searchVo.setSearchValue(searchValue);
			searchVo.setType(type);
			
			AdminMemberService adminService = new AdminMemberService();
			List<MemberVo> memberVoList = adminService.selectMemberList(searchVo);
			
//			req.setAttribute("memberVoList", memberVoList);
//			req.getRequestDispatcher("/WEB-INF/views/admin/member/select.jsp").forward(req, resp);
			PrintWriter out = resp.getWriter();
			out.write("관리자 로그인 성공! : " + memberVoList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			session.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
