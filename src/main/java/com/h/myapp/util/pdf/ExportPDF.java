package com.h.myapp.util.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.xhtmlrenderer.pdf.ITextRenderer;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

@Component
public class ExportPDF {
	@Value("${my.savePath}")
	private static String savePath;
	private static Configuration cfg;
	
	static {
		cfg = new Configuration(Configuration.VERSION_2_3_22);
		try {
			cfg.setDirectoryForTemplateLoading(new File("d:/savePath/template"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	}
	
	
	public static void main(String[] args) throws Exception {
		
		Map<String, Object> root = new HashMap<>();
		// Put string ``user'' into the root
		root.put("user", "Big Joe");
		// Create the hash for ``latestProduct''
		Map<String, Object> latest = new HashMap<>();
		// and put it into the root
		root.put("latestProduct", latest);
		// put ``url'' and ``name'' into latest
		latest.put("url", "products/greenmouse.html");
		latest.put("name", "green mouse");
		
		Template temp = cfg.getTemplate("orderPdf.html");
		StringWriter writer = new StringWriter();
        //模版和数据匹配
		temp.process(root, writer);
        writer.flush();
        String html = writer.toString();
		System.out.println(html);
        ITextRenderer renderer = new ITextRenderer();
        
        renderer.setDocumentFromString(html);
        renderer.getSharedContext().setBaseURL("file:/d:/savePath/template/");
        FileOutputStream os = new FileOutputStream(new File("D:/pdf.pdf"));
		renderer.layout();
		renderer.createPDF(os, true);

		os.flush();
		
	}
}
