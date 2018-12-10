package com.jhj.util;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jhj.s4.AbstractTestCase;

public class PagerTest extends AbstractTestCase{
	
	private static Pager pager;
	
	@BeforeClass
	public static void setData() {
		pager = new Pager();
	}

	@Test
	public void test() {
		pager.makeRow();
//		assertEquals(1, pager.getCurPage());
//		assertEquals(5, pager.getPerBlock());
//		assertEquals(10, pager.getPerPage());
//		assertEquals("title", pager.getKind());
//		assertEquals("", pager.getSearch());
		assertEquals(10, pager.getLastRow());
	}

}
