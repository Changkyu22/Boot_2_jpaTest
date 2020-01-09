package com.iu.b1.member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberVO, String>{
	
	public List<MemberVO> findByIdAndPw(String id, String pw) throws Exception;
	
}
