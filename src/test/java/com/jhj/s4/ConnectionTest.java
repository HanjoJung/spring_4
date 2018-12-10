package com.jhj.s4;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.jhj.board.BoardDTO;
import com.jhj.board.notice.NoticeDAO;
import com.jhj.board.qna.QnaDAO;
import com.jhj.board.qna.QnaDTO;

public class ConnectionTest extends AbstractTestCase {

	@Inject
	private NoticeDAO noticeDAO;
	@Inject
	private QnaDAO qnaDAO;

	@Test
	public void test() throws Exception {
//		Pager pager = new Pager();
//		pager.makeRow();
//		int totalCount = noticeDAO.totalCount(pager);
//		pager.makePage(totalCount);
//		List<BoardDTO> ar = noticeDAO.list(pager);
//		for (int i = 0; i < ar.size(); i++) {
//			System.out.println(ar.get(i).getTitle());
//		}
//		pager.setKind("title");
//		pager.setSearch("t");
//		BoardDTO boardDTO = noticeDAO.select(11);
//		System.out.println(boardDTO.getTitle());
//		for (int i = 0; i < 20; i++) {
//			int result = noticeDAO.insert(boardDTO);
//		}
//		boardDTO.setNum(15);
//		int result = noticeDAO.update(boardDTO);
//		int result = noticeDAO.delete(17);
//		assertNotEquals(0, result);
	}

	@Test
	public void QnaTest() throws Exception {
//		Pager pager = new Pager();
//		int totalCount = qnaDAO.totalCount(pager);
//		pager.makeRow();
//		pager.makePage(totalCount);
//		System.out.println(totalCount);
//		List<BoardDTO> ar = qnaDAO.list(pager);
//		for (int i = 0; i < ar.size(); i++) {
//			System.out.println(ar.get(i).getTitle());
//		}
//		QnaDTO qnaDTO = (QnaDTO) qnaDAO.select(6);
//		System.out.println(qnaDTO.getRef());
//		int result = qnaDAO.insert(qnaDTO);
//		int result = qnaDAO.update(qnaDTO);
//		int result = qnaDAO.delete(16);
//		int result = qnaDAO.replyUpdate(qnaDTO);
//		assertNotEquals(0, result);
//		result = qnaDAO.reply(qnaDTO);
//		assertNotEquals(0, result);
	}
}
