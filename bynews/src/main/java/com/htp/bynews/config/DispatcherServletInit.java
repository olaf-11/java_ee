package com.htp.bynews.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInit extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Hibernate factory config, Web Security config classes
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Web MVC config class
		return new Class[] { AppWebMvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		// Set up URL mapping for Spring MVC Dispatcher Servlet
		return new String[] { "/" };
	}

}
