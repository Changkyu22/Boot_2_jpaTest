package com.iu.b1.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	
	public String save(MultipartFile files, File file) throws Exception{
		
		String fileName = UUID.randomUUID().toString()+"_"+files.getOriginalFilename();
		
		file = new File(file, fileName);
		
		files.transferTo(file);
		
		return fileName;
	}
	
}
