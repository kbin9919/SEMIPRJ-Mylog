package com.mylog.app.comment.controller;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mylog.app.comment.service.CommentService;
import com.mylog.app.comment.vo.CommentVo;

@WebServlet("/comment/write")
public class CommentWriteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String no = req.getParameter("no");
			String boardNo = req.getParameter("boardNo");
			String writerNo = req.getParameter("writerNo");
			String content = req.getParameter("content");
			
			CommentVo vo = new CommentVo();
			vo.setNo(no);
			vo.setBoardNo(boardNo);
			vo.setWriterNo(writerNo);
			vo.setContent(content);
			
			CommentService cs = new CommentService();
			int result = cs.writeComment(vo);
			
			PrintWriter out = resp.getWriter();
			out.write("result : " + result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
