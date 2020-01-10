package com.iu.b1.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
class QnaRepositoryTest {

	@Resource
	private QnaRepository qnaRepository;
	
	@Test
	void selectOneTest()throws Exception {
		QnaVO qnaVO = qnaRepository.finQnaVO(2, "ck1");
		System.out.println(qnaVO.getTitle());
	}
	
//	@Test
	public void SelectTest()throws Exception{
//		Pageable pageable = PageRequest.of(0, 10, Sort.by("ref").descending().and(Sort.by("step").ascending()));
		List<QnaVO> ar = qnaRepository.findQna();
		for (QnaVO qnaVO : ar) {
			System.out.println(qnaVO.getTitle());
			for (QnaFilesVO qnaFilesVO : qnaVO.getQnaFilesVOs()) {
				System.out.println(qnaFilesVO.getFname());
			}
			
		}
	}
	
	
	//@Test
	void test()throws Exception {
		QnaVO qnaVO = new QnaVO();
		qnaVO.setTitle("ck2");
		qnaVO.setWriter("ck2");
		qnaVO.setContents("ck2");
		
		List<QnaFilesVO> ar = new ArrayList<QnaFilesVO>();
		
		QnaFilesVO qnaFilesVO = new QnaFilesVO();
		qnaFilesVO.setFname("f1.jpg");
		qnaFilesVO.setOname("o2.jpg");
		qnaFilesVO.setQnaVO(qnaVO);
		ar.add(qnaFilesVO);
		
		qnaFilesVO = new QnaFilesVO();
		qnaFilesVO.setFname("f1.jpg");
		qnaFilesVO.setOname("o2.jpg");
		qnaFilesVO.setQnaVO(qnaVO);
		ar.add(qnaFilesVO);
		
		qnaVO.setQnaFilesVOs(ar);
		
		qnaVO = qnaRepository.save(qnaVO);
		qnaVO.setRef(qnaVO.getNum());
		qnaVO = qnaRepository.save(qnaVO);
		System.out.println(qnaVO.getNum());
		System.out.println(qnaVO.getTitle());
	}

}
