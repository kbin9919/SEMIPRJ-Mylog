package com.mylog.app.page.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.admin.notice.vo.NoticeVo;
import com.mylog.app.page.notice.service.NoticeService;
import com.mylog.app.util.vo.PageVo;
import com.mylog.app.util.vo.SearchVo;

@WebServlet("/search/notice/list")
public class NoticeSearchListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			String searchValue = req.getParameter("notice-search");
			String type = req.getParameter("type");
			String categoryNo = req.getParameter("category-no");
			String startNo = "1";
			String endNo = "4";
			
			if(type == null) {
				type = "title";
			}
			
			
			SearchVo searchVo = new SearchVo();
			searchVo.setSearchValue(searchValue);
			searchVo.setType(type);
			searchVo.setCategoryNo(categoryNo);
			searchVo.setStartNo(startNo);
			searchVo.setEndNo(endNo);
			NoticeService noticeService = new NoticeService();
			List<NoticeVo> noticeVoList = noticeService.searchNoticeList(searchVo);
			req.setAttribute("noticeVoList", noticeVoList);
			session.setAttribute("searchVo", searchVo);
			req.getRequestDispatcher("/WEB-INF/views/notice/searchNotice.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			session.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	
}
