package com.mylog.app.page.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.admin.qna.vo.QNAVo;
import com.mylog.app.page.qna.service.QnaService;

@WebServlet("/writeQna")
public class WriteQnaController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/qna/writeQna.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			//data
			String writerNo = "1";
			String title = req.getParameter("qna-title");
			String content = req.getParameter("qna-content");
			String secretYn = req.getParameter("secretYn");
			
			if(secretYn.equals("on")) {
				secretYn = "Y";
			}else {
				secretYn = "N";
			}
			
			QNAVo qnaVo = new QNAVo();
			qnaVo.setWriterNo(writerNo);
			qnaVo.setTitle(title);
			qnaVo.setContent(content);
			qnaVo.setSecretYn(secretYn);
			System.out.println(qnaVo);
			//service
			QnaService qnaService = new QnaService();
			int result = qnaService.qnaWrite(qnaVo);
			resp.sendRedirect("/Mylog/qna");
			//result
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
