package com.mylog.app.page.faq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mylog.app.admin.faq.vo.FAQVo;
import com.mylog.app.page.faq.service.FaqService;

@WebServlet("/select/faq")
public class SelectFAQController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			String no = req.getParameter("no");
			
			//service
			FaqService faqService = new FaqService();
			FAQVo faqVo = faqService.selectFaq(no);
			req.setAttribute("faqVo", faqVo);
			req.getRequestDispatcher("/WEB-INF/views/faq/selectFaq.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
