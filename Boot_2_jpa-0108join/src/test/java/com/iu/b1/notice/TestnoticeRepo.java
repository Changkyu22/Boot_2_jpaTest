package com.iu.b1.notice;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Transactional
class TestnoticeRepo {

	@Autowired
	private NoticeRepository noticeRepository;
	

	@Test
	void test() throws Exception{
		NoticeVO noticeVO = noticeRepository.findById(74).get();
		System.out.println();
	}

}
