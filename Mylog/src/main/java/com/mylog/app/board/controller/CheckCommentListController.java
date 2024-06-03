package com.mylog.app.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mylog.app.comment.service.CommentService;
import com.mylog.app.comment.vo.CommentVo;

@WebServlet("/board/comment/list")
public class CheckCommentListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String boardNo = req.getParameter("boardNo");

			CommentService cs = new CommentService();
			List<CommentVo> CVoList = cs.commentListCheck(boardNo);
			Gson gson = new Gson();
			String str = gson.toJson(CVoList);

			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.write(str);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
