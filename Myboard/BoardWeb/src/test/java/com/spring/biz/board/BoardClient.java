package com.spring.biz.board;

import java.sql.SQLException;
import java.util.List;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

public class BoardClient {
	public static void main(String[] args) throws SQLException {

		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();

		vo.setTitle("mybatis ����");
		vo.setWriter("ȫ");
		vo.setContent("����");
		boardDAO.insertBoard(vo);

		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("--->" + board.toString());
		}

	}

}