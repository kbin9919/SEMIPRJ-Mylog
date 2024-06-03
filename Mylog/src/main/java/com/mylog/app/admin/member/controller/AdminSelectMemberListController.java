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
		HttpSession session = req.getSession();
		try {
			String searchValue = req.getParameter("admin-search");
			String type = req.getParameter("type");
			if(type == null) {
				type = "title";
			}
			
			SearchVo searchVo = new SearchVo();
			searchVo.setSearchValue(searchValue);
			searchVo.setType(type);
			AdminMemberService adminService = new AdminMemberService();
			List<MemberVo> memberVoList = adminService.selectMemberList(searchVo);
			req.setAttribute("memberVoList", memberVoList);
			req.getRequestDispatcher("/WEB-INF/views/admin/selectList.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			session.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
