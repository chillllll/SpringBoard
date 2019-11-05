package com.spring.biz.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;

@Repository
public class BoardDAOMybatis extends SqlSessionDaoSupport{
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===>mybatis로 insert기능처리");
		getSqlSession().insert("BoardDAO.insertBoard",vo);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===>mybatis로 update기능처리");
		getSqlSession().update("BoardDAO.updateBoard",vo);
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===>mybatis로 delete기능처리");
		getSqlSession().delete("BoardDAO.deleteBoard",vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===>mybatis로 getboard기능처리");
		return getSqlSession().selectOne("BoardDAO.getBoard", vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("===>mybatis로 getboardList기능처리");
		return getSqlSession().selectList("BoardDAO.getBoardList",vo);
	}
}
