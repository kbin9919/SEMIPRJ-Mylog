package com.mylog.app.page.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mylog.app.admin.notice.vo.NoticeVo;
import com.mylog.app.page.notice.service.NoticeService;

@WebServlet("/select/notice")
public class SelectNoticeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			String no = req.getParameter("no");
			//service
			NoticeService noticeService = new NoticeService();
			NoticeVo noticeVo = noticeService.selectNotice(no);
			req.setAttribute("noticeVo", noticeVo);
			//result
			req.getRequestDispatcher("/WEB-INF/views/notice/selectNotice.jsp").forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
