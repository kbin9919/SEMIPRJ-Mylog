package com.mylog.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.admin.member.vo.AdminVo;
import com.mylog.app.board.service.BoardService;
import com.mylog.app.util.vo.AttachmentVo;
import com.mylog.app.board.vo.BoardVo;
import com.mylog.app.board.vo.MemberVo;
import com.mylog.app.visitor.vo.VisitorVo;

@WebServlet("/board/detail")
public class DetailBoardCheck extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {

			// 데이터 꺼내기
			String no = req.getParameter("no");
			if (no == null || no.length() == 0) {
				throw new Exception("조회할 게시글 번호를 입력하세요");
			}

			// 로그인한 사용자 정보를 가져오기
			AdminVo loginAdminVo = (AdminVo) session.getAttribute("loginAdminVo");
		

			VisitorVo visitor = new VisitorVo();
			visitor.setBoardNo(no);
			visitor.setVisitorNum(loginAdminVo.getNo());
			// 상세조회 조회수 증가 처리
			BoardService bs = new BoardService();
			BoardVo vo = bs.detailBoardCheck(no, visitor);
			List<AttachmentVo> attVoList = bs.getAttachment(no);

			if (vo == null) {
				throw new Exception("게시글 조회 실패");
			}

			req.setAttribute("vo", vo);
			req.setAttribute("attVoList", attVoList);
			req.getRequestDispatcher("/WEB-INF/views/search/searchByOne.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
