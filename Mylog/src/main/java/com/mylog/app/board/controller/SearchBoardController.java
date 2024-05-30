package com.mylog.app.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mylog.app.board.service.BoardService;
import com.mylog.app.board.vo.BoardVo;
import com.mylog.app.util.vo.SearchVo;

@WebServlet("/board/search")
public class SearchBoardController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String searchValue = req.getParameter("searchValue");
			String type = req.getParameter("type");
			SearchVo searchVo = new SearchVo();
			searchVo.setSearchValue(searchValue);
			searchVo.setType(type);
			
			BoardService bs = new BoardService();
			List<BoardVo> voList = bs.searchBoard(searchVo);
			
			PrintWriter out = resp.getWriter();
			out.write("voList" + voList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
