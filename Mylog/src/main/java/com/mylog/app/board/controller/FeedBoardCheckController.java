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

@WebServlet("/board/feed")
public class FeedBoardCheckController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
//			HttpSession session = req.getSession();
//			
//			session.getAttribute(getServletName())
			String followerNo = req.getParameter("followerNo");
					
			BoardService bs = new BoardService();
			List<BoardVo> voList = bs.feedBoardCheck(followerNo);
			
			PrintWriter out = resp.getWriter();
			out.write("voList : " + voList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
