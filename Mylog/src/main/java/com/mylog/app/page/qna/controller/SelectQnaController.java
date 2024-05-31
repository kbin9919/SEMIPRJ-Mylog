package com.mylog.app.page.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mylog.app.admin.faq.vo.FAQVo;
import com.mylog.app.admin.qna.vo.QNAVo;
import com.mylog.app.page.faq.service.FaqService;
import com.mylog.app.page.qna.service.QnaService;

@WebServlet("/select/qna")
public class SelectQnaController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// data
			String no = req.getParameter("no");

			System.out.println(no);
			// service
			QnaService qnaService = new QnaService();
			QNAVo qnaVo = qnaService.selectQna(no);
			System.out.println(qnaVo);
			req.setAttribute("qnaVo", qnaVo);
			req.getRequestDispatcher("/WEB-INF/views/qna/selectQna.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
