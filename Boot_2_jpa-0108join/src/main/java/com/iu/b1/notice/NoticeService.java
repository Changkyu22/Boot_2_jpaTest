package com.iu.b1.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b1.Board.BoardVO;
import com.iu.b1.member.MemberFilesVO;
import com.iu.b1.util.FilePathGe;
import com.iu.b1.util.FileSaver;

@Service
@Transactional
public class NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepository;
	@Autowired
	private FilePathGe filePathGe;
	@Autowired
	private FileSaver fileSaver;
	
	public Page<BoardVO> noticeList(Pageable pageable) throws Exception{
		Page<BoardVO> page = noticeRepository.findByNumGreaterThanOrderByNumDesc(0, pageable);
		System.out.println(page.getTotalPages());
		return page;
	} 
	
	
	public Optional<NoticeVO> noticeSelect(int num) throws Exception{
		return noticeRepository.findById(num);
	}
	
	public NoticeVO noticeWrite(NoticeVO noticeVO, MultipartFile [] files)throws Exception{
		File file = filePathGe.getUseClassPathResource("notice");
		
//		---------------- 파일의 유무를 검증하는 코드 -------------------
//		
//		List<NoticeFilesVO> noticeFilesVOs = null;
//		boolean check = false;
//		if(files.length>0) {
//			for(MultipartFile multipartFile : files) {
//				if(multipartFile.getSize()>0) {
//					check = true;
//					break;
//				}
//			}// for 끝
//			if(files.length > 0) {
//				for(int i=1; i<files.length; i++) {
//					if(files[i].getOriginalFilename() != "") {
//						NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
//						File file2 = filePathGe.getUseClassPathResource("notice");
//						String fileName = fileSaver.save(files[i], file2);
//						noticeFilesVO.setFname(fileName);
//						noticeFilesVO.setOname(files[i].getOriginalFilename());
//						noticeFilesVOs.add(noticeFilesVO);
//						noticeFilesVO.setNoticeVO(noticeVO);
//					}
//					noticeVO.setNoticeFilesVOs(noticeFilesVOs);
//				}
//			}
//		}
//		return noticeRepository.save(noticeVO);
//	}
//}
		
		List<NoticeFilesVO> ar = new ArrayList<NoticeFilesVO>();
		for(int i=1; i<files.length; i++) {
			if(files[i] != null && !files[i].getOriginalFilename().equals("")) {
				NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
				String fileName = fileSaver.save(files[i], file);
				noticeFilesVO.setFname(fileName);
				noticeFilesVO.setOname(files[i].getOriginalFilename());
				noticeFilesVO.setNoticeVO(noticeVO);
				ar.add(noticeFilesVO);
			}
			noticeVO.setNoticeFilesVOs(ar);
		}
		return noticeRepository.save(noticeVO); 
	}
}
