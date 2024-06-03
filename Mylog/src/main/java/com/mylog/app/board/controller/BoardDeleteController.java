package com.mylog.app.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.admin.member.vo.MemberVo;
import com.mylog.app.board.service.BoardService;
import com.mylog.app.board.vo.BoardVo;

@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			HttpSession session = req.getSession();

			String no = req.getParameter("no");
			String memberNo = ((MemberVo) session.getAttribute("loginMemberVo")).getNo();

			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setWriterNo(memberNo);

			BoardService bs = new BoardService();

			int result = bs.deleteBoard(vo);

			if (result != 1) {
				throw new Exception("게시글 삭제 실패");
			}

			session.setAttribute("alertMsg", "게시글 삭제 성공!!!");
			resp.sendRedirect("/Mylog/board/all");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}