package com.mylog.app.page.faq.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.admin.faq.vo.FAQVo;
import com.mylog.app.admin.notice.vo.NoticeVo;
import com.mylog.app.page.faq.service.FaqService;
import com.mylog.app.page.notice.service.NoticeService;
import com.mylog.app.util.vo.PageVo;

@WebServlet("/faq")
public class FAQListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		try {
			session.removeAttribute("searchVo");
			String startNo = "1";
			String endNo = "4";
			PageVo pageVo = new PageVo();
			pageVo.setStartNo(startNo);
			pageVo.setEndNo(endNo);
			
			FaqService faqService = new FaqService();
			List<FAQVo> faqVoList = faqService.faqList(pageVo);
			req.setAttribute("faqVoList", faqVoList);
			req.getRequestDispatcher("/WEB-INF/views/faq/faq.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			session.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/faq/faq.jsp").forward(req, resp);
	}

}
