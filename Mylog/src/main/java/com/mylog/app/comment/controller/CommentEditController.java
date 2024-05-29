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

@WebServlet("/comment/edit")
public class CommentEditController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String content = req.getParameter("content");
			String no = req.getParameter("no");
			String writerNo = req.getParameter("writerNo");
			String boardNo = req.getParameter("boardNo");
			
			CommentVo vo = new CommentVo();
			vo.setContent(content);
			vo.setNo(no);
			vo.setWriterNo(writerNo);
			vo.setBoardNo(boardNo);
			
			CommentService cs = new CommentService();
			int result = cs.editComment(vo);
			System.out.println(vo);
			
			PrintWriter out = resp.getWriter();
			out.write("result : " + result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
