package com.mylog.app.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.admin.member.vo.MemberVo;
import com.mylog.app.board.service.BoardService;
import com.mylog.app.board.vo.BoardVo;
import com.mylog.app.visitor.vo.VisitorVo;

@WebServlet("/board/detail")
public class DetailBoardCheck extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {

			String no = req.getParameter("no");
			String writerNo = req.getParameter("writerNo");

			BoardService bs = new BoardService();
            MemberVo loginMemberVo = (MemberVo) req.getSession().getAttribute("loginMemberVo");
            boolean isSelf = false;

            // 현재 사용자가 게시글 작성자인지 확인 (예시)
            if (loginMemberVo != null && loginMemberVo.getNo().equals(writerNo)) {
                isSelf = true;
            }
            VisitorVo vvo = new VisitorVo();
			BoardVo bvo = bs.detailBoardCheck(no, vvo, isSelf);

			PrintWriter out = resp.getWriter();
			out.write("bvo : " + bvo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
