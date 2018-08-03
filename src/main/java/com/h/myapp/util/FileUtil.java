package com.h.myapp.util;

import java.io.File;

import javax.servlet.http.Part;

public class FileUtil {

	public static String save(String savePath, String fileName, Part file) throws Exception {
		File targetFile = new File(savePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		file.write((savePath+fileName));

		return "success";
	}

}
