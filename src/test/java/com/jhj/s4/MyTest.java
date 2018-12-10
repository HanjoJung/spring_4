package com.jhj.s4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;

import com.jhj.board.BoardDTO;
import com.jhj.board.notice.NoticeDAO;

public class MyTest extends AbstractTestCase{

	@Inject
	private NoticeDAO noticeDAO;
	
	@Test
	public void test() {
		BoardDTO boardDTO = new BoardDTO();
		try {
			boardDTO = noticeDAO.select(2);
			assertNotNull(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		BoardDTO boardDTO = new BoardDTO();
		try {
			int result = noticeDAO.insert(boardDTO);
			assertEquals(1, result);
			boardDTO.setNum(0);
			result = noticeDAO.update(boardDTO);
			assertNotEquals(1, result);
			result = noticeDAO.delete(4);
			assertEquals(0, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
