package com.mylog.app.admin.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mylog.app.admin.notice.service.NoticeService;
import com.mylog.app.admin.notice.vo.NoticeVo;

@WebServlet("/admin/select/notice/detail")
public class AdminSelectNoticeDetailController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			String no = req.getParameter("no");
			
			//service
			NoticeService noticeService = new NoticeService();
			NoticeVo noticeVo = noticeService.noticeDetail(no);
			
			//result
			PrintWriter out = resp.getWriter();
			out.write("noticeVo : " + noticeVo);;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
