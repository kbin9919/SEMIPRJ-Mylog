package com.mylog.app.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mylog.app.board.service.BoardService;
import com.mylog.app.board.vo.BoardVo;

@WebServlet("/board/trend")
public class TrendingBoardCheckController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			BoardService bs = new BoardService();
            List<BoardVo> voList = bs.trendingBoardCheck();

            // 조회된 게시글 리스트를 request 객체에 저장
            req.setAttribute("voList", voList);

            // JSP 페이지로 포워딩
            req.getRequestDispatcher("/WEB-INF/views/board/trending.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
