package com.iu.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class TestMemberRepository {
	
	
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MemberFilesRepository memberFilesRepository;
	
	
	//@Test
	void test() throws Exception {
		//Long count = memberRepository.count();
		//boolean check= memberRepository.existsById("iu");
		//List<MemberVO> ar = memberRepository.findAll();
//		Optional<MemberVO> opt = memberRepository.findById("iu1");
//		
//		if(opt.isPresent()) {
//			MemberVO memberVO = opt.get();
//			System.out.println(memberVO.getEmail());
//		}else {
//			System.out.println("Nodate");
//		}
		//System.out.println(check);
		
		//for (MemberVO memberVO:ar) {
			//System.out.println(memberVO.getId());
		//}
		
//		MemberVO memberVO = new MemberVO();
//		memberVO.setId("aaa");
//		memberVO.setPw("aaa");
//		memberVO.setEmail("Testname");
//		memberVO.setName("aaa");
//		memberRepository.save(memberVO);
		
		
//		Long count =memberFilesRepository.count();
//		System.out.println(count);
//		
//		List<MemberFilesVO> ar =  memberFilesRepository.findAll();
//		for(MemberFilesVO memberFilesVO : ar) {
//			System.out.println(memberFilesVO.getId());
//		}
		
		
//		List<MemberFilesVO> ar2 = memberFilesRepository.findByIdEquals("iu4");
//		for(MemberFilesVO memberFilesVO : ar2) {
//			System.out.println(memberFilesVO.getId());
//			System.out.println(memberFilesVO.getOname());
//		}
		
//		List<MemberVO> ar = memberRepository.findByIdAndPw("iu1", "iu1");
//		for(MemberVO memberVO : ar) {
//			System.out.println(memberVO.getId());
//			System.out.println(memberVO.getEmail());
//			System.out.println(memberVO.getName());
//		}
		
//		MemberVO memberVO = new MemberVO();
//		memberVO.setId("jpa2");
//		memberVO.setPw("jpa");
//		memberVO.setEmail("jpa@jpa");
//		memberVO.setName("jpa");
//		memberVO = memberRepository.save(memberVO);
//		System.out.println(memberVO);
//		System.out.println(memberVO.getId());
		
	}
	//@Test
	void SelectTest() throws Exception{
		Optional<MemberVO> opt = memberRepository.findById("iu4");
		MemberVO memberVO = opt.get();
		System.out.println(memberVO.getName());
		System.out.println(memberVO.getId());
		System.out.println(memberVO.getMemberFilesVO().getFname());
		System.out.println(memberVO.getMemberFilesVO().getMemberVO().getId());
	}
	
	//@Test
	void filesselectTest() throws Exception{
		Optional<MemberFilesVO> opt = memberFilesRepository.findById(3);
		MemberFilesVO memberFilesVO = opt.get();
		System.out.println(memberFilesVO.getMemberVO().getId());
		System.out.println(memberFilesVO.getMemberVO().getName());
	}
	//@Test
	void inserTest() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("OnetoOneJpa");
		memberVO.setPw("jpa");
		memberVO.setEmail("jpa");
		memberVO.setName("jpa");
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setOname("jpa-oname");
		memberFilesVO.setFname("jpa-fname");
		
		//memberVO와 memberFilesVO에 각각의 값 세팅 후 set으로 넣어줌
		memberVO.setMemberFilesVO(memberFilesVO);
		memberFilesVO.setMemberVO(memberVO);
		
		//memberFiles는 FK위반으로 에러발생함
		memberRepository.save(memberVO);
		
	}
	
	
	//@Test
	void deleteTest() {
		memberRepository.deleteById("");
	}
	
	@Test
	void updateTest() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("iu4");
		memberVO.setPw("iu4");
		memberVO.setName("iu4");
		memberVO.setEmail("iu4");
		
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setFname("rename");
		memberFilesVO.setOname("rename");
		memberFilesVO.setFnum(3);
		
		memberVO.setMemberFilesVO(memberFilesVO);
		memberFilesVO.setMemberVO(memberVO);
		
		memberRepository.save(memberVO);
	}
}
