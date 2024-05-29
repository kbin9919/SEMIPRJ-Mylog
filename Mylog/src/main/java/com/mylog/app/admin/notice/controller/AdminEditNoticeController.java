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

@WebServlet("/admin/edit/notice")
public class AdminEditNoticeController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 데꺼
			String no = req.getParameter("no");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String categoryNo = req.getParameter("categoryNo");
			
			NoticeVo noticeVo = new NoticeVo();
			noticeVo.setNo(no);
			noticeVo.setTitle(title);
			noticeVo.setContent(content);
			noticeVo.setCategoryNo(categoryNo);
			
			NoticeService noticeService = new NoticeService();
			int result = noticeService.editNotice(noticeVo);
			if(result != 1) {
				throw new Exception("게시글 수정 실패 ...");
			}
			PrintWriter out = resp.getWriter();
			out.write("수정 결과 : " + result);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
		
	}
}
