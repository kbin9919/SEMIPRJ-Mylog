package com.mylog.app.admin.notice.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.notice.dao.AdminNoticeDao;
import com.mylog.app.admin.notice.vo.NoticeVo;
import com.mylog.app.util.db.SqlSessionTemplate;
import com.mylog.app.util.vo.AttachmentVo;
import com.mylog.app.util.vo.SearchVo;

public class AdminNoticeService {
	private final AdminNoticeDao dao;

	public AdminNoticeService() {
		this.dao = new AdminNoticeDao();
	}

	public int noticeWrite(NoticeVo noticeVo, List<AttachmentVo> attVoList) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.noticeWrite(ss, noticeVo);
		int attResult = 1;
		if(attVoList.size() > 0) {
			attResult = dao.insertNoticeAttachment(ss , attVoList);
		}
		
		if(result * attResult >= 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		
		return result * attResult;
	}

	public NoticeVo noticeDetail(String no) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		NoticeVo noticeVo = dao.noticeDetail(ss, no);
		ss.close();
		return noticeVo;
	}

	public List<NoticeVo> noticeList() throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<NoticeVo> noticeListVo = dao.noticeList(ss);
		ss.close();
		return noticeListVo;
	}

	public List<NoticeVo> selectNoticeList(SearchVo searchVo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<NoticeVo> noticeListVo = dao.selectNoticeList(ss, searchVo);
		ss.close();
		return noticeListVo;
	}

	public int noticeDelete(String no) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.noticeDelete(ss, no);
		if (result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();
		return result;
	}

	public int editNotice(NoticeVo noticeVo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.editNotice(ss, noticeVo);
		if (result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();
		return result;
	}
}
