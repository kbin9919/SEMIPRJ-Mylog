package com.mylog.app.admin.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mylog.app.admin.notice.service.NoticeService;

@WebServlet("/admin/delete/notice")
public class AdminDeleteNoticeController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			String no = req.getParameter("no");
			
			//service
			NoticeService NoticeService = new NoticeService();
			int result = NoticeService.noticeDelete(no);
			
			//result
			PrintWriter out = resp.getWriter();
			out.write("result : " + result);;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
