package com.iu.b1.notice;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.b1.Board.BoardVO;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	public List<BoardVO> noticeList() throws Exception{
		return noticeRepository.findByNumGreaterThanOrderByNumDesc(0);
	} 
	
	
	@Transactional
	public Optional<NoticeVO> noticeSelect(int num) throws Exception{
		return noticeRepository.findById(num);
	}
}
