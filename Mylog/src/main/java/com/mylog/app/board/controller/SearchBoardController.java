package com.mylog.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.board.service.BoardService;
import com.mylog.app.util.vo.AttachmentVo;
import com.mylog.app.board.vo.BoardVo;
import com.mylog.app.util.vo.SearchVo;

@WebServlet("/board/search")
public class SearchBoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 호출됨");
		req.getRequestDispatcher("/WEB-INF/views/mypage/search.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost 호출됨");
		HttpSession session = req.getSession();
		try {

			String searchValue = req.getParameter("search-board");

			String type = req.getParameter("type");
			if(type == null) {
				type = "title";
			}
			SearchVo searchVo = new SearchVo();
			searchVo.setSearchValue(searchValue);
			searchVo.setType(type);
			System.out.println(searchVo);
			BoardService bs = new BoardService();
			List<BoardVo> voList = bs.searchBoard(searchVo);
			for(BoardVo vo : voList) {
				System.out.println(vo);
			}
			List<AttachmentVo> attVoList = bs.getAttachment(null);
			
			req.setAttribute("attVoList", attVoList);
			req.setAttribute("voList", voList);
			session.setAttribute("searchVo", searchVo);
			req.getRequestDispatcher("/WEB-INF/views/mypage/search.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			session.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
