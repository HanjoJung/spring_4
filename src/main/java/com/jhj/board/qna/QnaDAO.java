package com.jhj.board.qna;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jhj.board.BoardDAO;
import com.jhj.board.BoardDTO;
import com.jhj.util.Pager;

@Repository
public class QnaDAO implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE = "qnaMapper.";

	@Override
	public int totalCount(Pager pager) throws Exception {
//		Connection con = DBConnector.getConnect();
//		String sql = "select count(num) from qna where " + pager.getKind() + "= ?";
//
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, "%" + pager.getSearch() + "%");
//		ResultSet rs = st.executeQuery();
//
//		rs.next();
//		int result = rs.getInt(1);
//
//		DBConnector.disConnect(rs, st, con);
		return sqlSession.selectOne(NAMESPACE + "totalCount", pager);
	}

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
//		Connection con = DBConnector.getConnect();
//		List<BoardDTO> ar = new ArrayList<BoardDTO>();
//		String sql = "select * from "
//				+ "(select rownum r, n.* from "
//				+ "(select * from qna where " + pager.getKind() + " like ? order by ref desc, step asc ) n ) "
//				+ "where r between ? and ?";
//
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, "%" + pager.getSearch() + "%");
//		st.setInt(2, pager.getStartRow());
//		st.setInt(3, pager.getLastRow());
//
//		ResultSet rs = st.executeQuery();
//		while (rs.next()) {
//			BoardReplyDTO boardReplyDTO = new BoardReplyDTO();
//			boardReplyDTO.setNum(rs.getInt("num"));
//			boardReplyDTO.setTitle(rs.getString("title"));
//			boardReplyDTO.setWriter(rs.getString("writer"));
//			boardReplyDTO.setContents(rs.getString("contents"));
//			boardReplyDTO.setReg_date(rs.getDate("reg_date"));
//			boardReplyDTO.setHit(rs.getInt("hit"));
//			boardReplyDTO.setRef(rs.getInt("ref"));
//			boardReplyDTO.setStep(rs.getInt("step"));
//			boardReplyDTO.setDepth(rs.getInt("depth"));
//			ar.add(boardReplyDTO);
//		}
//		
//		DBConnector.disConnect(rs, st, con);
		return sqlSession.selectList(NAMESPACE + "selectList", pager);
	}

	@Override
	public BoardDTO select(int num) throws Exception {
//		Connection con = DBConnector.getConnect();
//		QnaDTO qnaDTO = null;
//		String sql = "select * from qna where num=?";
//
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setInt(1, num);
//		ResultSet rs = st.executeQuery();
//		if (rs.next()) {
//			qnaDTO = new QnaDTO();
//			qnaDTO.setNum(rs.getInt("num"));
//			qnaDTO.setTitle(rs.getString("title"));
//			qnaDTO.setWriter(rs.getString("writer"));
//			qnaDTO.setContents(rs.getString("contents"));
//			qnaDTO.setReg_date(rs.getDate("reg_date"));
//			qnaDTO.setHit(rs.getInt("hit"));
//		}
//
//		DBConnector.disConnect(rs, st, con);
		return sqlSession.selectOne(NAMESPACE + "selectOne", num);
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
//		Connection con = DBConnector.getConnect();
//		String sql = "insert into qna values(qna_seq.nextval,?,?,?,sysdate,0,qna_seq.currval, 0, 0)";
//
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, boardDTO.getTitle());
//		st.setString(2, boardDTO.getWriter());
//		st.setString(3, boardDTO.getContents());
//		int result = st.executeUpdate();
//
//		DBConnector.disConnect(st, con);
		return sqlSession.insert(NAMESPACE + "insert", boardDTO);
	}

	public int reply(QnaDTO qnaDTO) throws Exception {
//		Connection con = DBConnector.getConnect();
//		String sql = "insert into qna values(qna_seq.nextval,?,?,?,sysdate,0,?, ?, ?)";
//
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, qnaDTO.getTitle());
//		st.setString(2, qnaDTO.getWriter());
//		st.setString(3, qnaDTO.getContents());
//		st.setInt(4, qnaDTO.getRef());
//		st.setInt(5, qnaDTO.getStep() + 1);
//		st.setInt(6, qnaDTO.getDepth() + 1);
//		int result = st.executeUpdate();
//
//		DBConnector.disConnect(st, con);
		return sqlSession.insert(NAMESPACE + "reply", qnaDTO);
	}

	public int replyUpdate(QnaDTO qnaDTO) throws Exception {
//		Connection con = DBConnector.getConnect();
//		String sql = "update qna set step = step + 1 where ref = ? and step > ?";
//
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setInt(1, qnaDTO.getRef());
//		st.setInt(2, qnaDTO.getStep());
//		int result = st.executeUpdate();
//		System.out.println(result);
//
//		DBConnector.disConnect(st, con);
		return sqlSession.update(NAMESPACE+"replyUpdate", qnaDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
//		Connection con = DBConnector.getConnect();
//		String sql = "update qna set title=?, contents=? where num=?";
//
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, boardDTO.getTitle());
//		st.setString(2, boardDTO.getContents());
//		st.setInt(3, boardDTO.getNum());
//		int result = st.executeUpdate();
//
//		DBConnector.disConnect(st, con);
		return sqlSession.update(NAMESPACE + "update", boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
//		Connection con = DBConnector.getConnect();
//		String sql = "delete qna where num=?";
//
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setInt(1, num);
//		int result = st.executeUpdate();
//
//		DBConnector.disConnect(st, con);
		return sqlSession.delete(NAMESPACE + "delete", num);
	}

}
