package com.mylog.app.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mylog.app.board.service.BoardService;
import com.mylog.app.board.vo.AttachmentVo;
import com.mylog.app.board.vo.BoardVo;
import com.mylog.app.board.vo.CategoryVo;
import com.mylog.app.board.vo.MemberVo;
import com.mylog.app.util.file.FileUpload;

@MultipartConfig(maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 500, fileSizeThreshold = 1024 * 1024
		* 50)

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BoardService bs = new BoardService();
			List<CategoryVo> categoryVoList;
			categoryVoList = bs.getCategoryVoList();
			req.setAttribute("categoryVoList", categoryVoList);
			req.getRequestDispatcher("/WEB-INF/views/write/write.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			String categoryNo = req.getParameter("categoryNo");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
//			String writerNo = req.getParameter("writerNo");

			Collection<Part> parts = req.getParts();
			List<Part> fileList = new ArrayList<Part>();
			for (Part part : parts) {
				if(part.getContentType() != null) {
					fileList.add(part);
				}
			}
			
			//서버에 파일 업로드
			List<AttachmentVo> attVoList = new ArrayList<AttachmentVo>();
			for (Part f : fileList) {
				AttachmentVo attVo = FileUpload.saveFile(f);
				attVoList.add(attVo);
			}
			
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			String writerNo = loginMember.getNo();

			BoardVo vo = new BoardVo();
			vo.setCategoryNo(categoryNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);

			BoardService bs = new BoardService();
			int result = bs.wrtieBoard(vo, attVoList);

			if (result < 1) {
				throw new Exception("게시글 작성 실패 ...");
			}
			resp.sendRedirect("/Mylog/board/search");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}

}
