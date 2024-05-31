package com.mylog.app.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mylog.app.board.service.BoardService;
import com.mylog.app.visitor.vo.VisitorVo;

@WebServlet("/board/visitor")
public class InsertVisitorController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String boardNo = req.getParameter("boardNo");
			String visitorNum = req.getParameter("visitorNum");
			
			VisitorVo vo = new VisitorVo();
			vo.setBoardNo(boardNo);
			vo.setVisitorNum(visitorNum);
			
			BoardService bs = new BoardService();
			int result = bs.insertVisitor(vo);
			
			PrintWriter out = resp.getWriter();
			out.write("result : " + result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
