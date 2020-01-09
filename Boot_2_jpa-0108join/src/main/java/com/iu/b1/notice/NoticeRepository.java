package com.iu.b1.notice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.iu.b1.Board.BoardVO;

public interface NoticeRepository extends JpaRepository<NoticeVO, Integer>{
	
//	public List<BoardVO> findByNumGreaterThanOrderByNumDesc(Integer num) throws Exception;
	
	public Page<BoardVO> findByNumGreaterThanOrderByNumDesc(Integer num, Pageable pageable) throws Exception;

	
}
