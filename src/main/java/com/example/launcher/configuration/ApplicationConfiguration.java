package com.example.launcher.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.interceptor.RequestInterceptor;

@Configuration
@ImportResource(locations = {"classpath*:spring/application-context.xml"})
@PropertySource("classpath:/com/example/model/properties/mustache_page.properties")
public class ApplicationConfiguration  implements WebMvcConfigurer {

	 @Autowired
	 private RequestInterceptor requestInterceptor;
	
	@Bean
	public String someDummyBean1() {
		return "someDummyBean1";
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestInterceptor).addPathPatterns("/**/mustache/**/");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	
}
