package com.jhj.member;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE = "memberMapper."; 

	public void join() throws Exception {

	}

	public void checkId() throws Exception {

	}

	public void select() throws Exception {

	}

	public void update() throws Exception {

	}

	public void delete() throws Exception {

	}
}
