package com.mylog.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.admin.member.vo.MemberVo;
import com.mylog.app.board.service.BoardService;
import com.mylog.app.board.vo.BoardVo;

@WebServlet("/board/feed")
public class FeedBoardCheckController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			// 로그인된 사용자 정보 가져오기
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			if (loginMember == null) {
				throw new Exception("로그인된 사용자가 아닙니다.");
			}
			String followerNo = loginMember.getNo();

			BoardService bs = new BoardService();
			List<BoardVo> voList = bs.feedBoardCheck(followerNo);

			req.setAttribute("voList", voList);
			req.getRequestDispatcher("/WEB-INF/views/board/feed.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
