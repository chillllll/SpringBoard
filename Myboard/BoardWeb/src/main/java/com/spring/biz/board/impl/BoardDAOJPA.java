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
		System.out.println("===>jpa로 insert기능처리");
		em.persist(vo);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===>jpa로 update기능처리");
		em.merge(vo);
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===>jpa로 delete기능처리");
		em.remove(em.find(BoardVO.class, vo.getSeq()));
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===>jpa로 getboard기능처리");
		return (BoardVO) em.find(BoardVO.class, vo.getSeq());
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("===>jpa로 getboardList기능처리");
		return em.createQuery("from BoardVO b order by b.seq desc").getResultList();
	}

}
