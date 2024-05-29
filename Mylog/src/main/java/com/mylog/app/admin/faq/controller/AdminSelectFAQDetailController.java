package com.mylog.app.admin.faq.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mylog.app.admin.faq.service.FAQService;
import com.mylog.app.admin.faq.vo.FAQVo;

@WebServlet("/admin/select/faq/detail")
public class AdminSelectFAQDetailController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			String no = req.getParameter("no");
			
			//service
			FAQService NoticeService = new FAQService();
			FAQVo noticeVo = NoticeService.noticeDetail(no);
			
			//result
			PrintWriter out = resp.getWriter();
			out.write("noticeVo : " + noticeVo);;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
