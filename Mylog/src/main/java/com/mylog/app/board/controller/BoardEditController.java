package com.mylog.app.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.board.service.BoardService;
import com.mylog.app.board.vo.BoardVo;

@WebServlet("/board/edit")
public class BoardEditController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			String categoryNo = req.getParameter("categoryNo");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String secretYn = req.getParameter("secretYn");
			String no = req.getParameter("no");
			
			BoardVo vo = new BoardVo();
			vo.setCategoryNo(categoryNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setSecretYn(secretYn);
			vo.setNo(no);
			
			BoardService bs = new BoardService();
			int result = bs.editBoard(vo);
			
			PrintWriter out = resp.getWriter();
			out.write("result : " + result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}