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

@WebServlet("/search/faq/list")
public class FAQSearchController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			String searchValue = req.getParameter("faq-search");
			String type = req.getParameter("type");
			String startNo = "1";
			String endNo = "4";
			
			if(type == null) {
				type = "title";
			}
			
			SearchVo searchVo = new SearchVo();
			searchVo.setSearchValue(searchValue);
			searchVo.setType(type);
			searchVo.setStartNo(startNo);
			searchVo.setEndNo(endNo);
			
			FaqService faqService = new FaqService();
			List<FAQVo> faqVoList = faqService.searchFaqList(searchVo);
			req.setAttribute("faqVoList", faqVoList);
			session.setAttribute("searchVo", searchVo);
			req.getRequestDispatcher("/WEB-INF/views/faq/faq.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			session.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	
}
