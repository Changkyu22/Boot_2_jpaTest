package com.iu.b1.qna;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute(name = "board")
	public String getBoard() {
		return "qna";
	}
	
	@ModelAttribute(name="qnaVO")
	public QnaVO getQna() {
		return new QnaVO();
	}
	
	@PostMapping("qnaWrite")
	public ModelAndView qnaWrite(@Valid QnaVO qnaVO, BindingResult bindingResult, MultipartFile [] files)throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			mv.setViewName("qna/qnaList");
			mv.addObject("qnaVO", qnaVO);
		}else {
			
		}
		return mv;
		
	}
	
	@GetMapping("qnaWrite")
	public void qnaWrite() throws Exception{
		
	}

}
