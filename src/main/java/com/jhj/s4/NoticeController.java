package com.jhj.s4;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jhj.board.BoardDTO;
import com.jhj.board.notice.NoticeDTO;
import com.jhj.board.notice.NoticeService;
import com.jhj.util.Pager;

@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {
	
	@Inject
	private NoticeService noticeService;

	@RequestMapping(value = "noticeList")
	public ModelAndView list(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = noticeService.list(pager);
		mv.addObject("board", "notice");
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		return mv;
	}

	@RequestMapping(value = "noticeSelect")
	public ModelAndView select(int num) throws Exception {
		BoardDTO boardDTO = noticeService.select(num);
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardDTO", boardDTO);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardSelect");
		return mv;
	}

	@RequestMapping(value = "noticeWrite")
	public ModelAndView Write() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "notice");
		mv.setViewName("board/boardWrite");
		return mv;
	}

	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public String Write(NoticeDTO noticeDTO, RedirectAttributes rd) {
		String path = "redirect:./noticeList";
		rd.addFlashAttribute("result", "작성 실패");
		try {
			int result = noticeService.insert(noticeDTO);
			if (result > 0) {
				rd.addFlashAttribute("result", "작성되었습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

	@RequestMapping(value = "noticeUpdate")
	public ModelAndView Update(int num) throws Exception {
		BoardDTO boardDTO = noticeService.select(num);
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "notice");
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("board/boardUpdate");
		return mv;
	}

	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public String Update(NoticeDTO noticeDTO, RedirectAttributes rd) {
		String path = "redirect:./noticeSelect?num=" + noticeDTO.getNum();
		rd.addFlashAttribute("result", "수정 실패");
		try {
			int result = noticeService.update(noticeDTO);
			if (result > 0) {
				rd.addFlashAttribute("result", "수정되었습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path; 
	}

	@RequestMapping(value = "noticeDelete", method = RequestMethod.POST)
	public String Delete(int num, RedirectAttributes rd) {
		String path = "redirect:./noticeList";
		rd.addFlashAttribute("result", "삭제 실패");
		try {
			int result = noticeService.delete(num);
			if (result > 0) {
				rd.addFlashAttribute("result", "삭제되었습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
}
