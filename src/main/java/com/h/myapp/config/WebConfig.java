package com.h.myapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements  WebMvcConfigurer {
	@Value("${my.savePath}")
	private String savePath;
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		 TODO Auto-generated method stubw
		//添加一个对//任意url的映射,映射到 本地的 savepath路径
		registry.addResourceHandler("/**")
        .addResourceLocations("file:"+savePath,"classpath:/static/","classpath:/templates/","classpath:/public/");
//		
	}
	@Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**");

        // Add more mappings...
    }
}
