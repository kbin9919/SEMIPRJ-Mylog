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
import com.mylog.app.page.faq.service.FaqService;
import com.mylog.app.util.vo.SearchVo;

@WebServlet("/faq/search/receive")
public class FAQSearchReceiveController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			
			SearchVo searchVo = (SearchVo) session.getAttribute("searchVo");
			String startNo = req.getParameter("startNo");
			String endNo = req.getParameter("endNo");
			if(startNo == null) startNo = "";
			if(endNo == null) endNo = "";
			searchVo.setStartNo(startNo);
			searchVo.setEndNo(endNo);
			
			FaqService faqService = new FaqService();
			List<FAQVo> faqVoList = faqService.searchFaqList(searchVo);
			int faqCount = faqService.getSearchTotPage(searchVo);
			System.out.println(faqVoList.size());
			System.out.println(faqCount);
			if(Integer.parseInt(startNo) > faqCount) {
				session.removeAttribute("searchVo");
			}
			
			req.setAttribute("faqCount", faqCount);
			req.setAttribute("faqVoList", faqVoList);
			req.getRequestDispatcher("/WEB-INF/views/faq/receive.jsp").forward(req, resp);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			session.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
