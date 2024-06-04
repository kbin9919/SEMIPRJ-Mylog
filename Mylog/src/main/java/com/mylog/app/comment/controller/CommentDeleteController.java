package com.mylog.app.comment.controller;

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
import com.mylog.app.comment.service.CommentService;
import com.mylog.app.comment.vo.CommentVo;
import com.mylog.app.visitor.vo.VisitorVo;

@WebServlet("/comment/delete")
public class CommentDeleteController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();

			String no = req.getParameter("no");
			String boardNo = req.getParameter("boardNo");
			String memberNo = ((MemberVo) session.getAttribute("loginMemberVo")).getNo();

			CommentVo vo = new CommentVo();
			vo.setNo(no);
			vo.setWriterNo(memberNo);
			vo.setBoardNo(boardNo);

			CommentService cs = new CommentService();
			int result = cs.deleteComment(vo);

			if (result != 1) {
				throw new Exception("댓글 삭제 실패");
			}
			resp.sendRedirect("/board/detail?no=" + boardNo);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
