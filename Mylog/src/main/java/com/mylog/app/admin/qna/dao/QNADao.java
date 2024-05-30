package com.mylog.app.admin.qna.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.qna.vo.QNAVo;
import com.mylog.app.util.vo.SearchVo;

public class QNADao {

	public int qnaDelete(SqlSession ss, String no) {
		return ss.delete("AdminQNAMapper.qnaDelete", no);
	}

	public List<QNAVo> qnaList(SqlSession ss) {
		return ss.selectList("AdminQNAMapper.qnaList");
	}

	public QNAVo qnaDetail(SqlSession ss, String no) {
		return ss.selectOne("AdminQNAMapper.qnaDetail", no);
	}

	public List<QNAVo> selectQnaList(SqlSession ss, SearchVo searchVo) {
		return ss.selectList("AdminQNAMapper.qnaList", searchVo);
	}

	public int qnaWrite(SqlSession ss, QNAVo qnaVo) {
		return ss.update("AdminQNAMapper.qnaWrite", qnaVo);
	}

}
