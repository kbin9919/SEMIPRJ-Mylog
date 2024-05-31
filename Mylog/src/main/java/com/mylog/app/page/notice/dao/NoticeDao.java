package com.mylog.app.page.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.notice.vo.NoticeVo;
import com.mylog.app.util.vo.PageVo;
import com.mylog.app.util.vo.SearchVo;

public class NoticeDao {

	public List<NoticeVo> noticeList(SqlSession ss, PageVo pageVo) {
		return ss.selectList("NoticeMapper.noticeList" , pageVo);
	}

	public int getTotPage(SqlSession ss) {
		return ss.selectOne("NoticeMapper.getTotPage");
	}

	public NoticeVo selectNotice(SqlSession ss, String no) {
		return ss.selectOne("NoticeMapper.selectNotice", no);
	}

	public List<NoticeVo> searchNoticeList(SqlSession ss, SearchVo searchVo) {
		return ss.selectList("NoticeMapper.searchNoticeList" , searchVo);
	}
	

}
