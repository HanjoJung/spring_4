package com.jhj.board.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jhj.board.BoardDTO;
import com.jhj.board.BoardService;
import com.jhj.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Inject
	private NoticeDAO noticeDAO;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePage(noticeDAO.totalCount(pager));
		return noticeDAO.list(pager);
	}

	@Override
	public BoardDTO select(int num) throws Exception {
		return noticeDAO.select(num);
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		return noticeDAO.insert(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return noticeDAO.update(boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		return noticeDAO.delete(num);
	}
}
