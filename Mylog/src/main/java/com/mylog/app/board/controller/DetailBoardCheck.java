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
import com.mylog.app.visitor.vo.VisitorVo;

@WebServlet("/board/detail")
public class DetailBoardCheck extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {

			String no = req.getParameter("no");
			
			BoardService bs = new BoardService();
            BoardVo vo = bs.detailBoardCheck(no);

			PrintWriter out = resp.getWriter();
			out.write("vo : " + vo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}