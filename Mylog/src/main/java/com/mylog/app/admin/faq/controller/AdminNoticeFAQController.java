package com.mylog.app.admin.faq.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.admin.faq.service.FAQService;
import com.mylog.app.admin.faq.vo.FAQVo;

@WebServlet("/admin/faq/list")
public class AdminNoticeFAQController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			FAQService noticeService = new FAQService();
			List<FAQVo> noticeVoList = noticeService.noticeList();
			
			//result
			PrintWriter out = resp.getWriter();
			out.write("result : " + noticeVoList);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			session.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
