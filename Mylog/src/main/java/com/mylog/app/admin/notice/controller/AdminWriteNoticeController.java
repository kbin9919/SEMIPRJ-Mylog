package com.mylog.app.admin.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.admin.member.vo.AdminVo;
import com.mylog.app.admin.notice.service.NoticeService;
import com.mylog.app.admin.notice.vo.NoticeVo;

@WebServlet("/admin/writer/notice")
public class AdminWriteNoticeController extends HttpServlet{
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
			
			NoticeVo noticeVo = new NoticeVo();
			noticeVo.setTitle(title);
			noticeVo.setContent(content);
			noticeVo.setCategoryNo(categoryNo);
			noticeVo.setWriterNo(writerNo);
			
			//service
			NoticeService noticeService = new NoticeService();
			int result = noticeService.noticeWrite(noticeVo);
			
			//result
			PrintWriter out = resp.getWriter();
			out.write("result : " + result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
