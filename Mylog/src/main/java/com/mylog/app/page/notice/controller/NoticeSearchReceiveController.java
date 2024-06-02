package com.mylog.app.page.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.admin.notice.vo.NoticeVo;
import com.mylog.app.page.notice.service.NoticeService;
import com.mylog.app.util.vo.SearchVo;

@WebServlet("/notice/search/receive")
public class NoticeSearchReceiveController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			SearchVo searchVo = (SearchVo) session.getAttribute("searchVo");
			String startNo = req.getParameter("startNo");
			String endNo = req.getParameter("endNo");
			if (startNo == null)
				startNo = "";
			if (endNo == null)
				endNo = "";

			searchVo.setStartNo(startNo);
			searchVo.setEndNo(endNo);
			System.out.println(searchVo);
			NoticeService noticeService = new NoticeService();
			List<NoticeVo> noticeVoList = noticeService.searchNoticeList(searchVo);

			int noticeCount = noticeService.getSearchTotPage(searchVo);
			System.out.println(noticeCount);
			
			if (Integer.parseInt(startNo) > noticeCount) {
				session.removeAttribute("searchVo");
			}
			

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
