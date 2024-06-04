package com.mylog.app.page.qna.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.qna.vo.QNAVo;
import com.mylog.app.util.vo.PageVo;
import com.mylog.app.util.vo.SearchVo;

public class QnaDao {

	public List<QNAVo> qnaList(SqlSession ss, SearchVo searchVo) {
		return ss.selectList("QnaMapper.qnaList", searchVo);
	}

	public int getTotPage(SqlSession ss) {
		return ss.selectOne("QnaMapper.getTotPage");
	}

	public QNAVo selectQna(SqlSession ss, String no) {
		return ss.selectOne("QnaMapper.selectQna", no);
	}

	public int qnaWrite(SqlSession ss, QNAVo qnaVo) {
		return ss.insert("QnaMapper.qnaWrite", qnaVo);
	}

	public List<QNAVo> searchQnaList(SqlSession ss, SearchVo searchVo) {
		return ss.selectList("QnaMapper.searchQnaList", searchVo);
	}

	public int getSearchTotPage(SqlSession ss, SearchVo searchVo) {
		return ss.selectOne("QnaMapper.getSearchTotPage", searchVo);
	}

}
