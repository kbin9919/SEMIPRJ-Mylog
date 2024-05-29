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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			AdminVo loginAdminVo = (AdminVo) session.getAttribute("loginAdminVo");
			//data
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String categoryNo = req.getParameter("categoryNo");
			String writerNo = "1";
			//loginAdminVo.getNo();
			
			FAQVo vo = new FAQVo();
			vo.setTitle(title);
			
			
			//service
			FAQService noticeService = new FAQService();
			int result = noticeService.noticeWrite(vo);
			
			//result
			PrintWriter out = resp.getWriter();
			out.write("result : " + result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
