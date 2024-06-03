package com.mylog.app.admin.notice.controller;

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

import com.mylog.app.admin.member.vo.AdminVo;
import com.mylog.app.admin.notice.service.AdminNoticeService;
import com.mylog.app.admin.notice.vo.NoticeVo;
import com.mylog.app.util.file.FileUpload;
import com.mylog.app.util.vo.AttachmentVo;

@MultipartConfig(maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 500, fileSizeThreshold = 1024 * 1024
		* 50)
@WebServlet("/admin/writer/notice")
public class AdminWriteNoticeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 관리자 공지사항 작성 페이지로 넘김
			req.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			AdminVo loginAdminVo = (AdminVo) session.getAttribute("loginAdminVo");
			// data
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String categoryNo = req.getParameter("categoryNo");
			String writerNo = "1";
			// loginAdminVo.getNo();
			
			NoticeVo noticeVo = new NoticeVo();
			noticeVo.setTitle(title);
			noticeVo.setContent(content);
			noticeVo.setCategoryNo(categoryNo);
			noticeVo.setWriterNo(writerNo);
			
			Collection<Part> parts = req.getParts();

			List<Part> fileList = new ArrayList<Part>();
			for (Part part : parts) {
				if (part.getContentType() != null) {
					fileList.add(part);
				}
			}

			// 서버에 파일 업로드
			List<AttachmentVo> attVoList = new ArrayList<AttachmentVo>();
			for (Part f : fileList) {
				AttachmentVo attVo = FileUpload.saveFile(f);
				attVoList.add(attVo);
			}
			

			for (Part part : parts) {
				if (part.getContentType() != null) {
					fileList.add(part);
				}
			}
			

			

			// service
			AdminNoticeService noticeService = new AdminNoticeService();
			int result = noticeService.noticeWrite(noticeVo, attVoList);

			if (result < 1) {
				throw new Exception("게시글 작성 실패 ...");
			}
			resp.sendRedirect("/app/board/list");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
