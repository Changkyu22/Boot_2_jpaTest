package com.iu.b1.member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberFilesRepository extends JpaRepository<MemberFilesVO, Integer>{
	
	//public List<MemberFilesVO> findByIdEquals(String id) throws Exception;
	
	
}
