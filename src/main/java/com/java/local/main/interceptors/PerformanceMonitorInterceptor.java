package com.java.local.main.interceptors;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class PerformanceMonitorInterceptor implements HandlerInterceptor {

	Logger logger = Logger.getLogger(this.getClass());

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) throws Exception {
		long endTime = System.currentTimeMillis();
		long startTime = (long) request.getAttribute("startTime");
		logger.info(
				"Total time taken by request to complete the request" + ((endTime - startTime) / 1000) + " seconds");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView view)
			throws Exception {
		logger.info("Request Processing ended on " + this.getCurrentTime());

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		long startTime = System.currentTimeMillis();
		logger.info("Request URL : " + request.getRequestURL().toString() + " started at " + this.getCurrentTime());
		request.setAttribute("startTime", startTime);
		return true;
	}

	private String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("DD/MM/YYYY 'at' hh:mm:ss");
		Calendar calander = Calendar.getInstance();
		calander.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calander.getTime());
	}

}
