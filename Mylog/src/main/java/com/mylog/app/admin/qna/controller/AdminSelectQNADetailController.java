package com.mylog.app.admin.qna.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mylog.app.admin.qna.service.QNAService;
import com.mylog.app.admin.qna.vo.QNAVo;

@WebServlet("/admin/select/qna/detail")
public class AdminSelectQNADetailController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			String no = req.getParameter("no");
			//service
			QNAService qnaService = new QNAService();
			QNAVo qnaVo = qnaService.qnaDetail(no);
			
			//result
			PrintWriter out = resp.getWriter();
			out.write("noticeVo : " + qnaVo);;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
