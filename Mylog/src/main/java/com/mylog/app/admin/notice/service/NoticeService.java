package com.mylog.app.admin.notice.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.notice.dao.NoticeDao;
import com.mylog.app.admin.notice.vo.NoticeVo;
import com.mylog.app.util.db.SqlSessionTemplate;
import com.mylog.app.util.vo.SearchVo;

public class NoticeService {
	private final NoticeDao dao;

	public NoticeService() {
		this.dao = new NoticeDao();
	}

	public int noticeWrite(NoticeVo vo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.noticeWrite(ss, vo);
		if (result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();
		return result;
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
