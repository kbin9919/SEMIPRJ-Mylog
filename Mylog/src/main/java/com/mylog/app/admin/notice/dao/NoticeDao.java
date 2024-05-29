package com.mylog.app.admin.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.notice.vo.NoticeVo;
import com.mylog.app.util.vo.SearchVo;

public class NoticeDao {

	public int noticeWrite(SqlSession ss, NoticeVo noticeVo) {
		return ss.insert("AdminNoticeMapper.noticeWrite", noticeVo);
	}

	public NoticeVo noticeDetail(SqlSession ss, String no) {
		return ss.selectOne("AdminNoticeMapper.noticeDetail", no);
	}

	public List<NoticeVo> noticeList(SqlSession ss) {
		return ss.selectList("AdminNoticeMapper.noticeList");
	}

	public List<NoticeVo> selectNoticeList(SqlSession ss, SearchVo searchVo) {
		return ss.selectList("AdminNoticeMapper.selectNoticeList", searchVo);
	}

	public int noticeDelete(SqlSession ss, String no) {
		return ss.delete("AdminNoticeMapper.noticeDelete", no);
	}

	public int editNotice(SqlSession ss, NoticeVo noticeVo) {
		return ss.update("AdminNoticeMapper.editNotice", noticeVo);
	}

}
