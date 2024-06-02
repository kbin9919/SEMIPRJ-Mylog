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
import com.mylog.app.util.vo.SearchVo;

@WebServlet("/qna/receive")
public class QnaReceiveController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			SearchVo searchVo = (SearchVo) session.getAttribute("searchVo");
			System.out.println(searchVo);
			String startNo = req.getParameter("startNo");
			String endNo = req.getParameter("endNo");
			if(startNo == null) startNo = "";
			if(endNo == null) endNo = "";
			searchVo.setStartNo(startNo);
			searchVo.setEndNo(endNo);
			QnaService qnaService = new QnaService();
			List<QNAVo> qnaVoList = qnaService.qnaList(searchVo);
			int qnaCount = qnaService.getTotPage();
			
			if(Integer.parseInt(startNo) > qnaCount) {
				session.removeAttribute("searchVo");
			}
			
			req.setAttribute("qnaVoList", qnaVoList);
			req.setAttribute("qnaCount", qnaCount);
			
			req.getRequestDispatcher("/WEB-INF/views/qna/receive.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			session.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
