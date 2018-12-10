package com.jhj.board.qna;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jhj.board.BoardDTO;
import com.jhj.board.BoardService;
import com.jhj.util.Pager;

@Service
public class QnaService implements BoardService {

	@Inject
	private QnaDAO qnaDAO;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePage(qnaDAO.totalCount(pager));
		return qnaDAO.list(pager);
	}

	@Override
	public BoardDTO select(int num) throws Exception {
		return qnaDAO.select(num);
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		return qnaDAO.insert(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		return qnaDAO.delete(num);
	}

	public int reply(QnaDTO qnaDTO) throws Exception {
		qnaDAO.replyUpdate(qnaDTO);
		return qnaDAO.reply(qnaDTO);
	}

}
