package com.mylog.app.page.qna.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.qna.vo.QNAVo;
import com.mylog.app.util.vo.PageVo;

public class QnaDao {

	public List<QNAVo> qnaList(SqlSession ss, PageVo pageVo) {
		return ss.selectList("QnaMapper.qnaList" , pageVo);
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

}
