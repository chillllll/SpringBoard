package com.spring.biz.board.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;


@Repository
public class BoardDAOJPA {
	@PersistenceContext
	private EntityManager em;
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===>jpa�� insert���ó��");
		em.persist(vo);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===>jpa�� update���ó��");
		em.merge(vo);
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===>jpa�� delete���ó��");
		em.remove(em.find(BoardVO.class, vo.getSeq()));
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===>jpa�� getboard���ó��");
		return (BoardVO) em.find(BoardVO.class, vo.getSeq());
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("===>jpa�� getboardList���ó��");
		return em.createQuery("from BoardVO b order by b.seq desc").getResultList();
	}

}