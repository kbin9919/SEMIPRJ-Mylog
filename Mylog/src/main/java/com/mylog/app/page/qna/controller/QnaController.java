package com.mylog.app.page.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.admin.qna.vo.QNAVo;
import com.mylog.app.page.qna.service.QnaService;
import com.mylog.app.util.vo.PageVo;

@WebServlet("/qna")
public class QnaController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		try {
			String startNo = "1";
			String endNo = "4";
			PageVo pageVo = new PageVo();
			pageVo.setStartNo(startNo);
			pageVo.setEndNo(endNo);
			
			QnaService qnaService = new QnaService();
			List<QNAVo> qnaVoList = qnaService.qnaList(pageVo);
			req.setAttribute("qnaVoList", qnaVoList);
			req.getRequestDispatcher("/WEB-INF/views/qna/qna.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			session.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/qna/qna.jsp").forward(req, resp);
	}

}
