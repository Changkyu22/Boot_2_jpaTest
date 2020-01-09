package com.iu.b1.notice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iu.b1.Board.BoardVO;

public interface NoticeRepository extends JpaRepository<NoticeVO, Integer>{
	
	public List<BoardVO> findByNumGreaterThanOrderByNumDesc(Integer num) throws Exception;
	
}
