package com.mylog.app.admin.qna.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.admin.qna.service.QNAService;
import com.mylog.app.admin.qna.vo.QNAVo;
import com.mylog.app.util.vo.SearchVo;

@WebServlet("/admin/select/qna/list")
public class AdminSelectQNAList extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			String searchValue = req.getParameter("searchValue");
			String type = req.getParameter("type");
			SearchVo searchVo = new SearchVo();
			searchVo.setSearchValue(searchValue);
			searchVo.setType(type);
			
			QNAService qnaService = new QNAService();
			List<QNAVo> qnaVoList = qnaService.selectQnaList(searchVo);
			
//			req.setAttribute("memberVoList", memberVoList);
//			req.getRequestDispatcher("/WEB-INF/views/admin/member/select.jsp").forward(req, resp);
			PrintWriter out = resp.getWriter();
			out.write("리스트 : " + qnaVoList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			session.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
