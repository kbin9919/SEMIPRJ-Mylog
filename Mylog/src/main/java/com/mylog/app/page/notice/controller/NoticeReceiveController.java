package com.mylog.app.page.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.admin.notice.vo.NoticeVo;
import com.mylog.app.page.notice.service.NoticeService;
import com.mylog.app.util.vo.PageVo;

@WebServlet("/notice/receive")
public class NoticeReceiveController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			String startNo = req.getParameter("startNo");
			String endNo = req.getParameter("endNo");
			if(startNo == null) startNo = "";
			if(endNo == null) endNo = "";
			
			PageVo pageVo = new PageVo();
			pageVo.setStartNo(startNo);
			pageVo.setEndNo(endNo);
			NoticeService noticeService = new NoticeService();
			
			List<NoticeVo> noticeVoList = noticeService.noticeList(pageVo);
			
			int noticeCount = noticeService.getTotPage();
			
			req.setAttribute("noticeCount", noticeCount);
			req.setAttribute("noticeVoList", noticeVoList);
			
			req.getRequestDispatcher("/WEB-INF/views/notice/receive.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			session.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
