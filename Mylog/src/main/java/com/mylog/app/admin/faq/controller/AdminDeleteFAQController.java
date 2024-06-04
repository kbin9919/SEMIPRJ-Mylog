package com.mylog.app.admin.faq.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mylog.app.admin.faq.service.FAQService;

@WebServlet("/admin/delete/faq")
public class AdminDeleteFAQController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			String no = req.getParameter("no");
			System.out.println(no);
			//service
			FAQService faqService = new FAQService();
			int result = faqService.faqDelete(no);
			System.out.println(result);
			//result
			resp.sendRedirect("/Mylog/faq");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
