package com.jhj.s4;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebParam.Mode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jhj.board.BoardDTO;
import com.jhj.board.qna.QnaDTO;
import com.jhj.board.qna.QnaService;
import com.jhj.util.Pager;

@Controller
@RequestMapping(value = "/qna/**")
public class QnaController {

	@Inject
	private QnaService qnaService;

	@RequestMapping(value = "qnaList")
	public ModelAndView list(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = qnaService.list(pager);
		mv.addObject("board", "qna");
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		return mv;
	}

	@RequestMapping(value = "qnaSelect")
	public ModelAndView select(int num, RedirectAttributes rd) throws Exception {
		BoardDTO boardDTO = qnaService.select(num);
		ModelAndView mv = new ModelAndView();

		if (boardDTO != null) {
			mv.addObject("boardDTO", boardDTO);
			mv.setViewName("board/boardSelect");
		} else {
			rd.addFlashAttribute("result", "존제하지 않는 글입니다");
			mv.setViewName("redirect:./qnaList");
		}
		mv.addObject("board", "qna");
		return mv;
	}

	@RequestMapping(value = "qnaWrite")
	public String Write(Model model) {
		model.addAttribute("board", "qna");
		return "board/boardWrite";
	}

	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public String Write(QnaDTO qnaDTO, RedirectAttributes rd) throws Exception {
		rd.addFlashAttribute("result", "작성 실패");

		int result = qnaService.insert(qnaDTO);
		if (result > 0) {
			rd.addFlashAttribute("result", "작성되었습니다");
		}

		return "redirect:./qnaList";
	}

	@RequestMapping(value = "qnaUpdate")
	public String Update(Model model, int num) throws Exception {
		BoardDTO boardDTO = qnaService.select(num);
		model.addAttribute("board", "qna");
		model.addAttribute("boardDTO", boardDTO);
		return "board/boardUpdate";
	}

	@RequestMapping(value = "qnaUpdate", method = RequestMethod.POST)
	public String Update(QnaDTO qnaDTO, RedirectAttributes rd) throws Exception {
		rd.addFlashAttribute("result", "수정 실패");

		int result = qnaService.update(qnaDTO);
		if (result > 0) {
			rd.addFlashAttribute("result", "수정되었습니다");
		}

		return "redirect:./qnaSelect?num=" + qnaDTO.getNum();
	}

	@RequestMapping(value = "qnaDelete", method = RequestMethod.POST)
	public String Delete(int num, RedirectAttributes rd) throws Exception {
		rd.addFlashAttribute("result", "삭제 실패");
		String path = "redirect:./qnaSelect";
		
		int result = qnaService.delete(num);
		if (result > 0) {
			rd.addFlashAttribute("result", "삭제되었습니다");
			path = "redirect:./qnaList";
		}
		
		return path;
	}

	@RequestMapping(value = "qnaReply")
	public String reply(int num, Model model) throws Exception {
		QnaDTO qnaDTO = (QnaDTO) qnaService.select(num);
		model.addAttribute("boardDTO", qnaDTO);
		model.addAttribute("board", "qna");
		return "board/boardReply";
	}

	@RequestMapping(value = "qnaReply", method = RequestMethod.POST)
	public String reply(QnaDTO qnaDTO, RedirectAttributes rd) throws Exception {
		rd.addFlashAttribute("board", "qna");
		rd.addFlashAttribute("boardDTO", qnaDTO);
		rd.addFlashAttribute("result", "작성 실패");
		int result = qnaService.reply(qnaDTO);
		if (result > 0) {
			rd.addFlashAttribute("result", "답글이 작성되었습니다");
		}
		return "redirect:./qnaList";
	}
}
