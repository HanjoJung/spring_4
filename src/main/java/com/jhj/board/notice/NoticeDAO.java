package com.jhj.board.notice;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jhj.board.BoardDAO;
import com.jhj.board.BoardDTO;
import com.jhj.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	private String namespace = "noticeMapper.";

	@Override
	public int totalCount(Pager pager) throws Exception {
//		Connection con = DBConnector.getConnect();
//		String sql = "select count(num) from notice where " + pager.getKind() + " like ?";
//
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, "%"+pager.getSearch()+"%");
//		ResultSet rs = st.executeQuery();
//		
//		rs.next();
//		int result = rs.getInt(1);
//
//		DBConnector.disConnect(rs, st, con);
		return sqlSession.selectOne(namespace+"totalCount", pager);
	}

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
//		Connection con = DBConnector.getConnect();
//		List<BoardDTO> ar = new ArrayList<BoardDTO>();
//		String sql = "select * from " + "(select rownum r, n.* from " + "(select * from notice where " + pager.getKind()
//				+ " like ? order by num desc) n ) " + "where r between ? and ? ";
//
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, "%" + pager.getSearch() + "%");
//		st.setInt(2, pager.getStartRow());
//		st.setInt(3, pager.getLastRow());
//
//		ResultSet rs = st.executeQuery();
//		while (rs.next()) {
//			BoardDTO boardDTO = new BoardDTO();
//			boardDTO.setNum(rs.getInt("num"));
//			boardDTO.setTitle(rs.getString("title"));
//			boardDTO.setWriter(rs.getString("writer"));
//			boardDTO.setContents(rs.getString("contents"));
//			boardDTO.setReg_date(rs.getDate("reg_date"));
//			boardDTO.setHit(rs.getInt("hit"));
//			ar.add(boardDTO);
//		}
//
//		DBConnector.disConnect(rs, st, con);
		return sqlSession.selectList(namespace+"selectList", pager);
	}

	@Override
	public BoardDTO select(int num) throws Exception {
//		Connection con = DBConnector.getConnect();
//		NoticeDTO noticeDTO = null;
//		String sql = "select * from notice where num=?";
//
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setInt(1, num);
//		ResultSet rs = st.executeQuery();
//		if (rs.next()) {
//			noticeDTO = new NoticeDTO();
//			noticeDTO.setNum(rs.getInt("num"));
//			noticeDTO.setTitle(rs.getString("title"));
//			noticeDTO.setWriter(rs.getString("writer"));
//			noticeDTO.setContents(rs.getString("contents"));
//			noticeDTO.setReg_date(rs.getDate("reg_date"));
//			noticeDTO.setHit(rs.getInt("hit"));
//		}
//
//		DBConnector.disConnect(rs, st, con);
		return sqlSession.selectOne(namespace+"selectOne", num);
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
//		Connection con = DBConnector.getConnect();
//		String sql = "insert into notice values(notice_seq.nextval,?,?,?,sysdate,0)";
//
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, boardDTO.getTitle());
//		st.setString(2, boardDTO.getWriter());
//		st.setString(3, boardDTO.getContents());
//		int result = st.executeUpdate();
//
//		DBConnector.disConnect(st, con);
		return sqlSession.insert(namespace+"insert", boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
//		Connection con = DBConnector.getConnect();
//		String sql = "update notice set title=?, contents=? where num=?";
//
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, boardDTO.getTitle());
//		st.setString(2, boardDTO.getContents());
//		st.setInt(3, boardDTO.getNum());
//		int result = st.executeUpdate();
//
//		DBConnector.disConnect(st, con);
		return sqlSession.update(namespace+"update", boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
//		Connection con = DBConnector.getConnect();
//		String sql = "delete notice where num=?";
//
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setInt(1, num);
//		int result = st.executeUpdate();
//
//		DBConnector.disConnect(st, con);
		return sqlSession.delete(namespace+"delete", num);
	}

}
