package com.mylog.app.admin.qna.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.admin.member.vo.AdminVo;
import com.mylog.app.admin.qna.service.QNAService;
import com.mylog.app.admin.qna.vo.QNAVo;

@WebServlet("/admin/writer/qna")
public class AdminWriteQNAController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			// data
			String no = req.getParameter("no");
			String answerTitle = req.getParameter("qna-Title");
			String answerContent = req.getParameter("qna-Content");
			AdminVo loginAdminVo = (AdminVo) session.getAttribute("loginAdminVo");
			String adminNo = loginAdminVo.getNo();

			QNAVo qnaVo = new QNAVo();
			qnaVo.setNo(no);
			qnaVo.setAdminNo(adminNo);
			qnaVo.setAnswerTitle(answerTitle);
			qnaVo.setAnswerContent(answerContent);
			System.out.println(qnaVo);
			// service
			QNAService qnaService = new QNAService();
			int result = qnaService.qnaWrite(qnaVo);
			if(result == 1) {
				resp.sendRedirect("/Mylog/qna");
			}
			// result

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
