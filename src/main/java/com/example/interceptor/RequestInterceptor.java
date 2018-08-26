package com.example.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.ContentCachingRequestWrapper;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpServletRequest requestCacheWrapperObject
	      = new ContentCachingRequestWrapper(request);
		
		Map<String, String[]> requestParamMap = requestCacheWrapperObject.getParameterMap();
		
		System.out.println("***********************************************");
		System.out.println("**************Requst Params********************");
		requestParamMap.keySet().forEach( s-> System.out.println("Key :"+s+" Value :"+requestParamMap.get(s)));
		System.out.println("***********************************************");
		
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
			
		super.afterCompletion(request, response, handler, ex);
	}

	
}
