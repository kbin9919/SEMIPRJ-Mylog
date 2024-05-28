package com.mylog.app.admin.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.admin.board.service.AdminBoardService;
import com.mylog.app.admin.board.vo.BoardVo;

@WebServlet("/admin/select/board/detail")
public class AdminSelectBoardDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			String no = req.getParameter("no");
			AdminBoardService adminService = new AdminBoardService();
			BoardVo boardVo = adminService.selectBoardDetail(no);
			System.out.println(boardVo);
//			req.setAttribute("memberVo", memberVo);
//			req.getRequestDispatcher("/WEB-INF/views/admin/member/detail.jsp").forward(req, resp);
			PrintWriter out = resp.getWriter();
			out.write("관리자 로그인 성공! : "+ boardVo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			session.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
