package com.iu.b1.qna;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QnaRepository extends JpaRepository<QnaVO, Integer>{
	
	List<QnaVO> findByNumGreaterThan(int num)throws Exception;
	
	@Query("select q from QnaVO q order by q.ref desc, q.step asc")
	List<QnaVO> findQna()throws Exception;
	
	@Query("select q from QnaVO q where num=?1 writer=?2")
	QnaVO finQnaVO(int num, String writer)throws Exception;

}
