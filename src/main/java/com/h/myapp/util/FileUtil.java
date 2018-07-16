package com.h.myapp.util;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	public static String save(String savePath, String fileName, MultipartFile file) throws Exception {
		File targetFile = new File(savePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		File f=new File(savePath+fileName);
		file.transferTo(f);

		return "success";
	}

}
