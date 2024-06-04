package com.mylog.app.admin.faq.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.admin.faq.service.FAQService;
import com.mylog.app.admin.faq.vo.FAQVo;
import com.mylog.app.admin.member.vo.AdminVo;

@WebServlet("/admin/writer/faq")
public class AdminWriteFAQController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/faq/writeFaq.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			AdminVo loginAdminVo = (AdminVo) session.getAttribute("loginAdminVo");
			
			if(loginAdminVo !=null) {
				//data
				String title = req.getParameter("qna-title");
				String content = req.getParameter("qna-content");
				
				FAQVo faqVo = new FAQVo();
				faqVo.setTitle(title);
				faqVo.setContent(content);
				
				
				//service
				FAQService faqService = new FAQService();
				int result = faqService.faqWrite(faqVo);
				
				System.out.println(result);
				//result
				if(result == 1) {
					session.setAttribute("alertMsg", "FAQ 작성 성공!");
					resp.sendRedirect("/Mylog/faq");
				}
			} else {
				session.setAttribute("alertMsg", "관리자가 아닙니다.");
				resp.sendRedirect("/Mylog/faq");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
