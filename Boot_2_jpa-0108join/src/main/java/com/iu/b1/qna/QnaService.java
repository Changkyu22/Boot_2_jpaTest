package com.iu.b1.qna;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b1.notice.NoticeRepository;
import com.iu.b1.util.FilePathGe;
import com.iu.b1.util.FileSaver;

@Service
@Transactional
public class QnaService {
	
	@Autowired
	private QnaRepository qnaRepository;
	@Autowired
	private FilePathGe filePathGe;
	@Autowired
	private FileSaver fileSaver;
	
	public QnaVO qnaWrite(QnaVO qnaVO, MultipartFile [] files) throws Exception{
		File file = filePathGe.getUseClassPathResource("qna");
		
		List<QnaFilesVO> ar = new ArrayList<QnaFilesVO>();
		for(int i=1; i<files.length; i++) {
			if(files[i] != null && !files[i].getOriginalFilename().equals("")) {
				QnaFilesVO qnaFilesVO = new QnaFilesVO();
				String fileName = fileSaver.save(files[i], file);
				qnaFilesVO.setFname(fileName);
				qnaFilesVO.setOname(files[i].getOriginalFilename());
				qnaFilesVO.setQnaVO(qnaVO);
				ar.add(qnaFilesVO);
			}
			qnaVO.setQnaFilesVOs(ar);
		}
		return qnaRepository.save(qnaVO);
	}

}
