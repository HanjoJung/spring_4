package com.jhj.board;

import java.util.List;

import com.jhj.util.Pager;

public interface BoardDAO {
	
	public List<BoardDTO> list(Pager pager) throws Exception;

	public BoardDTO select(int num) throws Exception;

	public int insert(BoardDTO boardDTO) throws Exception;

	public int update(BoardDTO boardDTO) throws Exception;

	public int delete(int num) throws Exception;
	
	public int totalCount(Pager pager) throws Exception;

}