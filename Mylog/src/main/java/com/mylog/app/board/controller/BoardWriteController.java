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

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/write/write.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			String no = req.getParameter("no");
			String categoryNo = req.getParameter("categoryNo");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
//			String writerNo = req.getParameter("writerNo");

			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			if (loginMember == null) {
				throw new Exception("로그인이 필요합니다.");
			}
			
			String writerNo = loginMember.getNo();

			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setCategoryNo(categoryNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);

			BoardService bs = new BoardService();
			int result = bs.wrtieBoard(vo);

			if (result < 1) {
				throw new Exception("게시글 작성 실패 ...");
			}
			resp.sendRedirect("/Mylog/board/write");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}

}
