package com.iu.b1.notice;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.b1.Board.BoardVO;

@Controller
@RequestMapping("notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute(name = "board")
	public String getBoard() {
		return "notice";
	}
	
	@ModelAttribute(name = "noticeVO")
	public NoticeVO getNotice() {
		return new NoticeVO();
	}
	
	@PostMapping("noticeWrite")
	public ModelAndView noticeWrite(@Valid NoticeVO noticeVO, BindingResult bindingResult, MultipartFile [] files)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			mv.setViewName("notice/noticeList");
			mv.addObject("noticeVO", noticeVO);
		}else {
			noticeVO = noticeService.noticeWrite(noticeVO, files);
			
			String msg ="등록 실패";
			if(noticeVO != null) {
				msg="등록 성공";
			}
			String path = "../";
			mv.addObject("message", msg);
			mv.addObject("path", path);
			mv.setViewName("common/commonResult");
		}
		return mv;
	}
	
	@GetMapping("noticeWrite")
	public void noticeWrite()throws Exception{
		
	}
	
	@GetMapping("noticeList")
	public ModelAndView noticeList(ModelAndView mv, @PageableDefault(page=0, size=10, sort="num") Pageable pageable) throws Exception{
//		Pageable pageable2 = PageRequest.of(0, 10, Sort.Direction.DESC, "num");
		
		Page<BoardVO> ar = noticeService.noticeList(pageable);
		mv.addObject("list", ar);
		return mv;
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView noticeSelect(ModelAndView mv, Integer num) throws Exception{
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
