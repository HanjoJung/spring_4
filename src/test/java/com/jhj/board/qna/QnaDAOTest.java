package com.jhj.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.jhj.board.BoardDTO;
import com.jhj.board.qna.QnaDAO;
import com.jhj.s4.AbstractTestCase;
import com.jhj.util.Pager;

public class QnaDAOTest extends AbstractTestCase{
	
	@Inject
	private QnaDAO qnaDAO;

	@Test
	public void test() {
		Pager pager = new Pager();
		pager.makeRow();
		try {
			List<BoardDTO> ar = qnaDAO.list(pager);
			assertNotEquals(0, ar.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void selectTest() {
		BoardDTO boardDTO = null;
		try {
			boardDTO = qnaDAO.select(1);
			assertNotNull(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void insertTest() {
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setTitle("title");
//		boardDTO.setWriter("writer");
//		boardDTO.setContents("contents");
//		try {
//			int result = qnaDAO.insert(boardDTO);
//			assertEquals(1, result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void replyTest() {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("Rtitle");
		qnaDTO.setWriter("Rwriter");
		qnaDTO.setContents("Rcontents");
		qnaDTO.setRef(6);
		qnaDTO.setStep(2);
		qnaDTO.setDepth(0);
		try {
			int result = qnaDAO.replyUpdate(qnaDTO);
			assertNotEquals(0, result);
			result = qnaDAO.reply(qnaDTO);
			assertEquals(1, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateTest() {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(1);
		boardDTO.setTitle("title2");
		boardDTO.setContents("contents2");
		try {
			int result = qnaDAO.update(boardDTO);
			assertEquals(1, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void deleteTest() {
//		Pager pager = new Pager();
//		pager.makeRow();
//		try {
//			List<BoardDTO> ar = qnaDAO.list(pager);
//			int result = qnaDAO.delete(ar.get(0).getNum());
//			assertEquals(1, result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
