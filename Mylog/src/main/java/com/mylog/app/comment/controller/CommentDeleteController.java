package com.mylog.app.comment.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mylog.app.comment.service.CommentService;
import com.mylog.app.comment.vo.CommentVo;

@WebServlet("/comment/delete")
public class CommentDeleteController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String no = req.getParameter("no");
			String writerNo = req.getParameter("writerNo");
			String boardNo = req.getParameter("boardNo");
			
			CommentVo vo = new CommentVo();
			vo.setNo(no);
			vo.setWriterNo(writerNo);
			vo.setBoardNo(boardNo);
			
			CommentService cs = new CommentService();
			int result = cs.deleteComment(vo);
			
			PrintWriter out = resp.getWriter();
			out.write("result : " + result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
