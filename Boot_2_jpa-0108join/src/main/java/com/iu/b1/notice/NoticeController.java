package com.iu.b1.notice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.b1.Board.BoardVO;

@Controller
@RequestMapping("notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("noticeList")
	public ModelAndView noticeList(ModelAndView mv) throws Exception{
		List<BoardVO> ar = noticeService.noticeList();
		mv.addObject("list", ar);
		return mv;
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView noticeSelect(ModelAndView mv, int num) throws Exception{
		Optional<NoticeVO> opt = noticeService.noticeSelect(num);
		
		if(opt.isPresent()) {
			mv.addObject("noticeVO", opt.get());
			mv.setViewName("notice/noticeSelect");
		}else {
			mv.addObject("message", "존재하지 않는 글입니다.");
			mv.addObject("path", "../notice/noticeList");
			mv.setViewName("common/commonResult");
		}
		return mv;
	}
}
