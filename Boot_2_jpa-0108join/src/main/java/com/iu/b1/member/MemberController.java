package com.iu.b1.member;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("memberUpdate")
	public ModelAndView memberUpdate(MemberVO memberVO, ModelAndView mv, HttpSession session) throws Exception{
		memberVO = (MemberVO)session.getAttribute("memberVO");
		mv.addObject("memberVO", memberVO);
		mv.setViewName("member/memberUpdate");
		
		return mv;
	}
	
	@PostMapping("memberUpdate")
	public ModelAndView memberUpdate(MemberVO memberVO, HttpSession session,MultipartFile files) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO2 = (MemberVO)session.getAttribute("memberVO");
		memberVO.setPw(memberVO2.getPw());
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setFnum(memberVO2.getMemberFilesVO().getFnum());
		memberVO.setMemberFilesVO(memberFilesVO);
		memberVO = memberService.memberUpdate(memberVO, files);
		session.setAttribute("memberVO", memberVO);
		mv.setViewName("member/Mypage");
		return mv;
	}
	
	@RequestMapping("IdCheck")
	public ModelAndView IdCheck(MemberVO memberVO,ModelAndView mv) throws Exception{
		String result = "사용가능한 아이디";
		String id = memberVO.getId();
		Optional<MemberVO> opt = memberService.memberIdCheck(memberVO);
		if(opt.isPresent()) {
			result = "중복된 아이디";
			mv.addObject("result", 1);
		}else {
			mv.addObject("result", 0);
		}
		System.out.println(id);
		System.out.println(result);
		
		mv.setViewName("common/IdcheckResult");
		return mv;
	}
	
	@GetMapping("memberJoin")
	public String memberJoin(Model model) throws Exception{
		model.addAttribute("memberVO", new MemberVO());
		return "member/memberJoin";
	}
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(@Valid MemberVO memberVO,BindingResult bindingResult, MultipartFile files) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			mv.setViewName("member/memberJoin");
			mv.addObject("memberVO", memberVO);
		}else {
			//int result = memberService.memberJoin(memberVO, files);
			memberVO = memberService.memberJoin(memberVO, files);
			
			String msg = "가입 실패";
			if(memberVO != null )
				msg = "가입 성공";
		
			String path = "../";
			mv.addObject("message", msg);
			mv.addObject("path", path);
			mv.setViewName("common/commonResult");
		}
		return mv;
		
	}
	
	@GetMapping("memberLogin")
	public String memberLogin() throws Exception{
		return "member/memberLogin";
	}
	
	@PostMapping("memberLogin")
	public ModelAndView memberLogin(MemberVO memberVO, ModelAndView mv, HttpSession session) throws Exception{
		
		List<MemberVO> ar = memberService.memberLogin(memberVO);
		String msg ="로그인 실패";
		String path = "../member/memberLogin";
		if(!ar.isEmpty()) {
			msg = "로그인 성공";
			path = "../";
			session.setAttribute("memberVO", ar.get(0));
		}
		mv.setViewName("common/commonResult");
		mv.addObject("message", msg);
		mv.addObject("path", path);
		
		return mv;
	}
	
//	@PostMapping("memberLogin")
//	public ModelAndView memberLogin(MemberVO memberVO, ModelAndView mv, HttpSession session) throws Exception{
//		memberVO = memberService.memberLogin(memberVO);
//		
//		String msg = "아이디 혹은 비밀번호가 일치하지 않습니다";
//		String path = "../member/memberLogin";
//		if(memberVO != null) {
//		
//			msg = "로그인 성공";
//			path = "../";
//			session.setAttribute("memberVO", memberVO);
//		}
//		
//		mv.addObject("message", msg);
//		mv.addObject("path", path);
//		mv.setViewName("common/commonResult");
//		return mv;
//	}
	
	@GetMapping("memberLogOut")
	public ModelAndView memberLogOut(MemberVO memberVO, ModelAndView mv, HttpSession session) throws Exception{
		session.invalidate();
		mv.addObject("message", "로그아웃 되었습니다.");
		mv.addObject("path", "../");
		mv.setViewName("common/commonResult");
		return mv;
	}
	
	
	
	@GetMapping("Mypage")
	public ModelAndView Mypage(HttpSession session, ModelAndView mv) throws Exception{
		
		//MemberVO memberVO = new MemberVO();
		//memberVO =(MemberVO)session.getAttribute("memberVO");
		//memberVO = memberService.Mypage(memberVO);
		//List<MemberFilesVO> ar = memberService.Mypage(memberVO);
		//memberVO = memberService.memberLogin(memberVO).get(0);
		//mv.addObject("member", memberVO);
		//mv.addObject("memberfiles", ar);
		
		mv.setViewName("member/Mypage");
		
		return mv;
	}
	
	
//	@GetMapping("memberFileDown")
//	public ModelAndView memberFileDown(MemberFilesVO memberFilesVO) throws Exception{
//		ModelAndView mv = new ModelAndView();
//		memberFilesVO = memberService.memberFilesSelect(memberFilesVO);
//		
//		if(memberFilesVO != null) {
//			mv.addObject("memberfiles", memberFilesVO);
//			mv.addObject("path", "upload");
//			mv.setViewName("fileDown");
//			
//		}else {
//			mv.addObject("message", "존재하지 않는 파일입니다.");
//			mv.addObject("path", "../member/Mypage");
//			mv.setViewName("common/commonResult");
//		}
//		
//		return mv;
//	}
	
}
