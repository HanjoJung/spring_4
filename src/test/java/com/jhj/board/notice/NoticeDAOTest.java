package com.jhj.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jhj.board.BoardDTO;
import com.jhj.s4.AbstractTestCase;
import com.jhj.util.Pager;

public class NoticeDAOTest extends AbstractTestCase {

	@Inject
	private NoticeDAO noticeDAO;

	@BeforeClass
	public static void start() {
		System.out.println("start Test");
	}

	@AfterClass
	public static void finish() {
		System.out.println("fisish Test");
	}

	@Before
	public void before() {
		System.out.println("before Test");
	}

	@After
	public void after() {
		System.out.println("after Test");
	}

	@Test
	public void deleteTest() {
		System.out.println("delete Test");
//		try {
//			int result = noticeDAO.delete(14);
//			assertEquals(1, result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	@Test
	public void updateTest() {
		System.out.println("update Test");
		BoardDTO boardDTO = null;
		try {
//			int result = noticeDAO.update(boardDTO);
//			assertEquals(1, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertTest() {
		System.out.println("insert Test");
		BoardDTO boardDTO = null;
		try {
//			int result = noticeDAO.insert(boardDTO);
//			assertEquals(1, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		System.out.println("list Test");
		try {
			Pager pager = new Pager();
			pager.makeRow();;
			List<BoardDTO> ar = noticeDAO.list(pager);
			assertNotEquals(0, ar.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
